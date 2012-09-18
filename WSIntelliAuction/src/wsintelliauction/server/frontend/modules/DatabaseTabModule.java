package wsintelliauction.server.frontend.modules;

import wsintelliauction.gui.Module;
import wsintelliauction.server.frontend.controls.DatabaseTabController;
import wsintelliauction.server.frontend.controls.MainWindowController;
import wsintelliauction.server.frontend.models.DatabaseTabModel;
import wsintelliauction.server.frontend.models.MainWindowModel;
import wsintelliauction.server.frontend.views.DatabaseTabView;
import wsintelliauction.server.frontend.views.MainWindowView;
import wsintelliauction.task.TaskManager;

public class DatabaseTabModule extends
		Module<DatabaseTabModel, DatabaseTabView, DatabaseTabController> {

	public DatabaseTabModule(TaskManager taskManager) {
		model = new DatabaseTabModel();
		view = new DatabaseTabView(model);
		controller = new DatabaseTabController(view, model, taskManager);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
