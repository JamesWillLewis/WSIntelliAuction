package wsintelliauction.server.frontend.modules;

import wsintelliauction.gui.Module;
import wsintelliauction.server.frontend.controls.MainWindowController;
import wsintelliauction.server.frontend.models.MainWindowModel;
import wsintelliauction.server.frontend.views.MainWindowView;
import wsintelliauction.task.TaskManager;

public class MainWindowModule extends Module<MainWindowModel, MainWindowView, MainWindowController> {

	public MainWindowModule(TaskManager taskManager) {
		model = new MainWindowModel();
		view = new MainWindowView(model);
		controller = new MainWindowController(view, model, taskManager);
	}

}
