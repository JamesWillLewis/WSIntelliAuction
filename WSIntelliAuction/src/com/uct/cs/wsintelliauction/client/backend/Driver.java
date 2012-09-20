package com.uct.cs.wsintelliauction.client.backend;

import com.uct.cs.wsintelliauction.client.backend.net.ClientNetworkManager;
import com.uct.cs.wsintelliauction.client.frontend.ClientWindowManager;
import com.uct.cs.wsintelliauction.util.AbstractDriver;

public class Driver extends AbstractDriver {

	/**
	 * Window manager for server-side administrator GUI.
	 */
	private ClientWindowManager windowManager;
	/**
	 * Server network manager.
	 */
	private ClientNetworkManager networkManager;
	
	public static final int BACKLOG_CAPACITY = 128;

	public Driver(String[] args) {
		super(args);
	}

	@Override
	public void exec() {
		windowManager.launchMainWindow();

	}

	@Override
	protected void init() {
		windowManager = new ClientWindowManager();
		networkManager = new ClientNetworkManager();
	}

	@Override
	public void end() {
	
	}

}