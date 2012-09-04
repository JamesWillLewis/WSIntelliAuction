package com.uct.cs.wsintelliauction.network;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerNetworkInterface extends NetworkInterface {

	/**
	 * Arraylist of client connections wrapped in a synchronized container.
	 */
	private List<NetworkConnection> clientObjects;
	/**
	 * Pool of worker threads to hande each recipient socket
	 */
	private ExecutorService clientThreads; 
	/**
	 * 
	 */
	public final int MAX_CLIENT_CONNECTIONS = 32;

	public ServerNetworkInterface() {
		clientObjects = Collections
				.synchronizedList(new ArrayList<NetworkConnection>());
		clientThreads = Executors.newFixedThreadPool(MAX_CLIENT_CONNECTIONS);
	}
	
	

}
