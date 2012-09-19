package wsintelliauction.server.frontend.modules;

import wsintelliauction.gui.Module;
import wsintelliauction.server.frontend.controls.AuctionTabController;
import wsintelliauction.server.frontend.models.AuctionTabModel;
import wsintelliauction.server.frontend.views.AuctionTabView;
import wsintelliauction.task.TaskManager;

public class AuctionTabModule extends
		Module<AuctionTabModel, AuctionTabView, AuctionTabController> {

	public AuctionTabModule(TaskManager taskManager) {
		model = new AuctionTabModel();
		view = new AuctionTabView(model);
		controller = new AuctionTabController(view, model, taskManager);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
