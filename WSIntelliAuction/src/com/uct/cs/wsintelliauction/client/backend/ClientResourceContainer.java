package com.uct.cs.wsintelliauction.client.backend;

import com.uct.cs.wsintelliauction.client.backend.network.ClientMessageParser;
import com.uct.cs.wsintelliauction.client.backend.network.ClientNetworkDriver;
import com.uct.cs.wsintelliauction.client.backend.network.Server;
import com.uct.cs.wsintelliauction.client.backend.network.StorableServerList;
import com.uct.cs.wsintelliauction.client.frontend.ClientWindowDriver;
import com.uct.cs.wsintelliauction.network.MessageParser;
import com.uct.cs.wsintelliauction.server.backend.network.ServerMessageParser;
import com.uct.cs.wsintelliauction.utility.ResourceContainer;
import com.uct.cs.wsintelliauction.utility.ThreadHandler;

public class ClientResourceContainer extends ResourceContainer {

	/*
	 * General resources:
	 */

	private Server server;

	/*
	 * Manager resources:
	 */

	/**
	 * Window manager for server-side administrator GUI.
	 */
	private ClientWindowDriver windowManager;
	/**
	 * Server network manager.
	 */
	private ClientNetworkDriver networkManager;

	/**
	 * Client message parser
	 */
	private ClientMessageParser clientMessageParser;

	/*
	 * Serialized resources:
	 */

	/**
	 * List of all registered servers
	 */
	private StorableServerList storableServerList;

	public ClientResourceContainer(String[] args) {
		super(args);
	}

	@Override
	protected void loadInstanceResources() {
		server = null;
	}

	@Override
	public void initManagers() {
		splashLoader.updateLoader("Establishing database connection", 40);

		splashLoader.updateLoader("Configuring network interface", 60);
		networkManager = new ClientNetworkDriver(this, server);

		splashLoader.updateLoader("Initializing graphical user interface", 80);
		windowManager = new ClientWindowDriver(this);

		splashLoader.updateLoader("Initializing message parser", 90);
		clientMessageParser = new ClientMessageParser(this);
	}

	@Override
	public void loadSerializedResources() {
		splashLoader.updateLoader("Loading serialized resources", 20);
		storableServerList = new StorableServerList().load();
	}

	@Override
	public void storeSerializedResources() {
		storableServerList.store();
	}

	public ClientWindowDriver getWindowManager() {
		return windowManager;
	}

	public ClientNetworkDriver getNetworkManager() {
		return networkManager;
	}

	public StorableServerList getStorableServerList() {
		return storableServerList;
	}

	@Override
	public void close() {
		storeSerializedResources();
		networkManager.close();
		ThreadHandler.closeThreads();
	}

	@Override
	public ServerMessageParser getMessageParser() {
		// TODO Auto-generated method stub
		return null;
	}

}
