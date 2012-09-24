package com.uct.cs.wsintelliauction.client.frontend.models;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceContainer;
import com.uct.cs.wsintelliauction.gui.Model;
import com.uct.cs.wsintelliauction.net.Recipient;
import com.uct.cs.wsintelliauction.util.AppConfig;
import com.uct.cs.wsintelliauction.util.ErrorLogger;
import com.uct.cs.wsintelliauction.util.EventLogger;

public class NetworkTabModel extends Model<ClientResourceContainer> {

	private NetworkTableModel registeredServersTableModel;

	public NetworkTabModel(ClientResourceContainer resourceManager) {
		super(resourceManager);
	}

	@Override
	public void reset() {
		registeredServersTableModel = new NetworkTableModel();
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

					registeredServersTableModel.fireTableDataChanged();

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

		public NetworkTableModel() {
			super(new String[] { "Host name", "Host Address", "IP Address",
					"Connected" }, 0);
		}

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

		@Override
		public int getRowCount() {
			if (resourceManager.getStorableServerList() != null)
				return resourceManager.getStorableServerList().size();
			else
				return 0;
		}

		@Override
		public Object getValueAt(int row, int column) {
			if (resourceManager.getStorableServerList() != null) {

				InetAddress addr = resourceManager.getStorableServerList()
						.get(row).getInetAddress();

				switch (column) {
				case 0:
					return addr.getHostName();
				case 1:
					return addr.getCanonicalHostName();
				case 2:
					return addr.getHostAddress();
				case 3:
					return resourceManager.getStorableServerList().get(row)
							.isConnected();
				default:
					return "???";
				}

			} else {
				return "???";
			}
		}

	}

	private int getConnectedServerIndex() {
		for (int i = 0; i < resourceManager.getStorableServerList().size(); i++) {
			if (resourceManager.getStorableServerList().get(i).isConnected()) {
				return i;
			}
		}
		return -1;
	}

	public void removeServer(int row) {
		if (row >= 0 && row < resourceManager.getStorableServerList().size()) {
			if (row != getConnectedServerIndex()
					|| (row == getConnectedServerIndex() && disconnect())) {
				resourceManager.getStorableServerList().remove(row);
				registeredServersTableModel.fireTableDataChanged();
			}
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
		if (select >= 0 && disconnect() && select >= 0
				&& select < resourceManager.getStorableServerList().size()) {

			Recipient server = resourceManager.getStorableServerList().get(
					select);
			boolean success = resourceManager.getNetworkManager().connectTo(
					server);
			if (success) {
				JOptionPane.showMessageDialog(null, "Connection to host: "
						+ server.getHostName() + " was successful.", "Success",
						JOptionPane.INFORMATION_MESSAGE);
				resourceManager.getStorableServerList().get(select)
						.setConnected(true);
				registeredServersTableModel.fireTableDataChanged();
			} else {
				JOptionPane.showMessageDialog(null, "Connection to host: "
						+ server.getHostName() + " failed.", "Warning",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	/**
	 * Disconnect from the currently connected server
	 * 
	 * @param forcedDisconnect
	 *            If true, user isn't prompted to close the connection.
	 * @return True if the client is no longer connected to a server.
	 */
	public boolean disconnect() {
		System.out.println(getConnectedServerIndex());
		if (getConnectedServerIndex() != -1) {

			int select = JOptionPane.showConfirmDialog(
					null,
					"Are you sure you want to disconnect from server host: "
							+ resourceManager.getStorableServerList()
									.get(getConnectedServerIndex())
									.getInetAddress().getHostName(),
					"Confirm disconnect", JOptionPane.OK_CANCEL_OPTION);

			if (select == JOptionPane.OK_OPTION) {
				resourceManager.getNetworkManager().disconnect();
				resourceManager.getStorableServerList()
						.get(getConnectedServerIndex()).setConnected(false);
				registeredServersTableModel.fireTableDataChanged();
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public void serverDisconnected() {
		JOptionPane.showMessageDialog(null, "The server disconnected.",
				"Warning", JOptionPane.WARNING_MESSAGE);
		resourceManager.getStorableServerList()
		.get(getConnectedServerIndex()).setConnected(false);
		registeredServersTableModel.fireTableDataChanged();

	}
}
