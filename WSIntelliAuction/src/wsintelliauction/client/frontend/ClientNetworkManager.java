package wsintelliauction.client.frontend;

import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

import wsintelliauction.net.NetworkManager;

public class ClientNetworkManager implements NetworkManager {

	private Socket serverConnection;
	
	private AtomicBoolean isConnected;
	
	public ClientNetworkManager() {
		isConnected.set(false);
		serverConnection = new Socket();
	}
	
	public boolean connectTo(String hostAddress){
		
		serverConnection.
	}
	
	
	
	
}
