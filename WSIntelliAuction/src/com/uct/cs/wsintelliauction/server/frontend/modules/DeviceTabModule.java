package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.server.frontend.controls.DeviceTabController;
import com.uct.cs.wsintelliauction.server.frontend.models.DeviceTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.DeviceTabView;
import com.uct.cs.wsintelliauction.util.ResourceContainer;

public class DeviceTabModule extends
		Module<DeviceTabModel, DeviceTabView, DeviceTabController> {

	public DeviceTabModule(ResourceContainer resourceContainer) {
		super(resourceContainer);
		model = new DeviceTabModel(resourceContainer);
		view = new DeviceTabView(model);
		controller = new DeviceTabController(view, model);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
