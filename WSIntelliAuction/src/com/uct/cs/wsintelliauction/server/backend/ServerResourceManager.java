package com.uct.cs.wsintelliauction.server.backend;

import com.uct.cs.wsintelliauction.db.orm.DatabaseManager;
import com.uct.cs.wsintelliauction.net.MessageParser;
import com.uct.cs.wsintelliauction.server.backend.net.ServerMessageParser;
import com.uct.cs.wsintelliauction.server.backend.net.ServerNetworkManager;
import com.uct.cs.wsintelliauction.server.frontend.ServerWindowManager;
import com.uct.cs.wsintelliauction.util.ResourceManager;
import com.uct.cs.wsintelliauction.util.ThreadManager;

public class ServerResourceManager extends ResourceManager{
	
	/**
	 * Server network manager
	 */
	private ServerNetworkManager serverNetworkManager;
	
	/**
	 * Server database manager
	 */
	private DatabaseManager databaseManager;
	
	/**
	 * Server window manager
	 */
	private ServerWindowManager serverWindowManager;
	
	/**
	 * Server message manager
	 */
	private ServerMessageParser serverMessageParser;

	public ServerResourceManager(String[] args) {
		super(args);
	}
	

	@Override
	public void initManagers() {
		splashLoader.updateLoader("Establishing database connection", 40);
		databaseManager = new DatabaseManager();
		
		splashLoader.updateLoader("Configuring network interface", 60);
		serverNetworkManager = new ServerNetworkManager(this);
		
		splashLoader.updateLoader("Initializing graphical user interface", 80);
		serverWindowManager = new ServerWindowManager(this);
		
		splashLoader.updateLoader("Initializing message parser", 90);
		serverMessageParser = new ServerMessageParser(this);
	}
	
	public ServerNetworkManager getServerNetworkManager() {
		return serverNetworkManager;
	}

	public DatabaseManager getDatabaseManager() {
		return databaseManager;
	}

	public ServerWindowManager getServerWindowManager() {
		return serverWindowManager;
	}

	@Override
	public MessageParser<ServerResourceManager> getMessageParser() {
		return serverMessageParser;
	}

	@Override
	public void loadSerializedResources() {
		splashLoader.updateLoader("Loading serialized resources", 20);
	}

	@Override
	public void storeSerializedResources() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void close() {
		storeSerializedResources();
		databaseManager.close();
		serverNetworkManager.close();
		ThreadManager.closeThreads();
	}

}
