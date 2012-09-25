package com.uct.cs.wsintelliauction.server.frontend.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.uct.cs.wsintelliauction.server.frontend.models.ServerTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.ServerTabView;
import com.uct.cs.wsintelliauction.window.Controller;

public class ServerTabController extends
		Controller<ServerTabModel, ServerTabView> {

	public ServerTabController(ServerTabView view, ServerTabModel model) {
		super(view, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assignListeners() {
		view.getBtnNewButton().addActionListener(new ServerStartStopButtonClickedEvent());
	}
	
	public class ServerStartStopButtonClickedEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(model.isServerOn()){
				model.turnOffServer();
				view.getBtnNewButton().setText("Start Server");
			} else{
				model.turnOnServer();
				view.getBtnNewButton().setText("Stop Server");
			}
			view.refreshServerStats();
		}	
	}

}
