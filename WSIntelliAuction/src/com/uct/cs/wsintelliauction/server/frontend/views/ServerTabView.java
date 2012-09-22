package com.uct.cs.wsintelliauction.server.frontend.views;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.gui.View;
import com.uct.cs.wsintelliauction.server.frontend.models.ServerTabModel;

import net.miginfocom.swing.MigLayout;

public class ServerTabView extends View<ServerTabModel> {
	public ServerTabView(ServerTabModel model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	private JTable table;
	private JTextField hostNameField;
	private JTextField hostAddressField;
	private JTextField IPAddressField;
	private JTextField portField;
	private JTextField stateField;
	private JTextField connectionsField;
	private JButton btnNewButton;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	protected void initialize() {
		setLayout(new BorderLayout(0, 0));

		JTabbedPane serverTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(serverTabbedPane);

		JPanel serverConnectionsTab = new JPanel();
		serverConnectionsTab.setBorder(new TitledBorder(null,
				"Connected Clients", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		serverTabbedPane
				.addTab("Connections", null, serverConnectionsTab, null);
		serverConnectionsTab
				.setLayout(new MigLayout("", "[grow][]", "[grow][]"));

		JScrollPane scrollPane = new JScrollPane();
		serverConnectionsTab.add(scrollPane, "cell 0 0 2 1,grow");

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Host Name", "Host Address", "IP Address", "Connected At",
				"Time Online", "SU ID", "State" }));
		table.getColumnModel().getColumn(3).setPreferredWidth(124);
		table.getColumnModel().getColumn(4).setPreferredWidth(114);
		scrollPane.setViewportView(table);

		JButton btnDisconnectClient = new JButton("Disconnect Client");
		serverConnectionsTab.add(btnDisconnectClient,
				"flowx,cell 0 1,aligny bottom");

		JButton btnSendMessage = new JButton("Send Message");
		serverConnectionsTab.add(btnSendMessage, "cell 0 1,aligny bottom");

		JCheckBox chckbxAcceptConnections = new JCheckBox("Show disconnected");
		serverConnectionsTab.add(chckbxAcceptConnections, "cell 1 1");

		JPanel serverSettingsTab = new JPanel();
		serverSettingsTab.setBorder(new TitledBorder(null, "Server Settings",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		serverTabbedPane.addTab("Settings", null, serverSettingsTab, null);
		serverSettingsTab.setLayout(new MigLayout("",
				"[84.00][85.00px:n][grow]", "[][][][][][][][grow,bottom]"));

		JLabel lblNewLabel = new JLabel("Host name:");
		serverSettingsTab.add(lblNewLabel, "cell 0 0,alignx right");

		hostNameField = new JTextField();
		hostNameField.setEditable(false);
		serverSettingsTab.add(hostNameField, "cell 2 0,alignx right");
		hostNameField.setColumns(20);

		JLabel lblNewLabel_1 = new JLabel("Host Address:");
		serverSettingsTab.add(lblNewLabel_1, "cell 0 1,alignx right");

		hostAddressField = new JTextField();
		hostAddressField.setEditable(false);
		serverSettingsTab.add(hostAddressField, "cell 2 1,alignx right");
		hostAddressField.setColumns(20);

		JLabel lblNewLabel_2 = new JLabel("IP Address:");
		serverSettingsTab.add(lblNewLabel_2, "cell 0 2,alignx right");

		IPAddressField = new JTextField();
		IPAddressField.setEditable(false);
		serverSettingsTab.add(IPAddressField, "cell 2 2,alignx right");
		IPAddressField.setColumns(20);

		JLabel lblNewLabel_3 = new JLabel("Port:");
		serverSettingsTab.add(lblNewLabel_3, "cell 0 3,alignx right");

		portField = new JTextField();
		portField.setEditable(false);
		serverSettingsTab.add(portField, "cell 2 3,alignx right");
		portField.setColumns(20);

		JLabel lblState = new JLabel("State:");
		serverSettingsTab.add(lblState, "cell 0 4,alignx right");

		stateField = new JTextField();
		stateField.setEditable(false);
		serverSettingsTab.add(stateField, "cell 2 4,alignx right");
		stateField.setColumns(20);

		JLabel lblConnections = new JLabel("Connections:");
		serverSettingsTab.add(lblConnections, "cell 0 5,alignx right");

		connectionsField = new JTextField();
		connectionsField.setEditable(false);
		serverSettingsTab.add(connectionsField, "cell 2 5,alignx right");
		connectionsField.setColumns(20);

		JSeparator separator = new JSeparator();
		serverSettingsTab.add(separator, "cell 0 6 3 1,grow");

		if (model.isServerOn())
			btnNewButton = new JButton("Stop Server");
		else {
			btnNewButton = new JButton("Start Server");
		}

		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		serverSettingsTab.add(btnNewButton, "cell 0 7,aligny bottom");

		JCheckBox chckbxAcceptConnections_1 = new JCheckBox(
				"Accept Connections");
		chckbxAcceptConnections_1.setHorizontalAlignment(SwingConstants.CENTER);
		serverSettingsTab.add(chckbxAcceptConnections_1,
				"cell 2 7,alignx right");

	}

	@Override
	public String toString() {
		return "Server";
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void refreshServerStats() {
		hostNameField.setText(model.getHostNameField());
		hostAddressField.setText(model.getHostAddressField());
		IPAddressField.setText(model.getHostIPField());
		portField.setText(model.getPortField());
		stateField.setText(model.isServerOn() ? "ONLINE" : "OFFLINE");
		connectionsField.setText(model.getConnectionsField());
	}

}
