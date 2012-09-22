package com.uct.cs.wsintelliauction.net;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import com.uct.cs.wsintelliauction.net.message.CloseConnectionMessage;
import com.uct.cs.wsintelliauction.net.message.Message;
import com.uct.cs.wsintelliauction.util.ErrorLogger;
import com.uct.cs.wsintelliauction.util.EventLogger;
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

	private AtomicBoolean acceptEnqueue;

	private AtomicBoolean acceptConsume;

	/**
	 * If this network connection is currently dispatching messages.
	 */
	private AtomicBoolean dispatching;
	/**
	 * If this network connection is currently receiving messages.
	 */
	private AtomicBoolean receiving;
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
	 * Time in seconds allowed for an OFFER/POLL method to block.
	 */
	private final static int BLOCKING_TIMEOUT = 1;

	/**
	 * Delay after a connection shutdown for unsent/unconsumed messages to be
	 * serviced.
	 */
	private final static int CONNECTION_SHUTDOWN_TIMEOUT = 5;

	private final MessageParser messageParser;

	/**
	 * Establishes a network connection given a recipient. A new socket is
	 * opened for the given recipient, and a connection is established.
	 * 
	 * @param recipient
	 *            Defines the address of the socket.
	 * @throws IOException
	 *             If an error occurs while opening the socket.
	 */
	public NetworkConnection(Recipient recipient, MessageParser messageParser)
			throws IOException {
		dispatchCache = new ArrayBlockingQueue<Message>(DISPATCH_Q_SIZE, true);
		receiveCache = new ArrayBlockingQueue<Message>(RECEIVE_Q_SIZE, true);
		socket = new MessageSocket(recipient);
		connectionActive = true;
		dispatching = new AtomicBoolean(false);
		receiving = new AtomicBoolean(false);
		acceptConsume = new AtomicBoolean(false);
		acceptEnqueue = new AtomicBoolean(false);
		this.messageParser = messageParser;
		beginIOListening();
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
	public NetworkConnection(Socket s, MessageParser messageParser) {
		dispatchCache = new ArrayBlockingQueue<Message>(DISPATCH_Q_SIZE);
		receiveCache = new ArrayBlockingQueue<Message>(RECEIVE_Q_SIZE);
		socket = new MessageSocket(s);
		connectionActive = true;
		dispatching = new AtomicBoolean(false);
		receiving = new AtomicBoolean(false);
		acceptConsume = new AtomicBoolean(false);
		acceptEnqueue = new AtomicBoolean(false);
		this.messageParser = messageParser;
		beginIOListening();
	}

	/**
	 * Begins the dispatch and receive loops, each in a worker thread allocated
	 * from the global thread pool.
	 */
	private void beginIOListening() {
		if (connectionActive && !dispatching.get() && !receiving.get()) {
			Runnable dispatchThread = new Runnable() {

				@Override
				public void run() {
					acceptEnqueue.set(true);
					dispatching.set(true);
					dispatchListen();
				}
			};
			Runnable receiveThread = new Runnable() {

				@Override
				public void run() {
					receiving.set(true);
					recieveListen();
				}
			};

			Runnable submitToMessageParserThread = new Runnable() {

				@Override
				public void run() {
					acceptConsume.set(true);
					submitToMessageParserRoutine();
				}
			};

			ThreadManager.assignThread(dispatchThread);
			ThreadManager.assignThread(receiveThread);
			ThreadManager.assignThread(submitToMessageParserThread);
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
	public void submitToMessageParserRoutine() {
		while (acceptConsume.get()) {
			try {
				Message parseNext = receiveCache.poll(BLOCKING_TIMEOUT,
						TimeUnit.SECONDS);
				if (parseNext != null && messageParser != null) {
					messageParser.parseMessage(parseNext);
				}
			} catch (InterruptedException e) {
				ErrorLogger.log(e.getMessage());
			}
		}
	}

	/**
	 * Places a message in the dispatch queue.
	 * 
	 * @param m
	 *            Message to send.
	 * @return true if successful, false is unsuccesful
	 */
	public boolean enqueueMessage(Message m) {
		boolean success = false;
		// block until message has been submitted or no longer accepting
		// submission
		while (m != null && acceptEnqueue.get() && success == false) {
			try {
				success = dispatchCache.offer(m, BLOCKING_TIMEOUT,
						TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				ErrorLogger.log(e.getMessage());
			}
		}
		return success;
	}

	/**
	 * Poll the dispatch cache (waiting if necessary for message to become
	 * available) then and send message via message socket.
	 */
	private void dispatchListen() {
		while (dispatching.get()) {
			try {
				Message sendNext = dispatchCache.poll(BLOCKING_TIMEOUT,
						TimeUnit.SECONDS);
				if (sendNext != null)
					socket.writeMessage(sendNext);
			} catch (InterruptedException e) {
				ErrorLogger.log(e.getMessage());
			}
		}
	}

	/**
	 * Receive a message via the message socket (waiting if necessary for a
	 * message to arrive) and then place the message in the receive cache.
	 */
	private void recieveListen() {
		while (receiving.get()) {

			Message m = socket.readMessage();

			// recipient has informed that they want to disconnect
			if (m instanceof CloseConnectionMessage) {
				EventLogger.log("Received disconnect message from: "
						+ socket.getInetAddress().getHostName());
				// if the recipient was the initializer of the disconnect,
				// acknowledge the disconnect.
				if (((CloseConnectionMessage) m).isInitializer) {
					tellRecipientToDisconnect(false);
				}
				closeConnection();
			}

			// blocking while attempting to submit received message to cache
			if (m != null) {
				boolean insertSuccess = false;
				while (!insertSuccess && receiving.get()) {
					try {
						insertSuccess = receiveCache.offer(m, BLOCKING_TIMEOUT,
								TimeUnit.SECONDS);
					} catch (InterruptedException e) {
						ErrorLogger.log(e.getMessage());
					}
				}
			}
		}
	}

	/**
	 * Request the recipient to disconnect from this socket.
	 * @param isInitializer True if THIS application initialized the disconnect.
	 */
	public void tellRecipientToDisconnect(boolean isInitializer) {
		EventLogger.log("Informing recipient: "
				+ socket.getInetAddress().getHostName()
				+ " of connection closure.");
		// send a message to the receiving end informing them that the
		// transaction has closed
		enqueueMessage(new CloseConnectionMessage(isInitializer));
	}

	/**
	 * Close this connection.
	 * 
	 * TODO ensure closing the connection dispatches all unsent messages and
	 * saves the received (unprocessed) messages
	 */
	public void closeConnection() {
		// stop receiving messages from socket
		receiving.set(false);
		// stop allowing messages to be enqueued for dispatch
		acceptEnqueue.set(false);

		/*
		 * dispatching stays true, allowing unsent messages to be sent.
		 * acceptConsume stays true, allowing unconsumed messages to be
		 * consumed.
		 */

		// gives time for other messages to be consumed/sent.
		ThreadManager.pauseThisForSeconds(CONNECTION_SHUTDOWN_TIMEOUT);

		this.dispatching.set(false);
		this.acceptConsume.set(false);

		this.socket.closeSocket();
		this.connectionActive = false;
		EventLogger.log("Connection closed to: "
				+ socket.getInetAddress().getHostName());
	}

}
