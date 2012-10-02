package com.uct.cs.wsintelliauction.client.frontend.modules;


import com.uct.cs.wsintelliauction.client.backend.ClientResourceContainer;
import com.uct.cs.wsintelliauction.client.frontend.controls.LeasesTabController;
import com.uct.cs.wsintelliauction.client.frontend.models.LeasesTabModel;
import com.uct.cs.wsintelliauction.client.frontend.views.LeasesTabView;
import com.uct.cs.wsintelliauction.window.Module;

public class LeasesTabModule extends
		Module<LeasesTabModel, LeasesTabView, LeasesTabController> {

	public LeasesTabModule(ClientResourceContainer resourceContainer) {
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
