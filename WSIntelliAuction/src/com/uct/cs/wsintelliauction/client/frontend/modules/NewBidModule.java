package com.uct.cs.wsintelliauction.client.frontend.modules;

import javax.swing.JTable;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceContainer;
import com.uct.cs.wsintelliauction.client.frontend.controls.NewBidController;
import com.uct.cs.wsintelliauction.client.frontend.models.NewBidModel;
import com.uct.cs.wsintelliauction.client.frontend.views.NewBidView;
import com.uct.cs.wsintelliauction.window.Module;

public class NewBidModule extends
		Module<NewBidModel, NewBidView, NewBidController> {

	public NewBidModule(ClientResourceContainer resourceContainer, JTable bidTable) {
		super(resourceContainer);
		model = new NewBidModel(resourceContainer);
		view = new NewBidView(model);
		controller = new NewBidController(view, model, bidTable);
	}

	@Override
	public void display() {
		view.show();
	}

}
