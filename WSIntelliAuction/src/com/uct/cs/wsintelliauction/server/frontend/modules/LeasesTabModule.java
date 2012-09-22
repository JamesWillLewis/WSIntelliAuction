package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.server.frontend.controls.LeasesTabController;
import com.uct.cs.wsintelliauction.server.frontend.models.LeasesTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.LeasesTabView;
import com.uct.cs.wsintelliauction.util.ResourceManager;

public class LeasesTabModule extends
		Module<LeasesTabModel, LeasesTabView, LeasesTabController> {

	public LeasesTabModule(ResourceManager resourceManager) {
		super(resourceManager);
		model = new LeasesTabModel(resourceManager);
		view = new LeasesTabView(model);
		controller = new LeasesTabController(view, model);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

}
