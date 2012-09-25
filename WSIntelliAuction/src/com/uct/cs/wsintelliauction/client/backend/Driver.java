package com.uct.cs.wsintelliauction.client.backend;

import java.io.File;
import java.io.ObjectInputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.uct.cs.wsintelliauction.client.backend.network.ClientNetworkDriver;
import com.uct.cs.wsintelliauction.client.backend.network.StorableServerList;
import com.uct.cs.wsintelliauction.client.frontend.ClientWindowDriver;
import com.uct.cs.wsintelliauction.database.persistent.ObjectDatabaseDriver;
import com.uct.cs.wsintelliauction.network.Recipient;
import com.uct.cs.wsintelliauction.utility.AbstractDriver;
import com.uct.cs.wsintelliauction.utility.ThreadHandler;

public class Driver extends AbstractDriver {

	private ClientResourceContainer clientResources;
	

	public Driver(String[] args) {
		super(args);
		clientResources = new ClientResourceContainer(args);
	}

	@Override
	public void exec() {
		clientResources.getWindowManager().launchMainWindow();
	}

}