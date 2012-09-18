package wsintelliauction.server.frontend.mvc.mainwindow;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import wsintelliauction.gui.View;
import wsintelliauction.gui.tabs.ConsoleTab;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.AuctionTabView;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.ChannelsTabView;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.ClientsTabView;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.DatabaseTabView;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.DeviceTabView;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.LeasesTabView;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.ServerTabView;
import java.awt.BorderLayout;

public class MainView extends View<MainModel> {

	/**
	 * Window components
	 */
	private JPanel mainContentPane;
	private ChannelsTabView channelsTab;
	private ClientsTabView clientsTab;
	private LeasesTabView leasesTab;
	private AuctionTabView auctionTab;
	private ServerTabView serverTab;
	private DatabaseTabView databaseTab;
	private DeviceTabView deviceTab;
	private ConsoleTab consoleTab;

	private JMenuBar menuBar;
	private JMenu fileMenu, editMenu, optionsMenu, helpMenu;

	/**
	 * Create the application.
	 */
	public MainView(MainModel model) {
		super(model);
	}

	/**
	 * Initialise the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected void initialize() {
		setTitle("WSIntelliAuction Server");

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		optionsMenu = new JMenu("Options");
		helpMenu = new JMenu("Help");

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(optionsMenu);
		menuBar.add(helpMenu);

		mainContentPane = new JPanel();
		setContentPane(mainContentPane);
		mainContentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
		mainContentPane.add(tabs);

		channelsTab = new ChannelsTabView();
		tabs.addTab(channelsTab.getName(), null, channelsTab, "View and manage radio-band frequency channels");

		clientsTab = new ClientsTabView();
		tabs.addTab(clientsTab.getName(), null, clientsTab, "View and manage all connected clients");

		leasesTab = new LeasesTabView();
		tabs.addTab(leasesTab.getName(), null, leasesTab, "View and manage all leases");

		auctionTab = new AuctionTabView();
		tabs.addTab(auctionTab.getName(), null, auctionTab, "View and manage bids");

		serverTab = new ServerTabView();
		tabs.addTab(serverTab.getName(), null, serverTab, "View and manage server settings");

		databaseTab = new DatabaseTabView();
		tabs.addTab(databaseTab.getName(), null, databaseTab, "Manage and query database");

		deviceTab = new DeviceTabView();
		tabs.addTab(deviceTab.getName(), null, deviceTab, "View and manage devices");

		consoleTab = new ConsoleTab();
		tabs.addTab(consoleTab.getName(), null, consoleTab, "View event and error messages");

	}

	public ChannelsTabView getChannelsTab() {
		return channelsTab;
	}

	public ClientsTabView getClientsTab() {
		return clientsTab;
	}

	public LeasesTabView getLeasesTab() {
		return leasesTab;
	}

	public AuctionTabView getAuctionTab() {
		return auctionTab;
	}

	public JPanel getServerTab() {
		return serverTab;
	}

	public DatabaseTabView getDatabaseTab() {
		return databaseTab;
	}

	public DeviceTabView getDeviceTab() {
		return deviceTab;
	}

	public JPanel getConsoleTab() {
		return consoleTab;
	}
}
