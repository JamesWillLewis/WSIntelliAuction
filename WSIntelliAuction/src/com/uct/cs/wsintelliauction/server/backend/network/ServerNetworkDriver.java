package com.uct.cs.wsintelliauction.server.backend.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import com.uct.cs.wsintelliauction.database.persistent.tables.Lease;
import com.uct.cs.wsintelliauction.network.NetworkConnection;
import com.uct.cs.wsintelliauction.network.NetworkDriver;
import com.uct.cs.wsintelliauction.network.message.LeaseBundle;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.utility.AppConfig;
import com.uct.cs.wsintelliauction.utility.ErrorLogger;
import com.uct.cs.wsintelliauction.utility.EventLogger;
import com.uct.cs.wsintelliauction.utility.ThreadHandler;

public class ServerNetworkDriver extends NetworkDriver<ServerResourceContainer> {

	/**
	 * If server is running
	 */
	private AtomicBoolean serverActive;
	/**
	 * Arraylist of client connections wrapped in a synchronized container.
	 */
	private List<Client> clientObjects;

	/**
	 * Maximum amount of concurrently connected clients
	 */
	public final static int MAX_CLIENT_CONNECTIONS = 128;

	/**
	 * Server accept socket
	 */
	private ServerSocket serverSocket;

	/**
	 * Construct a new server network manager without starting the server
	 * 
	 * @param resourceManager
	 */
	public ServerNetworkDriver(ServerResourceContainer resourceManager,
			List<Client> clientObjects) {
		super(resourceManager);
		this.clientObjects = clientObjects;
		serverActive = new AtomicBoolean(false);
	}

	/**
	 * Initializes and launches the server, and begins accepting incoming client
	 * connection requests.
	 */
	public void startServer() {
		if (!serverActive.get()) {
			try {
				// launch the server
				serverSocket = new ServerSocket(Integer.parseInt(AppConfig
						.getProperty("port")), MAX_CLIENT_CONNECTIONS);
				EventLogger.log("Server now running on host-address: "
						+ InetAddress.getLocalHost().getHostAddress()
						+ " on port: " + serverSocket.getLocalPort());
				serverActive.set(true);
				beginAcceptClientCycle();
			} catch (IOException e) {
				ErrorLogger.log(e.getMessage());
			}
		}
	}

	/**
	 * Shuts down the server and ignores all following connection requests.
	 */
	public void stopServer() {
		if (serverActive.get()) {
			serverActive.set(false);
			try {
				// stop accepting incoming connection requests
				serverSocket.close();

				for (Client con : clientObjects) {
					con.getConnection().requestDestToDisconnect(true);
				}
				EventLogger
						.log("Server has informed all connected clients of server shutdown.");
			} catch (IOException e) {
				ErrorLogger.log(e.getMessage());
			}
		}
	}

	/**
	 * Initiate a new thread for the accept client cycle and submit it to the
	 * thread manager.
	 */
	private void beginAcceptClientCycle() {
		Runnable acceptTask = new Runnable() {

			@Override
			public void run() {
				acceptClientCycle();
			}
		};
		ThreadHandler.assignThread(acceptTask);
	}

	/**
	 * While the server is active, accept incoming connections and append to the
	 * client list.
	 */
	private void acceptClientCycle() {
		while (serverActive.get()) {
			try {
				Socket incoming = serverSocket.accept();
				EventLogger.log("Client connected: "
						+ incoming.getInetAddress().getHostAddress());
				/*
				 * Will reject the connection if the connection exceeds the
				 * allowable number of concurrent connections, OR if the server
				 * active state is false - in case the server active state
				 * changed state while waiting on an incoming connection.
				 */
				if (clientObjects.size() < MAX_CLIENT_CONNECTIONS
						&& serverActive.get()) {
					// accept the connection
					NetworkConnection connection = new NetworkConnection(
							incoming, resourceManager.getMessageParser(), this);
					addClient(connection);
					resourceManager.getServerWindowManager()
							.getMainWindowModule().getClientsTabModule()
							.getController().newClientConnected();

				} else {
					// reject the connection
					incoming.close();
				}
			} catch (SocketException e) {
				if (serverSocket.isClosed()) {
					// server socket shutdown
					continue;
				} else
					ErrorLogger.log(e.getMessage());
			} catch (IOException e) {
				ErrorLogger.log(e.getMessage());

			}
		}
	}

	private void addClient(NetworkConnection connection) {
		if (clientObjects != null) {
			boolean clientExists = false;
			for (int i = 0; i < clientObjects.size(); i++) {
				Client c = clientObjects.get(i);
				if (c.getConnection().getRecipientAddress()
						.equals(connection.getRecipientAddress())) {
					System.out.println("CLIENT RECONNECT");
					c = new Client(connection);
					clientObjects.set(i, c);
					clientExists = true;
				}
			}
			if (!clientExists)
				clientObjects.add(new Client(connection));
			ArrayList<Lease> leases = resourceManager
					.getDatabaseDriver().query(
							"FROM Lease WHERE secondaryUserID LIKE '"
									+ connection.getRecipientAddress()
											.getHostAddress() + "'");
			LeaseBundle bundle = new LeaseBundle(leases);
			connection.enqueueMessage(bundle);

			// inform client of auction (if there is one active)
			if (resourceManager.getSpectrumBroker().getCurrentAuction() != null
					&& resourceManager.getSpectrumBroker().getCurrentAuction()
							.getAuctionOn().get()) {
				EventLogger.log("Informing client: "
						+ connection.getRecipientAddress().getHostName()
						+ " of auction.");
				connection.enqueueMessage(resourceManager.getSpectrumBroker()
						.getCurrentAuction().getAuctionMessage());
			}

		}
	}

	@Override
	public void close() {
		stopServer();
	}

	public AtomicBoolean getServerActive() {
		return serverActive;
	}

	public InetAddress getServerHostAddress() {
		if (serverSocket != null) {
			try {
				return InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				ErrorLogger.log(e.toString());
				return null;
			}
		} else {
			return null;
		}
	}

	public int getServerPortNumber() {
		if (serverSocket != null) {
			return serverSocket.getLocalPort();
		} else {
			return -1;
		}
	}

	public int getNumberOfConnections() {
		return clientObjects.size();
	}

	@Override
	public void connectionWasClosed(NetworkConnection connection,
			boolean recipientInitialized) {
		resourceManager.getServerWindowManager().getMainWindowModule()
				.getClientsTabModule().getController().clientDisconncted();
	}

}
