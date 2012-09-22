package com.uct.cs.wsintelliauction.client.frontend.models;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceManager;
import com.uct.cs.wsintelliauction.gui.Model;


public class MainWindowModel extends Model<ClientResourceManager> {

	public MainWindowModel(ClientResourceManager resourceManager) {
		super(resourceManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	public ClientResourceManager getResourceManager() {
		return resourceManager;
	}


	

}
