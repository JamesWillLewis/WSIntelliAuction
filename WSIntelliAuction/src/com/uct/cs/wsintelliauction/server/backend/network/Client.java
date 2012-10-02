package com.uct.cs.wsintelliauction.server.backend.network;

import com.uct.cs.wsintelliauction.network.NetworkConnection;

/**
 * A wrapper for a client. Wraps the connection and the recipient together in one
 * container.
 * @author James Lewis
 *
 */
public class Client {

	private NetworkConnection connection;
	

	public Client(NetworkConnection connection) {
		this.connection = connection;
	}
	
	public NetworkConnection getConnection() {
		return connection;
	}

	
}
