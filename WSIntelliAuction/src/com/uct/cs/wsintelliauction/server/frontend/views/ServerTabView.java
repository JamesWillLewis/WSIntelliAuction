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

import com.uct.cs.wsintelliauction.server.frontend.models.ServerTabModel;
import com.uct.cs.wsintelliauction.window.View;

import net.miginfocom.swing.MigLayout;

public class ServerTabView extends View<ServerTabModel> {
	public ServerTabView(ServerTabModel model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

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

		setBorder(new TitledBorder(null, "Server Settings",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setLayout(new MigLayout("", "[84.00][85.00px:n][grow]",
				"[][][][][][][][grow,bottom]"));

		JLabel lblNewLabel = new JLabel("Host name:");
		add(lblNewLabel, "cell 0 0,alignx right");

		hostNameField = new JTextField();
		hostNameField.setEditable(false);
		add(hostNameField, "cell 2 0,alignx right");
		hostNameField.setColumns(20);

		JLabel lblNewLabel_1 = new JLabel("Host Address:");
		add(lblNewLabel_1, "cell 0 1,alignx right");

		hostAddressField = new JTextField();
		hostAddressField.setEditable(false);
		add(hostAddressField, "cell 2 1,alignx right");
		hostAddressField.setColumns(20);

		JLabel lblNewLabel_2 = new JLabel("IP Address:");
		add(lblNewLabel_2, "cell 0 2,alignx right");

		IPAddressField = new JTextField();
		IPAddressField.setEditable(false);
		add(IPAddressField, "cell 2 2,alignx right");
		IPAddressField.setColumns(20);

		JLabel lblNewLabel_3 = new JLabel("Port:");
		add(lblNewLabel_3, "cell 0 3,alignx right");

		portField = new JTextField();
		portField.setEditable(false);
		add(portField, "cell 2 3,alignx right");
		portField.setColumns(20);

		JLabel lblState = new JLabel("State:");
		add(lblState, "cell 0 4,alignx right");

		stateField = new JTextField();
		stateField.setEditable(false);
		add(stateField, "cell 2 4,alignx right");
		stateField.setColumns(20);

		JLabel lblConnections = new JLabel("Connections:");
		add(lblConnections, "cell 0 5,alignx right");

		connectionsField = new JTextField();
		connectionsField.setEditable(false);
		add(connectionsField, "cell 2 5,alignx right");
		connectionsField.setColumns(20);

		JSeparator separator = new JSeparator();
		add(separator, "cell 0 6 3 1,grow");

		if (model.isServerOn())
			btnNewButton = new JButton("Stop Server");
		else {
			btnNewButton = new JButton("Start Server");
		}

		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		add(btnNewButton, "cell 0 7,aligny bottom");

		JCheckBox chckbxAcceptConnections_1 = new JCheckBox(
				"Accept Connections");
		chckbxAcceptConnections_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(chckbxAcceptConnections_1, "cell 2 7,alignx right");
		refreshServerStats();
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
