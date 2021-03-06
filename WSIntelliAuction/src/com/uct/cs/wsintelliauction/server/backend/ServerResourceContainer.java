package com.uct.cs.wsintelliauction.server.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.uct.cs.wsintelliauction.auction.SpectrumBroker;
import com.uct.cs.wsintelliauction.database.persistent.ObjectDatabaseDriver;
import com.uct.cs.wsintelliauction.network.MessageParser;
import com.uct.cs.wsintelliauction.server.backend.network.Client;
import com.uct.cs.wsintelliauction.server.backend.network.ServerMessageParser;
import com.uct.cs.wsintelliauction.server.backend.network.ServerNetworkDriver;
import com.uct.cs.wsintelliauction.server.frontend.ServerWindowDriver;
import com.uct.cs.wsintelliauction.utility.ResourceContainer;
import com.uct.cs.wsintelliauction.utility.ThreadHandler;

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

	/**
	 * List of connected clients
	 */
	private List<Client> clients;
	/**
	 * The currently active auction
	 */
	private SpectrumBroker spectrumBroker;

	public ServerResourceContainer(String[] args) {
		super(args);
	}

	@Override
	protected void loadInstanceResources() {
		clients = Collections.synchronizedList(new ArrayList<Client>());
	}

	@Override
	public void initManagers() {
		splashLoader.updateLoader("Initializing spectrum broker", 20);
		spectrumBroker = new SpectrumBroker(this);
		
		splashLoader.updateLoader("Establishing database connection", 40);
		objectDatabaseDriver = new ObjectDatabaseDriver();

		splashLoader.updateLoader("Configuring network interface", 60);
		serverNetworkDriver = new ServerNetworkDriver(this, clients);

		splashLoader.updateLoader("Initializing graphical user interface", 80);
		serverWindowDriver = new ServerWindowDriver(this);

		splashLoader.updateLoader("Initializing message parser", 90);
		serverMessageParser = new ServerMessageParser(this);
		
		
		
		splashLoader.updateLoader("Initializing server", 99);
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
		spectrumBroker.close();
		ThreadHandler.closeThreads();
	}
	
	public List<Client> getClients() {
		return clients;
	}
	
	public SpectrumBroker getSpectrumBroker() {
		return spectrumBroker;
	}

}
