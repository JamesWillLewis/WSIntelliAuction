package wsintelliauction.client.frontend;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import wsintelliauction.misc.ErrorLogger;
import wsintelliauction.net.NetworkConnection;
import wsintelliauction.net.NetworkManager;
import wsintelliauction.net.Recipient;
import wsintelliauction.net.message.Message;



public class ClientNetworkManager implements NetworkManager {

	private NetworkConnection serverConnection;

	private AtomicBoolean isConnected;

	public ClientNetworkManager() {
		isConnected.set(false);
	}

	/**
	 * Connects this client to the specified server.
	 * @param server Server recipient to connect to.
	 * @return True if connection was succesful.
	 */
	public boolean connectTo(Recipient server) {
		try {
			serverConnection = new NetworkConnection(server);
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
	public void disconnect(){
		serverConnection.closeConnection();
	}
	
	public void sendToServer(Message m){
		serverConnection.sendMessage(m);
	}

}
