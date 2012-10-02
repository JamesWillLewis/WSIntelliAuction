package com.uct.cs.wsintelliauction.client.frontend.modules;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceContainer;
import com.uct.cs.wsintelliauction.client.frontend.controls.AuctionTabController;
import com.uct.cs.wsintelliauction.client.frontend.models.AuctionTabModel;
import com.uct.cs.wsintelliauction.client.frontend.views.AuctionTabView;
import com.uct.cs.wsintelliauction.window.Module;


public class AuctionTabModule extends
		Module<AuctionTabModel, AuctionTabView, AuctionTabController> {

	public AuctionTabModule(ClientResourceContainer resourceContainer) {
		super(resourceContainer);
		model = new AuctionTabModel(resourceContainer);
		view = new AuctionTabView(model);
		controller = new AuctionTabController(view, model);
	}
	
	@Override
	public void display() {

	}

}
