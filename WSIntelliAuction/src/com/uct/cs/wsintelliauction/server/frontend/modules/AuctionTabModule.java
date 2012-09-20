package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.server.frontend.controls.AuctionTabController;
import com.uct.cs.wsintelliauction.server.frontend.models.AuctionTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.AuctionTabView;

public class AuctionTabModule extends
		Module<AuctionTabModel, AuctionTabView, AuctionTabController> {

	public AuctionTabModule() {
		model = new AuctionTabModel();
		view = new AuctionTabView(model);
		controller = new AuctionTabController(view, model);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
