package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.server.frontend.controls.ClientsTabController;
import com.uct.cs.wsintelliauction.server.frontend.models.ClientsTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.ClientsTabView;

public class ClientsTabModule extends
		Module<ClientsTabModel, ClientsTabView, ClientsTabController> {

	public ClientsTabModule() {
		model = new ClientsTabModel();
		view = new ClientsTabView(model);
		controller = new ClientsTabController(view, model);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
