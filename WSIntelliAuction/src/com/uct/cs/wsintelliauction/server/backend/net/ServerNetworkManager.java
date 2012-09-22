package com.uct.cs.wsintelliauction.server.backend.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import com.uct.cs.wsintelliauction.net.NetworkConnection;
import com.uct.cs.wsintelliauction.net.NetworkManager;
import com.uct.cs.wsintelliauction.net.message.CloseConnectionMessage;
import com.uct.cs.wsintelliauction.util.AppConfig;
import com.uct.cs.wsintelliauction.util.ErrorLogger;
import com.uct.cs.wsintelliauction.util.EventLogger;
import com.uct.cs.wsintelliauction.util.ResourceManager;
import com.uct.cs.wsintelliauction.util.ThreadManager;

public class ServerNetworkManager extends NetworkManager {

	/**
	 * If server is running
	 */
	private AtomicBoolean serverActive;
	/**
	 * Arraylist of client connections wrapped in a synchronized container.
	 */
	private BlockingQueue<NetworkConnection> clientObjects;

	/**
	 * Maximum amount of concurrently connected clients
	 */
	public final static int MAX_CLIENT_CONNECTIONS = 128;

	private ServerSocket serverSocket;

	public ServerNetworkManager(ResourceManager resourceManager) {
		super(resourceManager);
		clientObjects = new ArrayBlockingQueue<>(MAX_CLIENT_CONNECTIONS, true);
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
				serverSocket.close();

				for(NetworkConnection con: clientObjects){
					con.tellRecipientToDisconnect(true);
				}
				EventLogger.log("Server has shut down - all connections closed.");
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
		ThreadManager.assignThread(acceptTask);
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
							incoming, resourceManager.getMessageParser());
					clientObjects.add(connection);

				} else {
					// reject the connection
					incoming.close();
				}
			} catch (SocketException e) {
				if (serverSocket.isClosed())
					break;
				else
					ErrorLogger.log(e.getMessage());
			} catch (IOException e) {
				ErrorLogger.log(e.getMessage());

			}
		}
	}

	/**
	 * Returns the next client from the client connect queue.
	 * 
	 * @return
	 */
	public NetworkConnection pollNextClient() {
		try {
			return clientObjects.take();
		} catch (InterruptedException e) {
			// clients queue is closed
			return null;
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
		if(serverSocket != null){
			try {
				return InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				ErrorLogger.log(e.toString());
				return null;
			}
		} else{
			return null;
		}
	}

	public int getServerPortNumber() {
		if(serverSocket != null){
			return serverSocket.getLocalPort();
		} else{
			return -1;
		}
	}
	
	public int getNumberOfConnections(){
		return clientObjects.size();
	}

}
