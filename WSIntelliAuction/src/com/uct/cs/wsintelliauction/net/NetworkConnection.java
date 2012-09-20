package com.uct.cs.wsintelliauction.net;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import com.uct.cs.wsintelliauction.net.message.Message;
import com.uct.cs.wsintelliauction.util.ErrorLogger;
import com.uct.cs.wsintelliauction.util.ThreadManager;


/**
 * Represent a single network connection, linking one source (the application)
 * to one destination (defined as a recipient). Handles creation of network
 * socket, as well as dispatching and receiving messages. Dispatch and receive
 * processes are fully concurrent. This class maintains 2 queues - dispatch and
 * receive queue - which are used for storing messages waiting to be sent, or
 * serviced (received from destination). The two queues are periodically polled
 * by independent threads.
 * 
 * @author James Lewis
 * 
 */
public class NetworkConnection {
	/**
	 * If this network connection is open.
	 */
	private boolean connectionActive;
	/**
	 * If this network connection is currently dispatching messages.
	 */
	private AtomicBoolean dispatchActive;
	/**
	 * If this network connection is currently receiving messages.
	 */
	private AtomicBoolean receiveActive;
	/**
	 * Size of the dispatch queue.
	 */
	private final int DISPATCH_Q_SIZE = 512;
	/**
	 * Size of the receive queue.
	 */
	private final int RECEIVE_Q_SIZE = 512;

	/**
	 * Synchronized blocking queue which holds messages waiting to be
	 * trasmitted.
	 */
	private BlockingQueue<Message> dispatchCache;

	/**
	 * Synchronized blocking queue which holds messages which have been
	 * received.
	 */
	private BlockingQueue<Message> receiveCache;

	/**
	 * Underlying message socket for this connection, allow parsing of IO
	 * messages.
	 */
	private MessageSocket socket;

	
	/**
	 * Establishes a network connection given a recipient. A new socket is
	 * opened for the given recipient, and a connection is established.
	 * 
	 * @param recipient
	 *            Defines the address of the socket.
	 * @throws IOException
	 *             If an error occurs while opening the socket.
	 */
	public NetworkConnection(Recipient recipient) throws IOException {
		dispatchCache = new ArrayBlockingQueue<Message>(DISPATCH_Q_SIZE, true);
		receiveCache = new ArrayBlockingQueue<Message>(RECEIVE_Q_SIZE, true);
		socket = new MessageSocket(recipient);
		connectionActive = true;
		dispatchActive = new AtomicBoolean(false);
		receiveActive = new AtomicBoolean(false);
		beginIOParsing();
	}

	/**
	 * Establishes a network connection given a socket. A new message socket is
	 * created for the given recipient, and a connection is established.
	 * 
	 * @param recipient
	 *            Defines the address of the socket.
	 * @throws IOException
	 *             If an error occurs while opening the socket.
	 */
	public NetworkConnection(Socket s) {
		dispatchCache = new ArrayBlockingQueue<Message>(DISPATCH_Q_SIZE);
		receiveCache = new ArrayBlockingQueue<Message>(RECEIVE_Q_SIZE);
		socket = new MessageSocket(s);
		connectionActive = true;
		dispatchActive = new AtomicBoolean(false);
		receiveActive = new AtomicBoolean(false);
		beginIOParsing();
	}

	/**
	 * Begins the dispatch and receive loops, each in a worker thread allocated
	 * from the global thread pool.
	 */
	private void beginIOParsing() {
		if (connectionActive && !dispatchActive.get() && !receiveActive.get()) {
			Runnable dispatchThread = new Runnable() {

				@Override
				public void run() {
					dispatchActive.set(true);
					dispatchCycle();
				}
			};
			Runnable receiveThread = new Runnable() {

				@Override
				public void run() {
					receiveActive.set(true);
					receiveCycle();
				}
			};

			ThreadManager.assignThread(dispatchThread);
			ThreadManager.assignThread(receiveThread);

		} else {
			ErrorLogger
					.log("Attempting to begin IO parsing on closed connection.");
		}
	}

	/**
	 * Pops the next message (in FIFO order) which was received.
	 * 
	 * @return Head of recieve queue
	 */
	public Message consumeMessage() {
		Message m = null;
		try {
			m = receiveCache.take();
		} catch (InterruptedException e) {
			//receive cache closed
		}
		return m;
	}

	/**
	 * Places a message in the dispatch queue.
	 * 
	 * @param m
	 *            Message to send.
	 * @return true if successful, false is unsuccesful
	 */
	public boolean sendMessage(Message m) {
		boolean success = false;
		try {
			dispatchCache.put(m);
			success = true;
		} catch (InterruptedException e) {
			//dispatch cache closed
		}
		return success;
	}

	/**
	 * Poll the dispatch cache (waiting if necessary for message to become
	 * available) then and send message via message socket.
	 */
	private void dispatchCycle() {
		while (dispatchActive.get()) {
			try {
				Message sendNext = dispatchCache.take();
				socket.writeMessage(sendNext);
			} catch (InterruptedException e) {
				//dispatch cache closed
			}
		}
	}

	/**
	 * Receive a message via the message socket (waiting if necessary for a
	 * message to arrive) and then place the message in the receive cache.
	 */
	private void receiveCycle() {
		while (receiveActive.get()) {
			try {
				Message m = socket.readMessage();
				receiveCache.put(m);
			} catch (InterruptedException e) {
				//receive cache closed
			}
		}
	}

	/**
	 * Close this connection.
	 */
	public void closeConnection() {
		this.receiveActive.set(false);
		this.dispatchActive.set(false);
		dispatchCache.notify();
		receiveCache.notify();
		this.socket.closeSocket();
		this.connectionActive = false;
	}

}
