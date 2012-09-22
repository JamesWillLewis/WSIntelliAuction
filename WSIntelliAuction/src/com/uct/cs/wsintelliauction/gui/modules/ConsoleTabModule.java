package com.uct.cs.wsintelliauction.gui.modules;

import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.util.ErrorLogger;
import com.uct.cs.wsintelliauction.util.EventLogger;
import com.uct.cs.wsintelliauction.util.ResourceManager;

public class ConsoleTabModule extends
		Module<ConsoleTabModel, ConsoleTabView, ConsoleTabController> {

	public ConsoleTabModule(ResourceManager resourceManager) {
		super(resourceManager);
		model = new ConsoleTabModel(resourceManager);
		view = new ConsoleTabView(model);
		controller = new ConsoleTabController(view, model);
		
		EventLogger.setConsoleTabController(controller);
		ErrorLogger.setConsoleTabController(controller);
	}

	@Override
	public void display() {

	}

}
