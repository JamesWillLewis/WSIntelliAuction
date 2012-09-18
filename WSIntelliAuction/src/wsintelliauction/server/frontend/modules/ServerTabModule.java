package wsintelliauction.server.frontend.modules;

import wsintelliauction.gui.Module;
import wsintelliauction.server.frontend.controls.MainWindowController;
import wsintelliauction.server.frontend.controls.ServerTabController;
import wsintelliauction.server.frontend.models.MainWindowModel;
import wsintelliauction.server.frontend.models.ServerTabModel;
import wsintelliauction.server.frontend.views.MainWindowView;
import wsintelliauction.server.frontend.views.ServerTabView;
import wsintelliauction.task.TaskManager;

public class ServerTabModule extends
		Module<ServerTabModel, ServerTabView, ServerTabController> {

	public ServerTabModule(TaskManager taskManager) {
		model = new ServerTabModel();
		view = new ServerTabView(model);
		controller = new ServerTabController(view, model, taskManager);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

}
