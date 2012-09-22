package com.uct.cs.wsintelliauction.net;

import com.uct.cs.wsintelliauction.util.ResourceManager;

/**
 * Interface defining an application's network manager.
 * A network manager must handle the creation and management of
 * all sockets (and connection requests), as well as management of incoming
 * and outgoing data messages.
 * 
 * @author James Lewis
 *
 */
public abstract class NetworkManager {
	
	
	protected ResourceManager resourceManager;

	public NetworkManager(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}
	
	public abstract void close();
	
}
