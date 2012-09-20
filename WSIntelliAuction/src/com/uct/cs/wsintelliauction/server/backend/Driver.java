package com.uct.cs.wsintelliauction.server.backend;

import com.uct.cs.wsintelliauction.server.backend.net.ServerNetworkManager;
import com.uct.cs.wsintelliauction.server.frontend.ServerWindowManager;
import com.uct.cs.wsintelliauction.util.AbstractDriver;
import com.uct.cs.wsintelliauction.util.ThreadManager;

public class Driver extends AbstractDriver {

	/**
	 * Window manager for server-side administrator GUI.
	 */
	private ServerWindowManager windowManager;
	
	/**
	 * Server network manager.
	 */
	private ServerNetworkManager networkManager;
	
	
	

	public static final int BACKLOG_CAPACITY = 512;
	
	public Driver(String[] args) {
		super(args);
	}

	@Override
	public void init() {
		//init the managers
		windowManager = new ServerWindowManager();
		networkManager = new ServerNetworkManager();
	}

	@Override
	public void exec() {
		windowManager.launchMainWindow();
	}

	@Override
	public void end() {
		ThreadManager.closeThreads();
	}

}
