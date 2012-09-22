package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.server.frontend.controls.ClientsTabController;
import com.uct.cs.wsintelliauction.server.frontend.models.ClientsTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.ClientsTabView;
import com.uct.cs.wsintelliauction.util.ResourceManager;

public class ClientsTabModule extends
		Module<ClientsTabModel, ClientsTabView, ClientsTabController> {

	public ClientsTabModule(ResourceManager resourceManager) {
		super(resourceManager);
		model = new ClientsTabModel(resourceManager);
		view = new ClientsTabView(model);
		controller = new ClientsTabController(view, model);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
