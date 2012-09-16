package wsintelliauction.server.frontend.mvc.mainwindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import wsintelliauction.gui.Controller;
import wsintelliauction.gui.View;
import wsintelliauction.misc.Configuration;
import wsintelliauction.task.TaskManager;

public class MainController extends Controller<MainModel, MainView> {

	public MainController(MainView view, MainModel model,
			TaskManager taskManager) {
		super(view, model, taskManager);

	}

	@Override
	protected void assignListeners() {
		// TODO Auto-generated method stub
		
	}



}
