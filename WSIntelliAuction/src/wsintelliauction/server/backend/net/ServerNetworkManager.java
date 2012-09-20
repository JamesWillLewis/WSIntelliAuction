package wsintelliauction.server.backend.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import wsintelliauction.net.NetworkConnection;
import wsintelliauction.net.NetworkManager;
import wsintelliauction.util.AppConfig;
import wsintelliauction.util.ErrorLogger;
import wsintelliauction.util.EventLogger;
import wsintelliauction.util.ThreadManager;

public class ServerNetworkManager implements NetworkManager {

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

	public ServerNetworkManager() {
		clientObjects = new ArrayBlockingQueue<>(MAX_CLIENT_CONNECTIONS, true);
		serverActive = new AtomicBoolean(false);
	}

	/**
	 * Initializes and launches the server, and begins accepting incoming client
	 * connection requests.
	 */
	public void startServer() {
		try {
			// launch the server
			serverSocket = new ServerSocket(Integer.parseInt(AppConfig
					.getProperty("port")), MAX_CLIENT_CONNECTIONS);
			EventLogger.log("Server now running on host-address: "
					+ serverSocket.getInetAddress().getHostName()
					+ " on port: " + serverSocket.getLocalPort());
			serverActive.set(true);
			beginAcceptClientCycle();
		} catch (IOException e) {
			ErrorLogger.log(e.getMessage());
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
				
				//add code to disconnect each client socket
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
							incoming);
					clientObjects.add(connection);
					
				} else {
					// reject the connection
					incoming.close();
				}
			} catch (SocketException e) {
				if(serverSocket.isClosed())
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

}
