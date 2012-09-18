package wsintelliauction.server.backend;

import wsintelliauction.server.backend.net.ServerNetworkManager;
import wsintelliauction.server.frontend.ServerWindowManager;
import wsintelliauction.task.TaskManager;
import wsintelliauction.util.AbstractDriver;
import wsintelliauction.util.ThreadManager;

public class Driver extends AbstractDriver {

	/**
	 * Window manager for server-side administrator GUI.
	 */
	private ServerWindowManager windowManager;
	/**
	 * Server network manager.
	 */
	private ServerNetworkManager networkManager;
	/**
	 * Task scheduler for this application.
	 */
	private TaskManager taskManager;

	public static final int BACKLOG_CAPACITY = 512;
	
	public Driver(String[] args) {
		super(args);
	}

	@Override
	public void init() {
		//init the managers
		taskManager = new TaskManager(BACKLOG_CAPACITY);
		windowManager = new ServerWindowManager(taskManager);
		networkManager = new ServerNetworkManager();
	}

	@Override
	public void exec() {
		taskManager.beginServiceRoutine();
		windowManager.launchMainWindow();
	}

	@Override
	public void end() {
		taskManager.endServiceRoutine();
		ThreadManager.closeThreads();
	}

}
