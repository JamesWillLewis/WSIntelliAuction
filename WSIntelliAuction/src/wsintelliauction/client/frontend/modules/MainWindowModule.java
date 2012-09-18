package wsintelliauction.client.frontend.modules;

import java.awt.EventQueue;

import wsintelliauction.client.frontend.controls.MainWindowController;
import wsintelliauction.client.frontend.models.MainWindowModel;
import wsintelliauction.client.frontend.views.MainWindowView;
import wsintelliauction.gui.Module;
import wsintelliauction.gui.modules.ConsoleTabModule;
import wsintelliauction.task.TaskManager;

public class MainWindowModule extends
		Module<MainWindowModel, MainWindowView, MainWindowController> {
	
	private NetworkTabModule networkTabModule;
	private ConsoleTabModule consoleTabModule;

	public MainWindowModule(TaskManager taskManager) {
		model = new MainWindowModel();
		view = new MainWindowView(model);
		controller = new MainWindowController(view, model, taskManager);
		
		networkTabModule = new NetworkTabModule(taskManager);
		consoleTabModule = new ConsoleTabModule(taskManager);
		
		initTabs();
	}
	
	private void initTabs(){
		view.addTab(networkTabModule.getView());
		view.addTab(consoleTabModule.getView());
	}

	@Override
	public void display() {
		view.show();
	}

}
