package wsintelliauction.client.frontend.modules;

import wsintelliauction.client.frontend.controls.MainWindowController;
import wsintelliauction.client.frontend.models.MainWindowModel;
import wsintelliauction.client.frontend.views.MainWindowView;
import wsintelliauction.gui.Module;
import wsintelliauction.task.TaskManager;

public class MainWindowModule extends Module<MainWindowModel, MainWindowView, MainWindowController> {

	public MainWindowModule(TaskManager taskManager) {
		model = new MainWindowModel();
		view = new MainWindowView(model);
		controller = new MainWindowController(view, model, taskManager);
	}
	
}
