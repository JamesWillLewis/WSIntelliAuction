package com.uct.cs.wsintelliauction.client.frontend.modules;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceManager;
import com.uct.cs.wsintelliauction.client.frontend.controls.MainWindowController;
import com.uct.cs.wsintelliauction.client.frontend.models.MainWindowModel;
import com.uct.cs.wsintelliauction.client.frontend.views.MainWindowView;
import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.gui.modules.ConsoleTabModule;
import com.uct.cs.wsintelliauction.util.ResourceManager;

public class MainWindowModule extends
		Module<MainWindowModel, MainWindowView, MainWindowController> {

	private NetworkTabModule networkTabModule;
	private ConsoleTabModule consoleTabModule;

	public MainWindowModule(ClientResourceManager resourceManager) {
		super(resourceManager);

		model = new MainWindowModel(resourceManager);
		view = new MainWindowView(model);
		controller = new MainWindowController(view, model);

		networkTabModule = new NetworkTabModule(resourceManager);
		consoleTabModule = new ConsoleTabModule(resourceManager);

		initTabs();
	}

	private void initTabs() {
		view.addTab(networkTabModule.getView());
		view.addTab(consoleTabModule.getView());
	}

	@Override
	public void display() {
		view.show();
	}

}
