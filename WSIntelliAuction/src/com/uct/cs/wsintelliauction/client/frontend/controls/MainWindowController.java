package com.uct.cs.wsintelliauction.client.frontend.controls;

import com.uct.cs.wsintelliauction.client.frontend.models.MainWindowModel;
import com.uct.cs.wsintelliauction.client.frontend.views.MainWindowView;
import com.uct.cs.wsintelliauction.gui.Controller;

public class MainWindowController extends
		Controller<MainWindowModel, MainWindowView> {

	public MainWindowController(MainWindowView view, MainWindowModel model) {
		super(view, model);

	}

	@Override
	protected void assignListeners() {

	}
}
