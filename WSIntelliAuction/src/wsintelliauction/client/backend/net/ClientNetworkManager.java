package wsintelliauction.client.backend.net;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import wsintelliauction.net.NetworkConnection;
import wsintelliauction.net.NetworkManager;
import wsintelliauction.net.Recipient;
import wsintelliauction.net.message.Message;
import wsintelliauction.util.ErrorLogger;
import wsintelliauction.util.EventLogger;

public class ClientNetworkManager implements NetworkManager {

	private NetworkConnection serverConnection;

	private AtomicBoolean isConnected;

	public ClientNetworkManager() {
		serverConnection = null;
		isConnected = new AtomicBoolean(false);
	}

	/**
	 * Connects this client to the specified server.
	 * 
	 * @param server
	 *            Server recipient to connect to.
	 * @return True if connection was succesful.
	 */
	public boolean connectTo(Recipient server) {
		try {
			serverConnection = new NetworkConnection(server);
			EventLogger.log("Client now connected to server: "
					+ server.getIPAddressString() + " on port: "
					+ server.getPortNumber());
			isConnected.set(true);
			return true;
		} catch (IOException e) {
			ErrorLogger.log(e.getMessage());
			return false;
		}
	}

	/**
	 * Disconnect the client from the server.
	 */
	public void disconnect() {
		if (isConnected.get()) {
			serverConnection.closeConnection();
			isConnected.set(false);
		}
	}

	public void dispatchMessage(Message m) {
		if (isConnected.get())
			serverConnection.sendMessage(m);
	}

	public Message consumeMessage() {
		if (isConnected.get())
			return serverConnection.consumeMessage();
		else
			return null;
	}

}
