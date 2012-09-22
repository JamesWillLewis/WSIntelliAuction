package com.uct.cs.wsintelliauction.server.backend;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceManager;
import com.uct.cs.wsintelliauction.util.AbstractDriver;

public class Driver extends AbstractDriver {

private ServerResourceManager serverResourceManager;
	

	public Driver(String[] args) {
		super(args);
		serverResourceManager = new ServerResourceManager(args);
	}

	@Override
	public void exec() {
		serverResourceManager.getServerWindowManager().launchMainWindow();
	}



}
