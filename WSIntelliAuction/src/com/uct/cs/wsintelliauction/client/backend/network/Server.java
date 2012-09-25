package com.uct.cs.wsintelliauction.client.backend.network;

import com.uct.cs.wsintelliauction.network.NetworkConnection;
import com.uct.cs.wsintelliauction.network.message.Message;

/**
 * A wrapper for a server. Wraps the connection and the recipient together in one
 * container.
 * @author James Lewis
 *
 */
public class Server {

	/**
	 * Connection for this server
	 */
	private NetworkConnection connection;


	public Server(NetworkConnection connection) {
		this.connection = connection;
	}

	public void sendMessage(Message m){
		if(connection != null){
			connection.enqueueMessage(m);
		}
	}
	
	public NetworkConnection getConnection() {
		return connection;
	}
	
}
