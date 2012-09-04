package com.uct.cs.wsintelliauction.network;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerNetworkInterface extends NetworkInterface {

	/**
	 * Arraylist of client connections wrapped in a synchronized container.
	 */
	private List<NetworkConnection> clientObjects;

	public ServerNetworkInterface() {
		clientObjects = Collections
				.synchronizedList(new ArrayList<NetworkConnection>());
	}
	
	

}
