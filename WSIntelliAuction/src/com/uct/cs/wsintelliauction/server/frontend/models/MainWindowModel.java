package com.uct.cs.wsintelliauction.server.frontend.models;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceManager;
import com.uct.cs.wsintelliauction.gui.Model;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceManager;

public class MainWindowModel extends Model<ServerResourceManager> {

	public MainWindowModel(ServerResourceManager resourceManager) {
		super(resourceManager);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
	public ServerResourceManager getResourceManager() {
		return resourceManager;
	}

}
