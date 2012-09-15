package wsintelliauction.server.frontend.mvc.mainwindow;

import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import wsintelliauction.gui.View;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.AuctionTab;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.ChannelsTab;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.ClientsTab;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.ConsoleTab;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.DatabaseTab;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.DeviceTab;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.LeasesTab;
import wsintelliauction.server.frontend.mvc.mainwindow.tabs.ServerTab;

public class MainView extends View<MainModel> {

	/**
	 * Window components
	 */
	private JPanel mainContentPane;
	private ChannelsTab channelsTab;
	private ClientsTab clientsTab;
	private LeasesTab leasesTab;
	private AuctionTab auctionTab;
	private ServerTab serverTab;
	private DatabaseTab databaseTab;
	private DeviceTab deviceTab;
	private ConsoleTab consoleTab;

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
		mainContentPane = new JPanel();
		setContentPane(mainContentPane);
		GridBagLayout gbl_mainContentPane = new GridBagLayout();
		gbl_mainContentPane.columnWeights = new double[] { 1.0 };
		gbl_mainContentPane.rowWeights = new double[] { 1.0 };
		mainContentPane.setLayout(gbl_mainContentPane);

		JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabs = new GridBagConstraints();
		gbc_tabs.fill = GridBagConstraints.BOTH;
		gbc_tabs.anchor = GridBagConstraints.NORTHWEST;
		gbc_tabs.gridx = 0;
		gbc_tabs.gridy = 0;
		mainContentPane.add(tabs, gbc_tabs);

		channelsTab = new ChannelsTab();
		tabs.addTab(channelsTab.getName(), null, channelsTab, null);

		clientsTab = new ClientsTab();
		tabs.addTab(clientsTab.getName(), null, clientsTab, null);

		leasesTab = new LeasesTab();
		tabs.addTab(leasesTab.getName(), null, leasesTab, null);

		auctionTab = new AuctionTab();
		tabs.addTab(auctionTab.getName(), null, auctionTab, null);

		serverTab = new ServerTab();
		tabs.addTab(serverTab.getName(), null, serverTab, null);

		databaseTab = new DatabaseTab();
		tabs.addTab(databaseTab.getName(), null, databaseTab, null);

		deviceTab = new DeviceTab();
		tabs.addTab(deviceTab.getName(), null, deviceTab, null);

		consoleTab = new ConsoleTab();
		tabs.addTab(consoleTab.getName(), null, consoleTab, null);

	}

	public ChannelsTab getChannelsTab() {
		return channelsTab;
	}

	public ClientsTab getClientsTab() {
		return clientsTab;
	}

	public LeasesTab getLeasesTab() {
		return leasesTab;
	}

	public AuctionTab getAuctionTab() {
		return auctionTab;
	}

	public JPanel getServerTab() {
		return serverTab;
	}

	public DatabaseTab getDatabaseTab() {
		return databaseTab;
	}

	public DeviceTab getDeviceTab() {
		return deviceTab;
	}

	public JPanel getConsoleTab() {
		return consoleTab;
	}
}
