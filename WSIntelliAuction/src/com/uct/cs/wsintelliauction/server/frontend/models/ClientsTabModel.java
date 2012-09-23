package com.uct.cs.wsintelliauction.server.frontend.models;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.gui.Model;
import com.uct.cs.wsintelliauction.net.NetworkConnection;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceManager;

public class ClientsTabModel extends Model<ServerResourceManager> {

	/**
	 * Client table list model
	 */
	private ClientTableModel clientTableModel;

	private List<NetworkConnection> clients;

	public ClientsTabModel(ServerResourceManager resourceManager) {
		super(resourceManager);
	}

	@Override
	public void reset() {
		clientTableModel = new ClientTableModel();
		clients = resourceManager.getServerNetworkManager()
				.getClientConnections();
	}

	class ClientTableModel extends DefaultTableModel {

		public ClientTableModel() {
			super(new String[] { "Host name", "IP Address", "Bids Placed",
					"Leases Held", "Status" }, 0);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

		@Override
		public int getRowCount() {
			if (clients != null)
				return clients.size();
			else
				return 0;
		}

		@Override
		public Object getValueAt(int row, int column) {
			if (clients != null) {
				switch (column) {
				case 0:
					return clients.get(row).getRecipientAddress().getHostName();
				case 1:
					return clients.get(row).getRecipientAddress()
							.getHostAddress();
				case 2:
					return 0;
				case 3:
					return 0;
				case 4:
					return clients.get(row).isConnectionActive() ? "CONNECTED"
							: "DISCONNCETED";
				default:
					return "???";
				}
			} else
				return "???";
		}

	}

	public ClientTableModel getClientTableModel() {
		return clientTableModel;
	}

	public void fireTableDataChanged() {
		clientTableModel.fireTableDataChanged();
	}

}
