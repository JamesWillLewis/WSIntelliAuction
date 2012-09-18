package wsintelliauction.server.frontend.modules;

import wsintelliauction.gui.Module;
import wsintelliauction.server.frontend.controls.ClientsTabController;
import wsintelliauction.server.frontend.controls.MainWindowController;
import wsintelliauction.server.frontend.models.ClientsTabModel;
import wsintelliauction.server.frontend.models.MainWindowModel;
import wsintelliauction.server.frontend.views.ClientsTabView;
import wsintelliauction.server.frontend.views.MainWindowView;
import wsintelliauction.task.TaskManager;

public class ClientsTabModule extends
		Module<ClientsTabModel, ClientsTabView, ClientsTabController> {

	public ClientsTabModule(TaskManager taskManager) {
		model = new ClientsTabModel();
		view = new ClientsTabView(model);
		controller = new ClientsTabController(view, model, taskManager);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
