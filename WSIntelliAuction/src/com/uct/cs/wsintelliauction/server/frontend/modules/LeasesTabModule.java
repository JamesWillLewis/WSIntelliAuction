package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.server.frontend.controls.LeasesTabController;
import com.uct.cs.wsintelliauction.server.frontend.models.LeasesTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.LeasesTabView;

public class LeasesTabModule extends
		Module<LeasesTabModel, LeasesTabView, LeasesTabController> {

	public LeasesTabModule() {
		model = new LeasesTabModel();
		view = new LeasesTabView(model);
		controller = new LeasesTabController(view, model);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

}
