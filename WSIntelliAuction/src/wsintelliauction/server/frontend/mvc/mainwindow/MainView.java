package wsintelliauction.server.frontend.mvc.mainwindow;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import wsintelliauction.gui.View;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class MainView extends View<MainModel>{

	/**
	 * Window components
	 */
	private JPanel mainContentPane;
	private JTable table;



	/**
	 * Create the application.
	 */
	public MainView(MainModel model) {
		super(model);
	}

	/**
	 * Initialise the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	protected void initialize() {
		setTitle("WSIntelliAuction Server");
		mainContentPane = new JPanel();
		setContentPane(mainContentPane);
		GridBagLayout gbl_mainContentPane = new GridBagLayout();
		gbl_mainContentPane.columnWeights = new double[]{1.0};
		gbl_mainContentPane.rowWeights = new double[]{1.0};
		mainContentPane.setLayout(gbl_mainContentPane);
		
		JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabs = new GridBagConstraints();
		gbc_tabs.fill = GridBagConstraints.BOTH;
		gbc_tabs.anchor = GridBagConstraints.NORTHWEST;
		gbc_tabs.gridx = 0;
		gbc_tabs.gridy = 0;
		mainContentPane.add(tabs, gbc_tabs);
		
		JPanel channelsTab = new JPanel();
		channelsTab.setBorder(new TitledBorder(null, "Channel Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabs.addTab("Channels", null, channelsTab, null);
		
		JPanel clientsTab = new JPanel();
		clientsTab.setBorder(new TitledBorder(null, "Client Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabs.addTab("Clients", null, clientsTab, null);
		
		JPanel leasesTab = new JPanel();
		leasesTab.setBorder(new TitledBorder(null, "Lease Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabs.addTab("Leases", null, leasesTab, null);
		
		JPanel auctionTab = new JPanel();
		auctionTab.setBorder(new TitledBorder(null, "Auction Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabs.addTab("Auction", null, auctionTab, null);
		
		JPanel serverTab = new JPanel();
		serverTab.setBorder(new TitledBorder(null, "Server Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabs.addTab("Server", null, serverTab, null);
		serverTab.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		serverTab.add(tabbedPane);
		
		JPanel serverConnectionsTab = new JPanel();
		serverConnectionsTab.setBorder(new TitledBorder(null, "Connected Clients", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("Connections", null, serverConnectionsTab, null);
		GridBagLayout gbl_serverConnectionsTab = new GridBagLayout();
		gbl_serverConnectionsTab.columnWidths = new int[]{0, 0};
		gbl_serverConnectionsTab.rowHeights = new int[]{0, 0, 0};
		gbl_serverConnectionsTab.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_serverConnectionsTab.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		serverConnectionsTab.setLayout(gbl_serverConnectionsTab);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		serverConnectionsTab.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"James-PC", "JWL005", "10.0.0.4", "CONNECTED", "07H10 09/15/12", "34s"},
				{"nightmare", "NM001", "128.0.24.120", "ACTIVE", "07H10 09/15/12", "34s"},
			},
			new String[] {
				"Host Name", "Secondary User ID", "IP Address", "State", "Connected At", "Connection Time"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(118);
		table.getColumnModel().getColumn(1).setPreferredWidth(133);
		table.getColumnModel().getColumn(2).setPreferredWidth(117);
		table.getColumnModel().getColumn(3).setPreferredWidth(137);
		table.getColumnModel().getColumn(4).setPreferredWidth(117);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		scrollPane.setViewportView(table);
		
		JPanel buttonsPanel = new JPanel();
		GridBagConstraints gbc_buttonsPanel = new GridBagConstraints();
		gbc_buttonsPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonsPanel.gridx = 0;
		gbc_buttonsPanel.gridy = 1;
		serverConnectionsTab.add(buttonsPanel, gbc_buttonsPanel);
		GridBagLayout gbl_buttonsPanel = new GridBagLayout();
		gbl_buttonsPanel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_buttonsPanel.rowWeights = new double[]{0.0};
		buttonsPanel.setLayout(gbl_buttonsPanel);
		
		JButton btnDisconnect = new JButton("Disconnect");
		GridBagConstraints gbc_btnDisconnect = new GridBagConstraints();
		gbc_btnDisconnect.insets = new Insets(0, 0, 0, 5);
		gbc_btnDisconnect.anchor = GridBagConstraints.WEST;
		gbc_btnDisconnect.gridx = 0;
		gbc_btnDisconnect.gridy = 0;
		buttonsPanel.add(btnDisconnect, gbc_btnDisconnect);
		
		JButton btnResetConnection = new JButton("Reset Connection");
		GridBagConstraints gbc_btnResetConnection = new GridBagConstraints();
		gbc_btnResetConnection.insets = new Insets(0, 0, 0, 5);
		gbc_btnResetConnection.anchor = GridBagConstraints.WEST;
		gbc_btnResetConnection.gridx = 1;
		gbc_btnResetConnection.gridy = 0;
		buttonsPanel.add(btnResetConnection, gbc_btnResetConnection);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Filter Connected Only");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 0;
		buttonsPanel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JPanel serverSettingsTab = new JPanel();
		tabbedPane.addTab("Settings", null, serverSettingsTab, null);
		
		JPanel serverConsoleTab = new JPanel();
		tabbedPane.addTab("Console", null, serverConsoleTab, null);
		
		JPanel databaseTab = new JPanel();
		databaseTab.setBorder(new TitledBorder(null, "Database Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabs.addTab("Database", null, databaseTab, null);
		
		JPanel deviceTab = new JPanel();
		deviceTab.setBorder(new TitledBorder(null, "Device Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabs.addTab("Device", null, deviceTab, null);
		
		JPanel consoleTab = new JPanel();
		consoleTab.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Console Messages", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabs.addTab("Console", null, consoleTab, null);
		
	}

}
