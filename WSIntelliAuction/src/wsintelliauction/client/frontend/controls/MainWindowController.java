package wsintelliauction.client.frontend.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import wsintelliauction.client.frontend.models.MainWindowModel;
import wsintelliauction.client.frontend.views.MainWindowView;
import wsintelliauction.gui.Controller;
import wsintelliauction.net.Recipient;
import wsintelliauction.task.TaskManager;
import wsintelliauction.util.Configuration;

public class MainWindowController extends Controller<MainWindowModel, MainWindowView> {

	public MainWindowController(MainWindowView view, MainWindowModel model,
			TaskManager taskManager) {
		super(view, model, taskManager);

	}

	@Override
	protected void assignListeners() {
	

	}
}
