package com.uct.cs.wsintelliauction.server.frontend.modules;

import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.server.frontend.controls.MainWindowController;
import com.uct.cs.wsintelliauction.server.frontend.models.MainWindowModel;
import com.uct.cs.wsintelliauction.server.frontend.views.MainWindowView;
import com.uct.cs.wsintelliauction.window.Module;
import com.uct.cs.wsintelliauction.window.modules.ConsoleTabModule;

public class MainWindowModule extends
		Module<MainWindowModel, MainWindowView, MainWindowController> {

	private AuctionTabModule auctionTabModule;
	private ClientsTabModule clientsTabModule;
	private ServerTabModule serverTabModule;
	private ConsoleTabModule consoleTabModule;

	public MainWindowModule(ServerResourceContainer resourceManager) {
		super(resourceManager);
		model = new MainWindowModel(resourceManager);
		view = new MainWindowView(model);
		controller = new MainWindowController(view, model);

		auctionTabModule = new AuctionTabModule(resourceManager, controller);
		clientsTabModule = new ClientsTabModule(resourceManager);
		serverTabModule = new ServerTabModule(resourceManager);
		consoleTabModule = new ConsoleTabModule(resourceManager);

		initTabs();
	}

	private void initTabs() {
		view.addTab(auctionTabModule.getView());
		view.addTab(clientsTabModule.getView());
		view.addTab(serverTabModule.getView());
		view.addTab(consoleTabModule.getView());
	}

	public AuctionTabModule getAuctionTabModule() {
		return auctionTabModule;
	}

	public void setAuctionTabModule(AuctionTabModule auctionTabModule) {
		this.auctionTabModule = auctionTabModule;
	}

	public ClientsTabModule getClientsTabModule() {
		return clientsTabModule;
	}

	public void setClientsTabModule(ClientsTabModule clientsTabModule) {
		this.clientsTabModule = clientsTabModule;
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
