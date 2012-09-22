
package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.server.frontend.controls.ChannelTabController;
import com.uct.cs.wsintelliauction.server.frontend.models.ChannelTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.ChannelTabView;
import com.uct.cs.wsintelliauction.util.ResourceManager;

public class ChannelTabModule extends
		Module<ChannelTabModel, ChannelTabView, ChannelTabController> {

	public ChannelTabModule(ResourceManager resourceManager) {
		super(resourceManager);
		model = new ChannelTabModel(resourceManager);
		view = new ChannelTabView(model);
		controller = new ChannelTabController(view, model);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
