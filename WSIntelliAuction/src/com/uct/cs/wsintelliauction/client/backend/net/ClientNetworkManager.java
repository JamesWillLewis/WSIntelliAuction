package com.uct.cs.wsintelliauction.client.backend.net;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import com.uct.cs.wsintelliauction.net.NetworkConnection;
import com.uct.cs.wsintelliauction.net.NetworkManager;
import com.uct.cs.wsintelliauction.net.Recipient;
import com.uct.cs.wsintelliauction.net.message.Message;
import com.uct.cs.wsintelliauction.util.ErrorLogger;
import com.uct.cs.wsintelliauction.util.EventLogger;
import com.uct.cs.wsintelliauction.util.ResourceManager;


public class ClientNetworkManager extends NetworkManager {

	/**
	 * Network connectiont to central server
	 */
	private NetworkConnection serverConnection;

	/**
	 * If connection is active
	 */
	private AtomicBoolean connected;


	public ClientNetworkManager(ResourceManager resourceManager) {
		super(resourceManager);
		serverConnection = null;
		connected = new AtomicBoolean(false);
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
			serverConnection = new NetworkConnection(server, resourceManager.getMessageParser());
			EventLogger.log("Client now connected to server: "
					+ server.getIPAddressString() + " on port: "
					+ server.getPortNumber());
			connected.set(true);
			return true;
		} catch (Exception e) {
			ErrorLogger.log(e.getMessage());
			return false;
		}
	}

	/**
	 * Disconnect the client from the server.
	 */
	public void disconnect() {
		if (connected.get()) {
			serverConnection.tellRecipientToDisconnect(true);
			connected.set(false);
		}
	}

	public void dispatchMessage(Message m) {
		if (connected.get())
			serverConnection.enqueueMessage(m);
	}

	@Override
	public void close() {
		disconnect();
	}

}
