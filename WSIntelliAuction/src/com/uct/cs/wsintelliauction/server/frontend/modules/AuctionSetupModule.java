package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.server.frontend.controls.AuctionSetupController;
import com.uct.cs.wsintelliauction.server.frontend.models.AuctionSetupModel;
import com.uct.cs.wsintelliauction.server.frontend.views.AuctionSetupView;
import com.uct.cs.wsintelliauction.window.Module;

public class AuctionSetupModule extends
		Module<AuctionSetupModel, AuctionSetupView, AuctionSetupController> {

	public AuctionSetupModule(ServerResourceContainer resourceContainer) {
		super(resourceContainer);
		model = new AuctionSetupModel(resourceContainer);
		view = new AuctionSetupView(model);
		controller = new AuctionSetupController(view, model);
	}

	@Override
	public void display() {
		view.show();
	}

}
