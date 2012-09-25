package com.uct.cs.wsintelliauction.server.frontend.models;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceContainer;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.window.Model;

public class MainWindowModel extends Model<ServerResourceContainer> {

	public MainWindowModel(ServerResourceContainer resourceManager) {
		super(resourceManager);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
	public ServerResourceContainer getResourceManager() {
		return resourceManager;
	}

}
