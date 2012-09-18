package wsintelliauction.server.frontend.controls;

import wsintelliauction.gui.Controller;
import wsintelliauction.server.frontend.models.ClientsTabModel;
import wsintelliauction.server.frontend.views.ClientsTabView;
import wsintelliauction.task.TaskManager;

public class ClientsTabController extends
		Controller<ClientsTabModel, ClientsTabView> {

	public ClientsTabController(ClientsTabView view, ClientsTabModel model,
			TaskManager taskManager) {
		super(view, model, taskManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assignListeners() {
		// TODO Auto-generated method stub
		
	}

}
