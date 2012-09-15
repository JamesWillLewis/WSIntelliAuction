package wsintelliauction.server.frontend.mvc.mainwindow;

import wsintelliauction.gui.MVC;
import wsintelliauction.task.TaskManager;

public class MainMVC extends MVC<MainModel, MainView, MainController> {

	public MainMVC(TaskManager taskManager) {
		model = new MainModel();
		view = new MainView(model);
		controller = new MainController(view, model, taskManager);
	}

}
