package wsintelliauction.server.control.mvc.mainwindow;

import wsintelliauction.gui.Controller;
import wsintelliauction.task.TaskManager;

public class MainController extends Controller<MainModel, MainView>{

	public MainController(MainView view, MainModel model, TaskManager taskManager) {
		super(view, model, taskManager);
	}
	
	

}
