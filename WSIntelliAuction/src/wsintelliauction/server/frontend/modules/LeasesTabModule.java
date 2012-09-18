package wsintelliauction.server.frontend.modules;

import wsintelliauction.gui.Module;
import wsintelliauction.server.frontend.controls.LeasesTabController;
import wsintelliauction.server.frontend.controls.MainWindowController;
import wsintelliauction.server.frontend.models.LeasesTabModel;
import wsintelliauction.server.frontend.models.MainWindowModel;
import wsintelliauction.server.frontend.views.LeasesTabView;
import wsintelliauction.server.frontend.views.MainWindowView;
import wsintelliauction.task.TaskManager;

public class LeasesTabModule extends
		Module<LeasesTabModel, LeasesTabView, LeasesTabController> {

	public LeasesTabModule(TaskManager taskManager) {
		model = new LeasesTabModel();
		view = new LeasesTabView(model);
		controller = new LeasesTabController(view, model, taskManager);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

}
