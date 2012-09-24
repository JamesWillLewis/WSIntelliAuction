package com.uct.cs.wsintelliauction.gui.modules;

import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.util.ErrorLogger;
import com.uct.cs.wsintelliauction.util.EventLogger;
import com.uct.cs.wsintelliauction.util.ResourceContainer;

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
