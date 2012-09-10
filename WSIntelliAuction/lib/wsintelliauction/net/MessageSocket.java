package wsintelliauction.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import wsintelliauction.misc.ErrorLogger;
import wsintelliauction.net.message.Message;

/**
 * Wraps a standard network socket, adding functionality for
 * handling transission and reception of messages. 
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
	private ObjectOutputStream outputStream;
	/**
	 * Object stream from which message object are read.
	 */
	private ObjectInputStream inputStream;

	/**
	 * Construct the message socket, wrapping the given socket.
	 * @param socket Destination.
	 */
	public MessageSocket(Socket socket) {
		this.socket = socket;
		initStreams();
	}

	/**
	 * Construct a message socket, given a recipient. A socket for the
	 * recipient is instantiated.
	 * @param recipient Socket destination.
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
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			ErrorLogger.log("Unable to open object IO socket streams.");
		}
	}

	/**
	 * Close the input and output streams.
	 */
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
	 * Close the socket.
	 */
	public void closeSocket(){
		try {
			socket.close();
		} catch (IOException e) {
			ErrorLogger.log(e.getMessage());
		}
	}

	/**
	 * Write the message to the socket's output.
	 * @param m Message to write.
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
	 * Read a message from the socket's input.
	 * Will block if no messages immediatly in stream.
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
