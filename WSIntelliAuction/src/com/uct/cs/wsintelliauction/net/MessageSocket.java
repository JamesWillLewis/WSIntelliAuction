package com.uct.cs.wsintelliauction.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.locks.ReentrantLock;

import com.uct.cs.wsintelliauction.net.message.Message;
import com.uct.cs.wsintelliauction.net.message.CloseConnectionMessage;
import com.uct.cs.wsintelliauction.util.ErrorLogger;

/**
 * Wraps a standard network socket, adding functionality for handling
 * transmission and reception of messages.
 * 
 * @author James Lewis
 * 
 */
public class MessageSocket {

	/**
	 * Underlying application layer socket.
	 */
	private Socket socket;
	/**
	 * Object stream to which message objects are written.
	 */
	private OutputStream outputStream;
	/**
	 * Object stream from which message object are read.
	 */
	private InputStream inputStream;

	private ReentrantLock ioSyncLock;

	/**
	 * Construct the message socket, wrapping the given socket.
	 * 
	 * @param socket
	 *            Destination.
	 */
	public MessageSocket(Socket socket) {
		this.socket = socket;
		ioSyncLock = new ReentrantLock(true);
		initStreams();
	}

	/**
	 * Construct a message socket, given a recipient. A socket for the recipient
	 * is instantiated.
	 * 
	 * @param recipient
	 *            Socket destination.
	 * @throws IOException
	 */
	public MessageSocket(Recipient recipient) throws IOException {
		this(new Socket(recipient.getInetAddress(), recipient.getPortNumber()));
	}

	/**
	 * Initialize the input and output object streams.
	 */
	private void initStreams() {
		try {
			outputStream = socket.getOutputStream();
			inputStream = socket.getInputStream();
		} catch (IOException e) {
			ErrorLogger.log("Unable to open object IO socket streams.");
		}
	}

	/**
	 * Close the socket.
	 */
	public void closeSocket() {
		try {
			socket.close();
		} catch (IOException e) {
			ErrorLogger.log(e.getMessage());
		}
	}

	/**
	 * Write the message to the socket's output.
	 * 
	 * @param m
	 *            Message to write.
	 * @return True if successful, false if write failed.
	 */
	public boolean writeMessage(Message m) {
		try {
			ByteArrayOutputStream packet = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(packet);
			oos.writeObject(m);

			outputStream.write(packet.toByteArray());
			outputStream.flush();

			return true;
		} catch (SocketException e) {
			if (!socket.isClosed())
				ErrorLogger.log(e.getMessage());
			else {
				// socket stream closed
			}
			return false;
		} catch (IOException e) {
			ErrorLogger
					.log("Error writing message to socket object output stream.");
			return false;
		}
	}

	/**
	 * Read a message from the socket's input. Will block if no messages
	 * immediatly in stream.
	 * 
	 * @return Next read message in stream, or null if failed.
	 */
	public Message readMessage() {
		Message m = null;
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(
					inputStream);
			m = (Message) objectInputStream.readObject();

		} catch (SocketException e) {
			if (!socket.isClosed()) {
				ErrorLogger
						.log("IO exception occurred on read stream operation: Recipient probably disconnected without notice.");
				m = new CloseConnectionMessage(true);
				((CloseConnectionMessage) m).communicationFail = true;
			} else {
				// socket closed
			}
		} catch (IOException e) {
			ErrorLogger.log(e.getMessage());
		} catch (ClassNotFoundException e) {
			ErrorLogger
					.log("Class type of object message read from object input stream invalid.");
		}

		return m;
	}

	public InetAddress getInetAddress() {
		return socket.getInetAddress();
	}

}
