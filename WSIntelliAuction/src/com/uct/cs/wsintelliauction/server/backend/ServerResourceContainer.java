package com.uct.cs.wsintelliauction.server.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.uct.cs.wsintelliauction.db.orm.ObjectDatabaseDriver;
import com.uct.cs.wsintelliauction.net.MessageParser;
import com.uct.cs.wsintelliauction.server.backend.net.Client;
import com.uct.cs.wsintelliauction.server.backend.net.ServerMessageParser;
import com.uct.cs.wsintelliauction.server.backend.net.ServerNetworkDriver;
import com.uct.cs.wsintelliauction.server.frontend.ServerWindowDriver;
import com.uct.cs.wsintelliauction.util.ResourceContainer;
import com.uct.cs.wsintelliauction.util.ThreadHandler;

public class ServerResourceContainer extends ResourceContainer {

	/**
	 * Server network manager
	 */
	private ServerNetworkDriver serverNetworkDriver;

	/**
	 * Server database manager
	 */
	private ObjectDatabaseDriver objectDatabaseDriver;

	/**
	 * Server window manager
	 */
	private ServerWindowDriver serverWindowDriver;

	/**
	 * Server message manager
	 */
	private ServerMessageParser serverMessageParser;

	private List<Client> clients;

	public ServerResourceContainer(String[] args) {
		super(args);
	}

	@Override
	protected void loadInstanceResources() {
		clients = Collections.synchronizedList(new ArrayList<Client>());
	}

	@Override
	public void initManagers() {
		splashLoader.updateLoader("Establishing database connection", 40);
		objectDatabaseDriver = new ObjectDatabaseDriver();

		splashLoader.updateLoader("Configuring network interface", 60);
		serverNetworkDriver = new ServerNetworkDriver(this, clients);

		splashLoader.updateLoader("Initializing graphical user interface", 80);
		serverWindowDriver = new ServerWindowDriver(this);

		splashLoader.updateLoader("Initializing message parser", 90);
		serverMessageParser = new ServerMessageParser(this);
	}

	public ServerNetworkDriver getServerNetworkManager() {
		return serverNetworkDriver;
	}

	public ObjectDatabaseDriver getDatabaseDriver() {
		return objectDatabaseDriver;
	}

	public ServerWindowDriver getServerWindowManager() {
		return serverWindowDriver;
	}

	@Override
	public MessageParser<ServerResourceContainer> getMessageParser() {
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
		objectDatabaseDriver.close();
		serverNetworkDriver.close();
		ThreadHandler.closeThreads();
	}
	
	public List<Client> getClients() {
		return clients;
	}

}
