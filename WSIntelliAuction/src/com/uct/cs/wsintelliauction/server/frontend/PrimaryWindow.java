package com.uct.cs.wsintelliauction.server.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PrimaryWindow extends JFrame {

	private JPanel mainContentPane;
	private JTable channelManagementTable;
	private JTable clientManagementTable;
	private JTabbedPane biddingManagementPanel;
	private JPanel consolePanel;
	private JPanel brokerManagementPanel;
	private JPanel CIManagementPanel;
	private JScrollPane scrollPane;
	private JTextArea txtrChannelPartitioning;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnSettings;
	private JMenu mnHelp;
	private JPanel channelManagementPanel;
	private JPanel clientManagementPanel;

	/**
	 * Launch the application.
	 */
	public boolean launch(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimaryWindow frame = new PrimaryWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return true;
	}

	/**
	 * Create the frame.
	 */
	public PrimaryWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 469);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		mainContentPane = new JPanel();
		mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainContentPane);
		GridBagLayout gbl_mainContentPane = new GridBagLayout();
		gbl_mainContentPane.columnWidths = new int[]{0, 0, 0};
		gbl_mainContentPane.rowHeights = new int[]{0, 0, 0};
		gbl_mainContentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_mainContentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		mainContentPane.setLayout(gbl_mainContentPane);
		
		channelManagementPanel = new JPanel();
		channelManagementPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Channel Management", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_channelManagementPanel = new GridBagConstraints();
		gbc_channelManagementPanel.fill = GridBagConstraints.BOTH;
		gbc_channelManagementPanel.gridwidth = 2;
		gbc_channelManagementPanel.insets = new Insets(0, 0, 5, 5);
		gbc_channelManagementPanel.gridx = 0;
		gbc_channelManagementPanel.gridy = 0;
		mainContentPane.add(channelManagementPanel, gbc_channelManagementPanel);
		GridBagLayout gbl_channelManagementPanel = new GridBagLayout();
		gbl_channelManagementPanel.columnWidths = new int[]{0, 0, 0};
		gbl_channelManagementPanel.rowHeights = new int[]{0, 0};
		gbl_channelManagementPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_channelManagementPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		channelManagementPanel.setLayout(gbl_channelManagementPanel);
		
		JScrollPane channelManagementScrollPane = new JScrollPane();
		GridBagConstraints gbc_channelManagementScrollPane = new GridBagConstraints();
		gbc_channelManagementScrollPane.fill = GridBagConstraints.BOTH;
		gbc_channelManagementScrollPane.gridwidth = 2;
		gbc_channelManagementScrollPane.gridx = 0;
		gbc_channelManagementScrollPane.gridy = 0;
		channelManagementPanel.add(channelManagementScrollPane, gbc_channelManagementScrollPane);
		channelManagementScrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		channelManagementTable = new JTable();
		channelManagementTable.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		channelManagementTable.setGridColor(Color.LIGHT_GRAY);
		channelManagementTable.setFillsViewportHeight(true);
		channelManagementTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"ch1", "10-20", "4", "pu1", "su1"},
				{"ch2", "22-28", "5", "pu2", "su1"},
				{"ch3", "55-65", "9", "pu1", "su2"},
			},
			new String[] {
				"Channel ID", "Frequency Range (KHz)", "Power Limitation (mW)", "Primary User", "Secondary User"
			}
		));
		channelManagementTable.getColumnModel().getColumn(1).setPreferredWidth(142);
		channelManagementTable.getColumnModel().getColumn(2).setPreferredWidth(133);
		channelManagementTable.getColumnModel().getColumn(4).setPreferredWidth(109);
		channelManagementScrollPane.setViewportView(channelManagementTable);
		
		clientManagementPanel = new JPanel();
		clientManagementPanel.setBorder(new TitledBorder(null, "Client Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_clientManagementPanel = new GridBagConstraints();
		gbc_clientManagementPanel.fill = GridBagConstraints.BOTH;
		gbc_clientManagementPanel.insets = new Insets(5, 0, 5, 5);
		gbc_clientManagementPanel.gridx = 0;
		gbc_clientManagementPanel.gridy = 1;
		mainContentPane.add(clientManagementPanel, gbc_clientManagementPanel);
		GridBagLayout gbl_clientManagementPanel = new GridBagLayout();
		gbl_clientManagementPanel.columnWidths = new int[]{0, 0};
		gbl_clientManagementPanel.rowHeights = new int[]{0, 0};
		gbl_clientManagementPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_clientManagementPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		clientManagementPanel.setLayout(gbl_clientManagementPanel);
		
		JScrollPane clientManagementScrollPane = new JScrollPane();
		GridBagConstraints gbc_clientManagementScrollPane = new GridBagConstraints();
		gbc_clientManagementScrollPane.fill = GridBagConstraints.BOTH;
		gbc_clientManagementScrollPane.gridx = 0;
		gbc_clientManagementScrollPane.gridy = 0;
		clientManagementPanel.add(clientManagementScrollPane, gbc_clientManagementScrollPane);
		clientManagementScrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		clientManagementTable = new JTable();
		clientManagementTable.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		clientManagementTable.setGridColor(Color.LIGHT_GRAY);
		clientManagementTable.setFillsViewportHeight(true);
		clientManagementTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"su1", "pu1.wifi.net", "10.0.0.8", "ch1, ch2"},
				{"su2", "pu2.wifi.net", "10.0.0.9", "ch3"},
			},
			new String[] {
				"Client ID", "Hostname", "IP Address", "Channels Leased"
			}
		));
		clientManagementTable.getColumnModel().getColumn(1).setPreferredWidth(169);
		clientManagementTable.getColumnModel().getColumn(2).setPreferredWidth(149);
		clientManagementTable.getColumnModel().getColumn(3).setPreferredWidth(151);
		clientManagementScrollPane.setViewportView(clientManagementTable);
		
		biddingManagementPanel = new JTabbedPane(JTabbedPane.TOP);
		biddingManagementPanel.setBorder(new TitledBorder(null, "Bidding Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_biddingManagementPanel = new GridBagConstraints();
		gbc_biddingManagementPanel.insets = new Insets(5, 0, 5, 5);
		gbc_biddingManagementPanel.fill = GridBagConstraints.BOTH;
		gbc_biddingManagementPanel.gridx = 1;
		gbc_biddingManagementPanel.gridy = 1;
		mainContentPane.add(biddingManagementPanel, gbc_biddingManagementPanel);
		
		consolePanel = new JPanel();
		biddingManagementPanel.addTab("Console", null, consolePanel, null);
		consolePanel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		consolePanel.add(scrollPane, BorderLayout.CENTER);
		
		txtrChannelPartitioning = new JTextArea();
		txtrChannelPartitioning.setText("  <Auction for channel 14 has begun>\r\n-- Channel Partitioning Commencing --\r\n-- Bids Have been Ammounced to client --\r\n-- Time Remaining in Bid ...\r\n-- Time Remaining in Bid ...\r\n\t.\r\n\t.\r\n-- Bids have closed! --\r\n-- CI is best solutions calculating solutions --\r\n-- Solution Verified --\r\n-- Announcing Winners --\r\n-- Signining Leases --\r\n  <Auction for channel 14 Closed>\r\n");
		scrollPane.setViewportView(txtrChannelPartitioning);
		
		brokerManagementPanel = new JPanel();
		biddingManagementPanel.addTab("Broker Management", null, brokerManagementPanel, null);
		
		CIManagementPanel = new JPanel();
		biddingManagementPanel.addTab("CI Management", null, CIManagementPanel, null);
	}

}
