package com.uct.cs.wsintelliauction.server.frontend.modules;


import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.server.frontend.controls.AuctionTabController;
import com.uct.cs.wsintelliauction.server.frontend.controls.MainWindowController;
import com.uct.cs.wsintelliauction.server.frontend.models.AuctionTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.AuctionTabView;
import com.uct.cs.wsintelliauction.window.Module;

public class AuctionTabModule extends
		Module<AuctionTabModel, AuctionTabView, AuctionTabController> {

	public AuctionTabModule(ServerResourceContainer resourceContainer, MainWindowController mainWindowController) {
		super(resourceContainer);
		model = new AuctionTabModel(resourceContainer);
		view = new AuctionTabView(model);
		controller = new AuctionTabController(view, model, mainWindowController);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
