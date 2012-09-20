package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.gui.modules.ConsoleTabModule;
import com.uct.cs.wsintelliauction.server.frontend.controls.MainWindowController;
import com.uct.cs.wsintelliauction.server.frontend.models.MainWindowModel;
import com.uct.cs.wsintelliauction.server.frontend.views.MainWindowView;


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

	public MainWindowModule() {
		model = new MainWindowModel();
		view = new MainWindowView(model);
		controller = new MainWindowController(view, model );

		auctionTabModule = new AuctionTabModule();
		channelTabModule = new ChannelTabModule();
		clientsTabModule = new ClientsTabModule();
		databaseTabModule = new DatabaseTabModule();
		deviceTabModule = new DeviceTabModule();
		leasesTabModule = new LeasesTabModule();
		serverTabModule = new ServerTabModule();
		consoleTabModule = new ConsoleTabModule();

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

	@Override
	public void display() {
		view.show();
	}
}
