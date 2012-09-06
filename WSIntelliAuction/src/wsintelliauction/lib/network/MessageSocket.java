package wsintelliauction.lib.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import wsintelliauction.lib.misc.ErrorLogger;
import wsintelliauction.lib.network.message.Message;


public class MessageSocket {

	/**
	 * Underlying application layer socket.
	 */
	private Socket socket;
	/**
	 * Object stream to which message objects are written.
	 */
	private ObjectOutputStream outputStream;
	/**
	 * Object stream from which message object are read.
	 */
	private ObjectInputStream inputStream;

	public MessageSocket(Socket socket) {
		this.socket = socket;
		initStreams();
	}

	public MessageSocket(Recipient recipient) throws IOException {
		this(new Socket(recipient.getInetAddress(), recipient.getPortNumber()));
	}

	private void initStreams() {
		try {
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			ErrorLogger.log("Unable to open object IO socket streams.");
		}
	}
;
	public void closeStreams() {
		try {
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			ErrorLogger
					.log("Error while closing object IO socket streams.");
		}
	}

	/**
	 * 
	 * @param m
	 * @return True if successful, false if write failed.
	 */
	public boolean writeMessage(Message m) {
		try {
			outputStream.writeObject(m);
			outputStream.flush();
			return true;
		} catch (IOException e) {
			ErrorLogger
					.log("Error writing message to socket object output stream.");
			return false;
		}
	}

	/**
	 * 
	 * @return Next read message in stream, or null if failed.
	 */
	public Message readMessage() {
		Message m = null;
		try {
			m = (Message) inputStream.readObject();
		} catch (IOException e) {
			ErrorLogger
					.log("Error reading message from socket object input stream.");
		} catch (ClassNotFoundException e) {
			ErrorLogger
					.log("Class type of object message read from object input stream invalid.");
		}
		return m;
	}

}
