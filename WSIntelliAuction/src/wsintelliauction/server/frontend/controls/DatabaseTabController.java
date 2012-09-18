package wsintelliauction.server.frontend.controls;

import wsintelliauction.gui.Controller;
import wsintelliauction.server.frontend.models.DatabaseTabModel;
import wsintelliauction.server.frontend.views.DatabaseTabView;
import wsintelliauction.task.TaskManager;

public class DatabaseTabController extends
		Controller<DatabaseTabModel, DatabaseTabView> {

	public DatabaseTabController(DatabaseTabView view, DatabaseTabModel model,
			TaskManager taskManager) {
		super(view, model, taskManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assignListeners() {
		// TODO Auto-generated method stub
		
	}

}
