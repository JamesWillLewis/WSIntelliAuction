package com.uct.cs.wsintelliauction.client.backend;

import com.uct.cs.wsintelliauction.client.backend.net.ClientMessageParser;
import com.uct.cs.wsintelliauction.client.backend.net.ClientNetworkManager;
import com.uct.cs.wsintelliauction.client.backend.net.StorableServerList;
import com.uct.cs.wsintelliauction.client.frontend.ClientWindowManager;
import com.uct.cs.wsintelliauction.db.orm.DatabaseManager;
import com.uct.cs.wsintelliauction.net.MessageParser;
import com.uct.cs.wsintelliauction.util.ResourceManager;
import com.uct.cs.wsintelliauction.util.ThreadManager;

public class ClientResourceManager extends ResourceManager {

	/*
	 * Manager resources:
	 */

	/**
	 * Window manager for server-side administrator GUI.
	 */
	private ClientWindowManager windowManager;
	/**
	 * Server network manager.
	 */
	private ClientNetworkManager networkManager;

	/**
	 * Database manager
	 */
	private DatabaseManager databaseManager;
	
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

	public ClientResourceManager(String[] args) {
		super(args);
	}

	@Override
	public void initManagers() {
		splashLoader.updateLoader("Establishing database connection", 40);
		databaseManager = new DatabaseManager();
		
		splashLoader.updateLoader("Configuring network interface", 60);
		networkManager = new ClientNetworkManager(this);
		
		splashLoader.updateLoader("Initializing graphical user interface", 80);
		windowManager = new ClientWindowManager(this);
		
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

	public ClientWindowManager getWindowManager() {
		return windowManager;
	}


	public ClientNetworkManager getNetworkManager() {
		return networkManager;
	}


	public StorableServerList getStorableServerList() {
		return storableServerList;
	}

	@Override
	public void close() {
		storeSerializedResources();
		databaseManager.close();
		networkManager.close();
		ThreadManager.closeThreads();
	}

	@Override
	public MessageParser getMessageParser() {
		// TODO Auto-generated method stub
		return null;
	}

}
