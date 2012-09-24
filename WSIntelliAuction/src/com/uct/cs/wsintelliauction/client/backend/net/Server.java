package com.uct.cs.wsintelliauction.client.backend.net;

import com.uct.cs.wsintelliauction.net.NetworkConnection;
import com.uct.cs.wsintelliauction.net.message.Message;

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
