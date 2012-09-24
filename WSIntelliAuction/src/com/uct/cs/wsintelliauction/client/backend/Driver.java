package com.uct.cs.wsintelliauction.client.backend;

import java.io.File;
import java.io.ObjectInputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.uct.cs.wsintelliauction.client.backend.net.ClientNetworkDriver;
import com.uct.cs.wsintelliauction.client.backend.net.StorableServerList;
import com.uct.cs.wsintelliauction.client.frontend.ClientWindowDriver;
import com.uct.cs.wsintelliauction.db.orm.ObjectDatabaseDriver;
import com.uct.cs.wsintelliauction.net.Recipient;
import com.uct.cs.wsintelliauction.util.AbstractDriver;
import com.uct.cs.wsintelliauction.util.ThreadHandler;

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