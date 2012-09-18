package wsintelliauction.server.frontend.controls;

import wsintelliauction.gui.Controller;
import wsintelliauction.server.frontend.models.AuctionTabModel;
import wsintelliauction.server.frontend.views.AuctionTabView;
import wsintelliauction.task.TaskManager;

public class AuctionTabController extends
		Controller<AuctionTabModel, AuctionTabView> {

	public AuctionTabController(AuctionTabView view, AuctionTabModel model,
			TaskManager taskManager) {
		super(view, model, taskManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assignListeners() {
		// TODO Auto-generated method stub

	}

}
