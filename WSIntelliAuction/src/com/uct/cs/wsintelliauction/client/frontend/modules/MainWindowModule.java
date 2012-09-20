package com.uct.cs.wsintelliauction.client.frontend.modules;

import com.uct.cs.wsintelliauction.client.frontend.controls.MainWindowController;
import com.uct.cs.wsintelliauction.client.frontend.models.MainWindowModel;
import com.uct.cs.wsintelliauction.client.frontend.views.MainWindowView;
import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.gui.modules.ConsoleTabModule;


public class MainWindowModule extends
		Module<MainWindowModel, MainWindowView, MainWindowController> {
	
	private NetworkTabModule networkTabModule;
	private ConsoleTabModule consoleTabModule;

	public MainWindowModule() {
		model = new MainWindowModel();
		view = new MainWindowView(model);
		controller = new MainWindowController(view, model);
		
		networkTabModule = new NetworkTabModule();
		consoleTabModule = new ConsoleTabModule();
		
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
