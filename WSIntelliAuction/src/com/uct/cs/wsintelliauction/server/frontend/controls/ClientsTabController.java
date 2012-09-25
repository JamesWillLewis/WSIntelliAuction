package com.uct.cs.wsintelliauction.server.frontend.controls;

import com.uct.cs.wsintelliauction.server.frontend.models.ClientsTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.ClientsTabView;
import com.uct.cs.wsintelliauction.window.Controller;

public class ClientsTabController extends
		Controller<ClientsTabModel, ClientsTabView> {

	public ClientsTabController(ClientsTabView view, ClientsTabModel model) {
		super(view, model);
	}

	@Override
	protected void assignListeners() {

	}

	public void newClientConnected() {
		model.fireTableDataChanged();
	}
	
	public void clientDisconncted(){
		model.fireTableDataChanged();
	}

}
