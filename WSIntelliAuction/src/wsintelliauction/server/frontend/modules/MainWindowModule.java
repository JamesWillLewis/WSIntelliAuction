package wsintelliauction.server.frontend.modules;

import java.awt.EventQueue;

import wsintelliauction.gui.Module;
import wsintelliauction.gui.modules.ConsoleTabModule;
import wsintelliauction.server.frontend.controls.MainWindowController;
import wsintelliauction.server.frontend.models.MainWindowModel;
import wsintelliauction.server.frontend.views.MainWindowView;
import wsintelliauction.task.TaskManager;

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

	public MainWindowModule(TaskManager taskManager) {
		model = new MainWindowModel();
		view = new MainWindowView(model);
		controller = new MainWindowController(view, model, taskManager);

		auctionTabModule = new AuctionTabModule(taskManager);
		channelTabModule = new ChannelTabModule(taskManager);
		clientsTabModule = new ClientsTabModule(taskManager);
		databaseTabModule = new DatabaseTabModule(taskManager);
		deviceTabModule = new DeviceTabModule(taskManager);
		leasesTabModule = new LeasesTabModule(taskManager);
		serverTabModule = new ServerTabModule(taskManager);
		consoleTabModule = new ConsoleTabModule(taskManager);

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
