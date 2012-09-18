package wsintelliauction.server.frontend.controls;

import wsintelliauction.gui.Controller;
import wsintelliauction.server.frontend.models.LeasesTabModel;
import wsintelliauction.server.frontend.views.LeasesTabView;
import wsintelliauction.task.TaskManager;

public class LeasesTabController extends
		Controller<LeasesTabModel, LeasesTabView> {

	public LeasesTabController(LeasesTabView view, LeasesTabModel model,
			TaskManager taskManager) {
		super(view, model, taskManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assignListeners() {
		// TODO Auto-generated method stub
		
	}

}
