package com.uct.cs.wsintelliauction.client.frontend.models;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.gui.Model;
import com.uct.cs.wsintelliauction.gui.View;
import com.uct.cs.wsintelliauction.net.Recipient;
import com.uct.cs.wsintelliauction.util.AppConfig;


public class NetworkTabModel extends Model {

	private ArrayList<Recipient> registeredServerList;

	private NetworkTableModel registeredServersTableModel;

	@Override
	public void reset() {
		registeredServerList = new ArrayList<Recipient>();
		registeredServersTableModel = new NetworkTableModel();
		registeredServersTableModel.setColumnIdentifiers(new String[] {
				"Server ID", "Host name", "Host Address", "IP Address",
				"Connected" });
	}

	public NetworkTableModel getRegisteredServersTableModel() {
		return registeredServersTableModel;
	}

	public ArrayList<Recipient> getRegisteredServerList() {
		return registeredServerList;
	}
	
	public void registerServer(Recipient r){
		registeredServerList.add(r);
		InetAddress addr = r.getInetAddress();
		Object[] insert = { "000", addr.getHostName(),
				addr.getCanonicalHostName(),
				addr.getHostAddress(), false };
		registeredServersTableModel.addRow(insert);
		
	}


	class NetworkTableModel extends DefaultTableModel {
		private Class[] columnTypes = new Class[] { Object.class, Object.class,
				Object.class, Object.class, Boolean.class };

		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

}
