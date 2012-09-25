package com.uct.cs.wsintelliauction.window.modules;

import com.uct.cs.wsintelliauction.utility.ErrorLogger;
import com.uct.cs.wsintelliauction.utility.EventLogger;
import com.uct.cs.wsintelliauction.utility.ResourceContainer;
import com.uct.cs.wsintelliauction.window.Module;

public class ConsoleTabModule extends
		Module<ConsoleTabModel, ConsoleTabView, ConsoleTabController> {

	public ConsoleTabModule(ResourceContainer resourceContainer) {
		super(resourceContainer);
		model = new ConsoleTabModel(resourceContainer);
		view = new ConsoleTabView(model);
		controller = new ConsoleTabController(view, model);
		
		EventLogger.setConsoleTabController(controller);
		ErrorLogger.setConsoleTabController(controller);
	}

	@Override
	public void display() {

	}

}
