package com.uct.cs.wsintelliauction.server.frontend.models;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.server.backend.network.Client;
import com.uct.cs.wsintelliauction.window.Model;

public class ClientsTabModel extends Model<ServerResourceContainer> {

	/**
	 * Client table list model
	 */
	private ClientTableModel clientTableModel;

	private List<Client> clients;

	public ClientsTabModel(ServerResourceContainer resourceManager) {
		super(resourceManager);
	}

	@Override
	public void reset() {
		clientTableModel = new ClientTableModel();
		clients = resourceManager.getClients();
	}

	class ClientTableModel extends DefaultTableModel {

		public ClientTableModel() {
			super(new String[] { "Host name", "IP Address", "Status" }, 0);
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
					return clients.get(row).getConnection()
							.getRecipientAddress().getHostName();
				case 1:
					return clients.get(row).getConnection()
							.getRecipientAddress().getHostAddress();
				case 2:
					return clients.get(row).getConnection()
							.isConnectionActive() ? "CONNECTED"
							: "DISCONNECTED";
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
