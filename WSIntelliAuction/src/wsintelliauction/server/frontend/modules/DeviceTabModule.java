package wsintelliauction.server.frontend.modules;

import wsintelliauction.gui.Module;
import wsintelliauction.server.frontend.controls.DeviceTabController;
import wsintelliauction.server.frontend.models.DeviceTabModel;
import wsintelliauction.server.frontend.views.DeviceTabView;
import wsintelliauction.task.TaskManager;

public class DeviceTabModule extends
		Module<DeviceTabModel, DeviceTabView, DeviceTabController> {

	public DeviceTabModule(TaskManager taskManager) {
		model = new DeviceTabModel();
		view = new DeviceTabView(model);
		controller = new DeviceTabController(view, model, taskManager);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
