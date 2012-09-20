package com.uct.cs.wsintelliauction.gui.modules;

import com.uct.cs.wsintelliauction.gui.Module;

public class ConsoleTabModule extends
		Module<ConsoleTabModel, ConsoleTabView, ConsoleTabController> {

	public ConsoleTabModule() {
		model = new ConsoleTabModel();
		view = new ConsoleTabView(model);
		controller = new ConsoleTabController(view, model);
	}

	@Override
	public void display() {

	}

}
