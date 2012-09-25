package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.server.frontend.controls.LeasesTabController;
import com.uct.cs.wsintelliauction.server.frontend.models.LeasesTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.LeasesTabView;
import com.uct.cs.wsintelliauction.utility.ResourceContainer;
import com.uct.cs.wsintelliauction.window.Module;

public class LeasesTabModule extends
		Module<LeasesTabModel, LeasesTabView, LeasesTabController> {

	public LeasesTabModule(ResourceContainer resourceContainer) {
		super(resourceContainer);
		model = new LeasesTabModel(resourceContainer);
		view = new LeasesTabView(model);
		controller = new LeasesTabController(view, model);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

}
