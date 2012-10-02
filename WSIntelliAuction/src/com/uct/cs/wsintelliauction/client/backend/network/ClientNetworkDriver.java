package com.uct.cs.wsintelliauction.client.backend.network;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceContainer;
import com.uct.cs.wsintelliauction.network.NetworkConnection;
import com.uct.cs.wsintelliauction.network.NetworkDriver;
import com.uct.cs.wsintelliauction.network.Recipient;
import com.uct.cs.wsintelliauction.network.message.Message;
import com.uct.cs.wsintelliauction.utility.ErrorLogger;
import com.uct.cs.wsintelliauction.utility.EventLogger;
import com.uct.cs.wsintelliauction.utility.ResourceContainer;

public class ClientNetworkDriver extends NetworkDriver<ClientResourceContainer> {

	/**
	 * Network connection to central server
	 */
	private Server serverConnection;

	/**
	 * If connection is active
	 */
	private AtomicBoolean connected;

	public ClientNetworkDriver(ClientResourceContainer resourceManager) {
		super(resourceManager);
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
			serverConnection = new Server(new NetworkConnection(server,
					resourceManager.getMessageParser(), this));
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
			serverConnection.getConnection().requestDestToDisconnect(true);
			connected.set(false);
		}
	}

	@Override
	public void close() {
		disconnect();
	}

	@Override
	public void connectionWasClosed(NetworkConnection connection,
			boolean recipientInitialized) {
		if (recipientInitialized)
			resourceManager.getWindowManager().getMainWindowModule()
					.getNetworkTabModule().getModel().serverDisconnected();
	}
	
	public Server getServerConnection() {
		return serverConnection;
	}

}
