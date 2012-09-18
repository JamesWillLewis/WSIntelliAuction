package wsintelliauction.server.frontend.controls;

import wsintelliauction.gui.Controller;
import wsintelliauction.server.frontend.models.DeviceTabModel;
import wsintelliauction.server.frontend.views.DeviceTabView;
import wsintelliauction.task.TaskManager;

public class DeviceTabController extends
		Controller<DeviceTabModel, DeviceTabView> {

	public DeviceTabController(DeviceTabView view, DeviceTabModel model,
			TaskManager taskManager) {
		super(view, model, taskManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assignListeners() {
		// TODO Auto-generated method stub
		
	}

}
