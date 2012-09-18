package wsintelliauction.server.frontend.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import wsintelliauction.gui.Controller;
import wsintelliauction.gui.View;
import wsintelliauction.server.frontend.models.MainWindowModel;
import wsintelliauction.server.frontend.views.MainWindowView;
import wsintelliauction.task.TaskManager;
import wsintelliauction.util.Configuration;

public class MainWindowController extends Controller<MainWindowModel, MainWindowView> {

	public MainWindowController(MainWindowView view, MainWindowModel model,
			TaskManager taskManager) {
		super(view, model, taskManager);

	}

	@Override
	protected void assignListeners() {
		// TODO Auto-generated method stub
		
	}



}
