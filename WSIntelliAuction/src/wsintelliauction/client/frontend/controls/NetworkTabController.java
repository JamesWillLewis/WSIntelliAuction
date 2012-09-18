package wsintelliauction.client.frontend.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import wsintelliauction.client.frontend.models.NetworkTabModel;
import wsintelliauction.client.frontend.views.NetworkTabView;
import wsintelliauction.gui.Controller;
import wsintelliauction.net.Recipient;
import wsintelliauction.task.TaskManager;
import wsintelliauction.util.Configuration;

public class NetworkTabController extends
		Controller<NetworkTabModel, NetworkTabView> {

	public NetworkTabController(NetworkTabView view, NetworkTabModel model,
			TaskManager taskManager) {
		super(view, model, taskManager);
	}

	@Override
	protected void assignListeners() {
		view.getBtnRegisterNewServer().addActionListener(
				new RegisterNewServerHandle());

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
									"Communication to host was successful.",
									"Success", JOptionPane.INFORMATION_MESSAGE);

							model.getRegisteredServerList().add(
									new Recipient(addr.getAddress(), Integer
											.parseInt(Configuration
													.getProperty("port"))));
							view.updateServerListTable();
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
