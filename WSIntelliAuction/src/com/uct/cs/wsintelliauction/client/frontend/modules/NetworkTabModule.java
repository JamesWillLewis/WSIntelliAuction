package com.uct.cs.wsintelliauction.client.frontend.modules;

import com.uct.cs.wsintelliauction.client.frontend.controls.NetworkTabController;
import com.uct.cs.wsintelliauction.client.frontend.models.NetworkTabModel;
import com.uct.cs.wsintelliauction.client.frontend.views.NetworkTabView;
import com.uct.cs.wsintelliauction.gui.Module;


public class NetworkTabModule extends
		Module<NetworkTabModel, NetworkTabView, NetworkTabController> {

	
	public NetworkTabModule() {
		model = new NetworkTabModel();
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
