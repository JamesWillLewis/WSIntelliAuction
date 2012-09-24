package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.server.frontend.controls.DatabaseTabController;
import com.uct.cs.wsintelliauction.server.frontend.models.DatabaseTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.DatabaseTabView;
import com.uct.cs.wsintelliauction.util.ResourceContainer;

public class DatabaseTabModule extends
		Module<DatabaseTabModel, DatabaseTabView, DatabaseTabController> {

	public DatabaseTabModule(ServerResourceContainer resourceContainer) {
		super(resourceContainer);
		model = new DatabaseTabModel(resourceContainer);
		view = new DatabaseTabView(model);
		controller = new DatabaseTabController(view, model);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
