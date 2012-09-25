package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.server.frontend.controls.MainWindowController;
import com.uct.cs.wsintelliauction.server.frontend.models.MainWindowModel;
import com.uct.cs.wsintelliauction.server.frontend.views.MainWindowView;
import com.uct.cs.wsintelliauction.utility.ResourceContainer;
import com.uct.cs.wsintelliauction.window.Module;
import com.uct.cs.wsintelliauction.window.modules.ConsoleTabModule;


public class MainWindowModule extends
		Module<MainWindowModel, MainWindowView, MainWindowController> {

	private AuctionTabModule auctionTabModule;
	private ChannelTabModule channelTabModule;
	private ClientsTabModule clientsTabModule;
	private DatabaseTabModule databaseTabModule;
	private DeviceTabModule deviceTabModule;
	private LeasesTabModule leasesTabModule;
	private ServerTabModule serverTabModule;
	private ConsoleTabModule consoleTabModule;

	public MainWindowModule(ServerResourceContainer resourceManager) {
		super(resourceManager);
		model = new MainWindowModel(resourceManager);
		view = new MainWindowView(model);
		controller = new MainWindowController(view, model );

		auctionTabModule = new AuctionTabModule(resourceManager);
		channelTabModule = new ChannelTabModule(resourceManager);
		clientsTabModule = new ClientsTabModule(resourceManager);
		databaseTabModule = new DatabaseTabModule(resourceManager);
		deviceTabModule = new DeviceTabModule(resourceManager);
		leasesTabModule = new LeasesTabModule(resourceManager);
		serverTabModule = new ServerTabModule(resourceManager);
		consoleTabModule = new ConsoleTabModule(resourceManager);

		initTabs();
	}

	private void initTabs() {
		view.addTab(auctionTabModule.getView());
		view.addTab(channelTabModule.getView());
		view.addTab(clientsTabModule.getView());
		view.addTab(databaseTabModule.getView());
		view.addTab(deviceTabModule.getView());
		view.addTab(leasesTabModule.getView());
		view.addTab(serverTabModule.getView());
		view.addTab(consoleTabModule.getView());
	}

	public AuctionTabModule getAuctionTabModule() {
		return auctionTabModule;
	}

	public void setAuctionTabModule(AuctionTabModule auctionTabModule) {
		this.auctionTabModule = auctionTabModule;
	}

	public ChannelTabModule getChannelTabModule() {
		return channelTabModule;
	}

	public void setChannelTabModule(ChannelTabModule channelTabModule) {
		this.channelTabModule = channelTabModule;
	}

	public ClientsTabModule getClientsTabModule() {
		return clientsTabModule;
	}

	public void setClientsTabModule(ClientsTabModule clientsTabModule) {
		this.clientsTabModule = clientsTabModule;
	}

	public DatabaseTabModule getDatabaseTabModule() {
		return databaseTabModule;
	}

	public void setDatabaseTabModule(DatabaseTabModule databaseTabModule) {
		this.databaseTabModule = databaseTabModule;
	}

	public DeviceTabModule getDeviceTabModule() {
		return deviceTabModule;
	}

	public void setDeviceTabModule(DeviceTabModule deviceTabModule) {
		this.deviceTabModule = deviceTabModule;
	}

	public LeasesTabModule getLeasesTabModule() {
		return leasesTabModule;
	}

	public void setLeasesTabModule(LeasesTabModule leasesTabModule) {
		this.leasesTabModule = leasesTabModule;
	}

	public ServerTabModule getServerTabModule() {
		return serverTabModule;
	}

	public void setServerTabModule(ServerTabModule serverTabModule) {
		this.serverTabModule = serverTabModule;
	}

	public ConsoleTabModule getConsoleTabModule() {
		return consoleTabModule;
	}

	public void setConsoleTabModule(ConsoleTabModule consoleTabModule) {
		this.consoleTabModule = consoleTabModule;
	}

	@Override
	public void display() {
		view.show();
	}
}
