package com.uct.cs.wsintelliauction.client.frontend.models;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceManager;
import com.uct.cs.wsintelliauction.gui.Model;
import com.uct.cs.wsintelliauction.net.Recipient;
import com.uct.cs.wsintelliauction.util.AppConfig;
import com.uct.cs.wsintelliauction.util.ErrorLogger;
import com.uct.cs.wsintelliauction.util.EventLogger;

public class NetworkTabModel extends Model<ClientResourceManager> {

	private NetworkTableModel registeredServersTableModel;

	public NetworkTabModel(ClientResourceManager resourceManager) {
		super(resourceManager);
	}

	@Override
	public void reset() {
		registeredServersTableModel = new NetworkTableModel();
		registeredServersTableModel.setColumnIdentifiers(new String[] {
				"Host name", "Host Address", "IP Address", "Connected" });

		for (Recipient r : resourceManager.getStorableServerList()
				.getServerList()) {
			InetAddress addr = r.getInetAddress();
			Object[] insert = { addr.getHostName(),
					addr.getCanonicalHostName(), addr.getHostAddress(), false };
			registeredServersTableModel.addRow(insert);
		}
	}

	public NetworkTableModel getRegisteredServersTableModel() {
		return registeredServersTableModel;
	}

	public void registerServer(String address) {

		try {
			InetAddress addr = InetAddress.getByName(address);
			try {
				boolean isReachable = addr.isReachable(9999);
				if (isReachable) {

					JOptionPane.showMessageDialog(null,
							"Communication to host was successful.", "Success",
							JOptionPane.INFORMATION_MESSAGE);

					Recipient r = new Recipient(addr.getAddress(),
							Integer.parseInt(AppConfig.getProperty("port")));

					EventLogger
							.log("New server registered: " + r.getHostName());

					resourceManager.getStorableServerList().add(r);

					Object[] insert = { addr.getHostName(),
							addr.getCanonicalHostName(), addr.getHostAddress(),
							false };
					registeredServersTableModel.addRow(insert);

				} else {
					ErrorLogger.log("Unreachable host");
					JOptionPane.showMessageDialog(null,
							"Unable to reach host.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e1) {
				ErrorLogger.log("Network Error Occurred");
				JOptionPane.showMessageDialog(null,
						"A network connection error occurred.", "Error",
						JOptionPane.ERROR_MESSAGE);

			}
		} catch (UnknownHostException e1) {
			ErrorLogger.log("Failed to determine host");
			JOptionPane.showMessageDialog(null, "Failed to determine host.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@SuppressWarnings("serial")
	class NetworkTableModel extends DefaultTableModel {

		@SuppressWarnings("rawtypes")
		private Class[] columnTypes = new Class[] { Object.class, Object.class,
				Object.class, Boolean.class };

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}

	public void removeServer(int row) {
		if (row >= 0 && row < resourceManager.getStorableServerList().size()) {
			resourceManager.getStorableServerList().remove(row);
			registeredServersTableModel.removeRow(row);
		}
	}

	public void pingServer(int index) {
		if (index >= 0
				&& index < resourceManager.getStorableServerList().size()) {
			Recipient server = resourceManager.getStorableServerList().get(
					index);

			try {
				if (server.getInetAddress().isReachable(9999)) {
					JOptionPane.showMessageDialog(null,
							"Communication to host was successful.", "Success",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,
							"The host is not responding.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"A network connection error occurred.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void connectTo(int select) {
		if (select >= 0
				&& select < resourceManager.getStorableServerList().size()) {
			Recipient server = resourceManager.getStorableServerList().get(
					select);
			boolean success = resourceManager.getNetworkManager().connectTo(
					server);
			if (success) {
				JOptionPane.showMessageDialog(null, "Connection to host: "
						+ server.getHostName() + " was successful.", "Success",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Connection to host: "
						+ server.getHostName() + " failed.", "Warning",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
