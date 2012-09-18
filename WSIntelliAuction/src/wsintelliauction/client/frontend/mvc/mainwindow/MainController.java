package wsintelliauction.client.frontend.mvc.mainwindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import wsintelliauction.gui.Controller;
import wsintelliauction.misc.Configuration;
import wsintelliauction.net.Recipient;
import wsintelliauction.task.TaskManager;

public class MainController extends Controller<MainModel, MainView> {

	public MainController(MainView view, MainModel model,
			TaskManager taskManager) {
		super(view, model, taskManager);

	}

	@Override
	protected void assignListeners() {
		view.getNetworkTab().getBtnRegisterNewServer()
				.addActionListener(new RegisterNewServerHandle());

	}

	private class RegisterNewServerHandle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String address = JOptionPane.showInputDialog(view,
					"Enter the server address (Host address or IP address):",
					"Register New Server", JOptionPane.QUESTION_MESSAGE);
			if (address != null) {
				// check if valid address
				try {
					InetAddress addr = InetAddress.getByName(address);
					try {
						boolean isReachable = addr.isReachable(9999);
						if (isReachable) {
							
							JOptionPane.showMessageDialog(view,
									"Connection to host successful.",
									"Error", JOptionPane.ERROR_MESSAGE);
							
							model.getRegisteredServerList().add(
									new Recipient(addr.getAddress(), Integer
											.parseInt(Configuration
													.getProperty("port"))));
							view.getNetworkTab().updateServerListTable();
						} else {
							JOptionPane.showMessageDialog(view,
									"Unable to reach host.", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(view,
								"A network connection error occurred.",
								"Error", JOptionPane.ERROR_MESSAGE);

					}

				} catch (UnknownHostException e1) {
					JOptionPane.showMessageDialog(view,
							"Failed to determine host.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		}
	}

}
