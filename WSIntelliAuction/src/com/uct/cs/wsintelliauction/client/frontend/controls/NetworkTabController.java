package com.uct.cs.wsintelliauction.client.frontend.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import com.uct.cs.wsintelliauction.client.frontend.models.NetworkTabModel;
import com.uct.cs.wsintelliauction.client.frontend.views.NetworkTabView;
import com.uct.cs.wsintelliauction.gui.Controller;
import com.uct.cs.wsintelliauction.net.Recipient;
import com.uct.cs.wsintelliauction.util.AppConfig;

public class NetworkTabController extends
		Controller<NetworkTabModel, NetworkTabView> {

	public NetworkTabController(NetworkTabView view, NetworkTabModel model) {
		super(view, model);
	}

	@Override
	protected void assignListeners() {
		view.getBtnRegisterNewServer().addActionListener(
				new RegisterNewServerHandle());
		view.getBtnRemoveServer().addActionListener(new RemoveServerHandle());
		view.getBtnPing().addActionListener(new PingServerHandle());
		view.getBtnConnectTo().addActionListener(new ConnectToServerHandle());
		view.getBtnDisconnectButton().addActionListener(new DisconnectHandle());
	}

	/**
	 * Registers a new server on the registered server list. Before adding the
	 * server, the model will check to ensure that the server host address is
	 * valid.
	 * 
	 * @author James Lewis
	 */
	private class RegisterNewServerHandle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String address = JOptionPane.showInputDialog(view,
					"Enter the server address (Host address or IP address):",
					"Register New Server", JOptionPane.QUESTION_MESSAGE);
			model.registerServer(address);
		}
	}

	private class RemoveServerHandle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int opt = JOptionPane.showConfirmDialog(view,
					"Are you sure you want to remove the selected server?",
					"Confirm Deletion", JOptionPane.OK_CANCEL_OPTION);
			if (opt == JOptionPane.OK_OPTION) {
				int row = view.getSelectedServer();
				model.removeServer(row);
			}
		}

	}

	private class PingServerHandle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int server = view.getSelectedServer();
			model.pingServer(server);
		}

	}
	
	private class ConnectToServerHandle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int select = view.getSelectedServer();
			model.connectTo(select);
		}
		
	}
	
	private class DisconnectHandle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			model.disconnect();
		}
		
	}

}
