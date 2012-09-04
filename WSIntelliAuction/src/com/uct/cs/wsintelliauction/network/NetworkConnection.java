package com.uct.cs.wsintelliauction.network;

import java.io.BufferedReader;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.uct.cs.wsintelliauction.network_interface.message.Message;
import com.uct.cs.wsintelliauction.tools.ErrorLogger;

public class NetworkConnection {
	/**
	 * If this network connection is open
	 */
	private boolean connectionActive;
	/**
	 * If this network connection is currently dispatching messages
	 */
	private boolean dispatchActive;
	/**
	 * If this network connection is currently receiving messages
	 */
	private boolean receiveActive;
	/**
	 * Size of the dispatch queue
	 */
	private final int DISPATCH_Q_SIZE = 32;
	/**
	 * Size of the receive queue
	 */
	private final int RECEIVE_Q_SIZE = 32;

	/**
	 * Synchronized blocking queue which holds messages waiting to be trasmitted
	 */
	private BlockingQueue<Message> dispatchCache;

	/**
	 * Synchronized blocking queue which holds messages which have been received
	 */
	private BlockingQueue<Message> receiveCache;

	private Recipient recipient;

	public NetworkConnection() {
		dispatchCache = new ArrayBlockingQueue<Message>(DISPATCH_Q_SIZE);
		receiveCache = new ArrayBlockingQueue<Message>(RECEIVE_Q_SIZE);
	}

	/**
	 * 
	 */
	private void openConnection() {
		//init this connection
	}

	/**
	 * 
	 * @return Head of recieve queue
	 */
	private Message consumeNextMessage() {
		Message m = null;
		try {
			m = receiveCache.take();
		} catch (InterruptedException e) {
			ErrorLogger.submitError(e.getMessage());
		}
		return m;
	}

	private void dispatchLoop() {
		while (dispatchActive) {
			try {
				Message sendNext = dispatchCache.take();
		
				// send this message to a socket
			} catch (InterruptedException e) {
				ErrorLogger.submitError(e.getMessage());
			}
		}
	}

	private void receiveLoop() {
		while (receiveActive) {
			try {
				Message m = null;
				// fetch a message from the socket
				receiveCache.put(m);
			} catch (InterruptedException e) {
				ErrorLogger.submitError(e.getMessage());
			}
		}
	}

	/**
	 * 
	 * @param m
	 * @return true if successful, false is unsuccesful
	 */
	private boolean submitNextMessage(Message m) {
		boolean success = false;
		try {
			dispatchCache.put(m);
			success = true;
		} catch (InterruptedException e) {
			ErrorLogger.submitError(e.getMessage());
		}
		return success;
	}

}
