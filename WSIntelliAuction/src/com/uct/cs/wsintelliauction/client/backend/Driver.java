package com.uct.cs.wsintelliauction.client.backend;

import java.io.File;
import java.io.ObjectInputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.uct.cs.wsintelliauction.client.backend.net.ClientNetworkManager;
import com.uct.cs.wsintelliauction.client.backend.net.StorableServerList;
import com.uct.cs.wsintelliauction.client.frontend.ClientWindowManager;
import com.uct.cs.wsintelliauction.db.orm.DatabaseManager;
import com.uct.cs.wsintelliauction.net.Recipient;
import com.uct.cs.wsintelliauction.util.AbstractDriver;
import com.uct.cs.wsintelliauction.util.ThreadManager;

public class Driver extends AbstractDriver {

	private ClientResourceManager clientResources;
	

	public Driver(String[] args) {
		super(args);
		clientResources = new ClientResourceManager(args);
	}

	@Override
	public void exec() {
		clientResources.getWindowManager().launchMainWindow();
	}

}