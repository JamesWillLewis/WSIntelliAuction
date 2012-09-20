package wsintelliauction.gui.modules;

import wsintelliauction.gui.Module;
import wsintelliauction.task.TaskManager;

public class ConsoleTabModule extends
		Module<ConsoleTabModel, ConsoleTabView, ConsoleTabController> {

	public ConsoleTabModule(TaskManager t) {
		model = new ConsoleTabModel();
		view = new ConsoleTabView(model);
		controller = new ConsoleTabController(view, model, t);
	}

	@Override
	public void display() {

	}

}
