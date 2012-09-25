package com.uct.cs.wsintelliauction.server.backend;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceContainer;
import com.uct.cs.wsintelliauction.utility.AbstractDriver;

public class Driver extends AbstractDriver {

private ServerResourceContainer serverResourceContainer;
	

	public Driver(String[] args) {
		super(args);
		serverResourceContainer = new ServerResourceContainer(args);
	}

	@Override
	public void exec() {
		serverResourceContainer.getServerWindowManager().launchMainWindow();
	}



}
