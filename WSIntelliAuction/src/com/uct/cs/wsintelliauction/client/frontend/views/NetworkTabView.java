package com.uct.cs.wsintelliauction.client.frontend.views;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.client.frontend.models.NetworkTabModel;
import com.uct.cs.wsintelliauction.window.View;

import net.miginfocom.swing.MigLayout;

public class NetworkTabView extends View<NetworkTabModel> {

	public NetworkTabView(NetworkTabModel model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	private JTable serversTable;
	private JButton btnRegisterNewServer;
	private JButton btnRemoveServer;
	private JButton btnPing;
	private JButton btnConnectTo;
	private JButton btnDisconnectButton;

	@Override
	public String toString() {
		return "Network";
	}

	public JButton getBtnRegisterNewServer() {
		return btnRegisterNewServer;
	}
	


	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	protected void initialize() {
		setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)),
				"Network Connection Management", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[grow][]"));

		JPanel registeredServersPanel = new JPanel();
		registeredServersPanel.setBorder(new TitledBorder(new LineBorder(
				new Color(0, 0, 0)), "Registered Servers",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(registeredServersPanel, "flowy,cell 0 0,grow");
		registeredServersPanel.setLayout(new MigLayout("", "[grow][]",
				"[grow][]"));

		JScrollPane scrollPane = new JScrollPane();
		registeredServersPanel.add(scrollPane, "cell 0 0 2 1,grow");

		serversTable = new JTable(model.getRegisteredServersTableModel());
		serversTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		serversTable.setCellSelectionEnabled(false);
		serversTable.setRowSelectionAllowed(true);

		scrollPane.setViewportView(serversTable);

		btnRegisterNewServer = new JButton("Register New Server");

		registeredServersPanel.add(btnRegisterNewServer, "flowx,cell 0 1");

		btnRemoveServer = new JButton("Remove Server");
		registeredServersPanel.add(btnRemoveServer, "cell 0 1");

		btnConnectTo = new JButton("Connect To");
		registeredServersPanel.add(btnConnectTo, "flowx,cell 1 1,alignx right");

		btnDisconnectButton = new JButton("Disconnect");
		registeredServersPanel.add(btnDisconnectButton, "cell 1 1,alignx right");

		btnPing = new JButton("Ping");
		registeredServersPanel.add(btnPing, "cell 1 1");

		JPanel connectionInfoPanel = new JPanel();
		connectionInfoPanel.setBorder(new TitledBorder(null,
				"Connection Information", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		add(connectionInfoPanel, "cell 0 1,grow");
		connectionInfoPanel.setLayout(new MigLayout("", "[80px][grow]",
				"[16px]"));

		JLabel lblServerStatus = new JLabel("Server status:");
		connectionInfoPanel.add(lblServerStatus,
				"cell 0 0,alignx left,aligny top");

		JLabel lblRunning = new JLabel("RUNNING");
		connectionInfoPanel.add(lblRunning, "cell 1 0,alignx center");
	}


	public JButton getBtnRemoveServer() {
		return btnRemoveServer;
	}
	
	public int getSelectedServer(){
		return serversTable.getSelectedRow();
	}
	public JButton getBtnPing() {
		return btnPing;
	}
	public JButton getBtnConnectTo() {
		return btnConnectTo;
	}
	public JButton getBtnDisconnectButton() {
		return btnDisconnectButton;
	}
}
