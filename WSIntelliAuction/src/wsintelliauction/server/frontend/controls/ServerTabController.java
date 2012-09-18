package wsintelliauction.server.frontend.controls;

import wsintelliauction.gui.Controller;
import wsintelliauction.server.frontend.models.ServerTabModel;
import wsintelliauction.server.frontend.views.ServerTabView;
import wsintelliauction.task.TaskManager;

public class ServerTabController extends
		Controller<ServerTabModel, ServerTabView> {

	public ServerTabController(ServerTabView view, ServerTabModel model,
			TaskManager taskManager) {
		super(view, model, taskManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assignListeners() {
		// TODO Auto-generated method stub
		
	}

}
