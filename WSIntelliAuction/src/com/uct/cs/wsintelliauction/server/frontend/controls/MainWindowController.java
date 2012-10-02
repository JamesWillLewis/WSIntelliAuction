package com.uct.cs.wsintelliauction.server.frontend.controls;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import com.uct.cs.wsintelliauction.server.frontend.models.MainWindowModel;
import com.uct.cs.wsintelliauction.server.frontend.views.MainWindowView;
import com.uct.cs.wsintelliauction.window.Controller;

public class MainWindowController extends
		Controller<MainWindowModel, MainWindowView> {

	public MainWindowController(MainWindowView view, MainWindowModel model) {
		super(view, model);
	}

	@Override
	protected void assignListeners() {
		view.addWindowListener(new MainWindowListener());
	}

	private class MainWindowListener extends WindowAdapter {
		
		@Override
		public void windowClosing(WindowEvent e) {
			int option = JOptionPane.showConfirmDialog(view,
					"Are you sure you want to exit?", "Confirm Exit",
					JOptionPane.OK_CANCEL_OPTION);
			if(option == JOptionPane.OK_OPTION){
				view.getFrame().dispose();
				model.getResourceManager().close();
			}
		}

	}

	public void setWindowEnabled(boolean b) {
		view.getFrame().setEnabled(b);
	}


}
