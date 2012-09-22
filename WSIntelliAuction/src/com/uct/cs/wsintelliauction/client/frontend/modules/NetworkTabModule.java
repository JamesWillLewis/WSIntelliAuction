package com.uct.cs.wsintelliauction.client.frontend.modules;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceManager;
import com.uct.cs.wsintelliauction.client.frontend.controls.NetworkTabController;
import com.uct.cs.wsintelliauction.client.frontend.models.NetworkTabModel;
import com.uct.cs.wsintelliauction.client.frontend.views.NetworkTabView;
import com.uct.cs.wsintelliauction.gui.Module;


public class NetworkTabModule extends
		Module<NetworkTabModel, NetworkTabView, NetworkTabController> {

	
	public NetworkTabModule(ClientResourceManager resourceManager) {
		super(resourceManager);
		model = new NetworkTabModel(resourceManager);
		view = new NetworkTabView(model);
		controller = new NetworkTabController(view, model);
	}


	@Override
	public void display() {
		//nothing yet
	}
	
	@Override
	public String toString() {
		return "Network";
	}
	
	
}
