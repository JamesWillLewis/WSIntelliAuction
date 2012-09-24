package com.uct.cs.wsintelliauction.client.frontend.models;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceContainer;
import com.uct.cs.wsintelliauction.gui.Model;


public class MainWindowModel extends Model<ClientResourceContainer> {

	public MainWindowModel(ClientResourceContainer resourceManager) {
		super(resourceManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	public ClientResourceContainer getResourceManager() {
		return resourceManager;
	}


	

}
