package wsintelliauction.lib.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import wsintelliauction.lib.misc.ErrorLogger;
import wsintelliauction.lib.misc.ThreadManager;
import wsintelliauction.lib.net.message.Message;


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
	private final int DISPATCH_Q_SIZE = 128;
	/**
	 * Size of the receive queue.
	 */
	private final int RECEIVE_Q_SIZE = 128;

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
	 * The destination for this communication bridge.
	 */
	private Recipient recipient;
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
		dispatchCache = new ArrayBlockingQueue<Message>(DISPATCH_Q_SIZE);
		receiveCache = new ArrayBlockingQueue<Message>(RECEIVE_Q_SIZE);
		this.recipient = recipient;
		socket = new MessageSocket(recipient);
		connectionActive = true;
		dispatchActive = new AtomicBoolean(false);
		receiveActive = new AtomicBoolean(false);
	}

	public NetworkConnection(Socket s) {
		dispatchCache = new ArrayBlockingQueue<Message>(DISPATCH_Q_SIZE);
		receiveCache = new ArrayBlockingQueue<Message>(RECEIVE_Q_SIZE);
		socket = new MessageSocket(s);
		connectionActive = true;
		dispatchActive = new AtomicBoolean(false);
		receiveActive = new AtomicBoolean(false);
	}

	/**
	 * Begins the dispatch and receive loops, each in a worker thread allocated
	 * from the global thread pool.
	 */
	public void beginIOParsing() {
		if (connectionActive) {
			Runnable dispatchThread = new Runnable() {

				@Override
				public void run() {
					dispatchActive = new AtomicBoolean(true);
					dispatchCycle();
				}
			};
			Runnable receiveThread = new Runnable() {

				@Override
				public void run() {
					receiveActive = new AtomicBoolean(true);
					receiveCycle();
				}
			};

			ThreadManager.submitTask(dispatchThread);
			ThreadManager.submitTask(receiveThread);

		} else {
			ErrorLogger
					.log("Attempting to begin IO parsing on closed connection.");
		}
	}

	/**
	 * 
	 * @return Head of recieve queue
	 */
	public Message consumeMessage() {
		Message m = null;
		try {
			m = receiveCache.take();
		} catch (InterruptedException e) {
			ErrorLogger.log(e.getMessage());
		}
		return m;
	}

	/**
	 * 
	 * @param m
	 * @return true if successful, false is unsuccesful
	 */
	public boolean sendMessage(Message m) {
		boolean success = false;
		try {
			dispatchCache.put(m);
			success = true;
		} catch (InterruptedException e) {
			ErrorLogger.log(e.getMessage());
		}
		return success;
	}

	private void dispatchCycle() {
		while (dispatchActive.get()) {
			try {
				Message sendNext = dispatchCache.take();
				socket.writeMessage(sendNext);

			} catch (InterruptedException e) {
				ErrorLogger.log(e.getMessage());
			}
		}
	}

	private void receiveCycle() {
		while (receiveActive.get()) {
			try {
				Message m = socket.readMessage();
				receiveCache.put(m);
			} catch (InterruptedException e) {
				ErrorLogger.log(e.getMessage());
			}
		}
	}

}
