package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.server.frontend.controls.ServerTabController;
import com.uct.cs.wsintelliauction.server.frontend.models.ServerTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.ServerTabView;

public class ServerTabModule extends
		Module<ServerTabModel, ServerTabView, ServerTabController> {

	public ServerTabModule() {
		model = new ServerTabModel();
		view = new ServerTabView(model);
		controller = new ServerTabController(view, model);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

}
