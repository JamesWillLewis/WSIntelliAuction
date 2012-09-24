package com.uct.cs.wsintelliauction.server.frontend.modules;


import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.server.frontend.controls.ServerTabController;
import com.uct.cs.wsintelliauction.server.frontend.models.ServerTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.ServerTabView;
import com.uct.cs.wsintelliauction.util.ResourceContainer;

public class ServerTabModule extends
		Module<ServerTabModel, ServerTabView, ServerTabController> {

	public ServerTabModule(ServerResourceContainer resourceManager) {
		super(resourceManager);
		
		model = new ServerTabModel(resourceManager);
		view = new ServerTabView(model);
		controller = new ServerTabController(view, model);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

}
