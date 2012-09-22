package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.gui.Module;
import com.uct.cs.wsintelliauction.gui.modules.ConsoleTabModule;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceManager;
import com.uct.cs.wsintelliauction.server.frontend.controls.MainWindowController;
import com.uct.cs.wsintelliauction.server.frontend.models.MainWindowModel;
import com.uct.cs.wsintelliauction.server.frontend.views.MainWindowView;
import com.uct.cs.wsintelliauction.util.ResourceManager;


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

	public MainWindowModule(ServerResourceManager resourceManager) {
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

	@Override
	public void display() {
		view.show();
	}
}
