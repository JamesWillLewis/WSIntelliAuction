package wsintelliauction.server.frontend.mvc.mainwindow.tabs;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSlider;
import javax.swing.JSeparator;

public class ServerTabView extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public ServerTabView() {
		init();
	}

	private void init() {
		setLayout(new BorderLayout(0, 0));

		JTabbedPane serverTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(serverTabbedPane);

		JPanel serverConnectionsTab = new JPanel();
		serverConnectionsTab.setBorder(new TitledBorder(null,
				"Connected Clients", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		serverTabbedPane.addTab("Connections", null, serverConnectionsTab, null);
		serverConnectionsTab.setLayout(new MigLayout("", "[grow][]", "[grow][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		serverConnectionsTab.add(scrollPane, "cell 0 0 2 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Host Name", "Host Address", "IP Address", "Connected At", "Time Online", "SU ID", "State"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(124);
		table.getColumnModel().getColumn(4).setPreferredWidth(114);
		scrollPane.setViewportView(table);
		
		JButton btnDisconnectClient = new JButton("Disconnect Client");
		serverConnectionsTab.add(btnDisconnectClient, "flowx,cell 0 1,aligny bottom");
		
		JButton btnSendMessage = new JButton("Send Message");
		serverConnectionsTab.add(btnSendMessage, "cell 0 1,aligny bottom");
		
		JCheckBox chckbxAcceptConnections = new JCheckBox("Show disconnected");
		serverConnectionsTab.add(chckbxAcceptConnections, "cell 1 1");

		JPanel serverSettingsTab = new JPanel();
		serverSettingsTab.setBorder(new TitledBorder(null, "Server Settings", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		serverTabbedPane.addTab("Settings", null, serverSettingsTab, null);
		serverSettingsTab.setLayout(new MigLayout("", "[84.00][85.00px:n][grow]", "[][][][][][][][grow,bottom]"));
		
		JLabel lblNewLabel = new JLabel("Host name:");
		serverSettingsTab.add(lblNewLabel, "cell 0 0,alignx right");
		
		textField = new JTextField();
		serverSettingsTab.add(textField, "cell 2 0,alignx right");
		textField.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("Host Address:");
		serverSettingsTab.add(lblNewLabel_1, "cell 0 1,alignx right");
		
		textField_1 = new JTextField();
		serverSettingsTab.add(textField_1, "cell 2 1,alignx right");
		textField_1.setColumns(20);
		
		JLabel lblNewLabel_2 = new JLabel("IP Address:");
		serverSettingsTab.add(lblNewLabel_2, "cell 0 2,alignx right");
		
		textField_2 = new JTextField();
		serverSettingsTab.add(textField_2, "cell 2 2,alignx right");
		textField_2.setColumns(20);
		
		JLabel lblNewLabel_3 = new JLabel("Port:");
		serverSettingsTab.add(lblNewLabel_3, "cell 0 3,alignx right");
		
		textField_3 = new JTextField();
		serverSettingsTab.add(textField_3, "cell 2 3,alignx right");
		textField_3.setColumns(20);
		
		JLabel lblState = new JLabel("State:");
		serverSettingsTab.add(lblState, "cell 0 4,alignx right");
		
		textField_4 = new JTextField();
		serverSettingsTab.add(textField_4, "cell 2 4,alignx right");
		textField_4.setColumns(20);
		
		JLabel lblConnections = new JLabel("Connections:");
		serverSettingsTab.add(lblConnections, "cell 0 5,alignx right");
		
		textField_5 = new JTextField();
		serverSettingsTab.add(textField_5, "cell 2 5,alignx right");
		textField_5.setColumns(20);
		
		JSeparator separator = new JSeparator();
		serverSettingsTab.add(separator, "cell 0 6 3 1,grow");
		
		JButton btnNewButton = new JButton("Restart Server");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		serverSettingsTab.add(btnNewButton, "cell 0 7,aligny bottom");
		
		JButton btnNewButton_1 = new JButton("Shutdown");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		serverSettingsTab.add(btnNewButton_1, "cell 1 7,aligny bottom");
		
		JCheckBox chckbxAcceptConnections_1 = new JCheckBox("Accept Connections");
		chckbxAcceptConnections_1.setHorizontalAlignment(SwingConstants.CENTER);
		serverSettingsTab.add(chckbxAcceptConnections_1, "cell 2 7,alignx right");

		JPanel serverConsoleTab = new JPanel();
		serverConsoleTab.setBorder(new TitledBorder(null, "Console Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		serverTabbedPane.addTab("Console", null, serverConsoleTab, null);
		serverConsoleTab.setLayout(new BorderLayout(0, 0));
		
		JScrollPane consolePane = new JScrollPane();
		serverConsoleTab.add(consolePane);
		
		JTextArea serverConsole = new JTextArea();
		serverConsole.setText("> Initializing server...\r\n> Establishing connection...\r\n> Creating host...\r\n> Opening socket...\r\n> Server active.\r\n> Client connected...\r\n> ETC....\r\n\r\n(this console can be upgraded and stuff, maybe have its own proper log file)");
		consolePane.setViewportView(serverConsole);
	}
	
	@Override
	public String getName() {
		return "Server";
	}

}
