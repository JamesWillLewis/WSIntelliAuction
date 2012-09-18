package wsintelliauction.client.frontend.views;

import javax.swing.JPanel;

import wsintelliauction.client.frontend.models.MainWindowModel;
import wsintelliauction.gui.View;
import wsintelliauction.gui.view.ConsoleTab;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

public class MainWindowView extends View<MainWindowModel> {

	private NetworkTabView networkTab;
	private AuctionTabView auctionTab;
	private LeasesTabView leaseTab;
	private ConsoleTab consoleTab;

	private JPanel contentPane;

	public MainWindowView(MainWindowModel model) {
		super(model);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	protected void initialize() {
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabs, BorderLayout.CENTER);

		auctionTab = new AuctionTabView();
		tabs.addTab(auctionTab.getName(), auctionTab);

		networkTab = new NetworkTabView();
		tabs.addTab(networkTab.getName(), networkTab);

		leaseTab = new LeasesTabView();
		tabs.addTab(leaseTab.getName(), leaseTab);

		consoleTab = new ConsoleTab();
		tabs.addTab(consoleTab.getName(), consoleTab);
	}
	

	public ConsoleTab getConsoleTab() {
		return consoleTab;
	}
	public LeasesTabView getLeaseTab() {
		return leaseTab;
	}
	public NetworkTabView getNetworkTab() {
		return networkTab;
	}
	public AuctionTabView getAuctionTab() {
		return auctionTab;
	}

}
