package com.uct.cs.wsintelliauction.server.frontend.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.uct.cs.wsintelliauction.gui.Controller;
import com.uct.cs.wsintelliauction.server.frontend.models.DatabaseTabModel;
import com.uct.cs.wsintelliauction.server.frontend.views.DatabaseTabView;

public class DatabaseTabController extends
		Controller<DatabaseTabModel, DatabaseTabView> {

	public DatabaseTabController(DatabaseTabView view, DatabaseTabModel model) {
		super(view, model);
	}

	@Override
	protected void assignListeners() {
		view.getBtnExecuteQuery().addActionListener(new ExecuteQueryStatementEvent());
	}

	public class ExecuteQueryStatementEvent implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			model.submitQuery(view.getTxtrSelect().getText());
		}
	}
	
}
