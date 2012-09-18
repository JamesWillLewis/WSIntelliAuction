package wsintelliauction.client.frontend.modules;

import javax.swing.JPanel;

import wsintelliauction.client.frontend.controls.NetworkTabController;
import wsintelliauction.client.frontend.models.NetworkTabModel;
import wsintelliauction.client.frontend.views.NetworkTabView;
import wsintelliauction.gui.Module;
import wsintelliauction.task.TaskManager;

public class NetworkTabModule extends
		Module<NetworkTabModel, NetworkTabView, NetworkTabController> {

	
	public NetworkTabModule(TaskManager t) {
		model = new NetworkTabModel();
		view = new NetworkTabView(model);
		controller = new NetworkTabController(view, model, t);
	}


	@Override
	public void display() {
		//nothing yet
	}
	
	@Override
	public String toString() {
		return "Network";
	}
	
	
}
