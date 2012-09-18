package wsintelliauction.server.frontend.controls;

import wsintelliauction.gui.Controller;
import wsintelliauction.server.frontend.models.ChannelTabModel;
import wsintelliauction.server.frontend.views.ChannelTabView;
import wsintelliauction.task.TaskManager;

public class ChannelTabController extends
		Controller<ChannelTabModel, ChannelTabView> {

	public ChannelTabController(ChannelTabView view, ChannelTabModel model,
			TaskManager taskManager) {
		super(view, model, taskManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assignListeners() {
		// TODO Auto-generated method stub
		
	}

}
