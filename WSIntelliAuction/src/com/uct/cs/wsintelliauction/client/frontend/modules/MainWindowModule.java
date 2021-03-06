package com.uct.cs.wsintelliauction.client.frontend.modules;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceContainer;
import com.uct.cs.wsintelliauction.client.frontend.controls.MainWindowController;
import com.uct.cs.wsintelliauction.client.frontend.models.MainWindowModel;
import com.uct.cs.wsintelliauction.client.frontend.views.MainWindowView;
import com.uct.cs.wsintelliauction.window.Module;
import com.uct.cs.wsintelliauction.window.modules.ConsoleTabModule;

public class MainWindowModule extends
		Module<MainWindowModel, MainWindowView, MainWindowController> {

	private NetworkTabModule networkTabModule;
	private ConsoleTabModule consoleTabModule;
	private AuctionTabModule auctionTabModule;
	private LeasesTabModule leasesTabModule;

	public MainWindowModule(ClientResourceContainer resourceManager) {
		super(resourceManager);

		model = new MainWindowModel(resourceManager);
		view = new MainWindowView(model);
		controller = new MainWindowController(view, model);

		networkTabModule = new NetworkTabModule(resourceManager);
		consoleTabModule = new ConsoleTabModule(resourceManager);
		auctionTabModule = new AuctionTabModule(resourceManager);
		leasesTabModule = new LeasesTabModule(resourceManager);

		initTabs();
	}

	private void initTabs() {
		view.addTab(networkTabModule.getView());
		view.addTab(auctionTabModule.getView());
		view.addTab(leasesTabModule.getView());
		view.addTab(consoleTabModule.getView());
	}

	@Override
	public void display() {
		view.show();
	}

	public NetworkTabModule getNetworkTabModule() {
		return networkTabModule;
	}
	
	public AuctionTabModule getAuctionTabModule() {
		return auctionTabModule;
	}
	
	public LeasesTabModule getLeasesTabModule() {
		return leasesTabModule;
	}

}
