
package wsintelliauction.server.frontend.modules;

import wsintelliauction.gui.Module;
import wsintelliauction.server.frontend.controls.ChannelTabController;
import wsintelliauction.server.frontend.controls.MainWindowController;
import wsintelliauction.server.frontend.models.ChannelTabModel;
import wsintelliauction.server.frontend.models.MainWindowModel;
import wsintelliauction.server.frontend.views.ChannelTabView;
import wsintelliauction.server.frontend.views.MainWindowView;
import wsintelliauction.task.TaskManager;

public class ChannelTabModule extends
		Module<ChannelTabModel, ChannelTabView, ChannelTabController> {

	public ChannelTabModule(TaskManager taskManager) {
		model = new ChannelTabModel();
		view = new ChannelTabView(model);
		controller = new ChannelTabController(view, model, taskManager);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
