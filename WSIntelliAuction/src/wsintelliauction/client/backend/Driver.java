package wsintelliauction.client.backend;

import wsintelliauction.client.frontend.ClientNetworkManager;
import wsintelliauction.client.frontend.ClientWindowManager;
import wsintelliauction.misc.AbstractDriver;
import wsintelliauction.misc.ThreadManager;
import wsintelliauction.task.TaskManager;

public class Driver extends AbstractDriver {

	/**
	 * Window manager for server-side administrator GUI.
	 */
	private ClientWindowManager windowManager;
	/**
	 * Server network manager.
	 */
	private ClientNetworkManager networkManager;
	/**
	 * Task scheduler for this application.
	 */
	private TaskManager taskManager;
	
	public static final int BACKLOG_CAPACITY = 128;

	public Driver(String[] args) {
		super(args);
	}

	@Override
	public void exec() {
		taskManager.beginServiceRoutine();
		windowManager.launchMainWindow();

	}

	@Override
	protected void init() {
		taskManager = new TaskManager(BACKLOG_CAPACITY);
		windowManager = new ClientWindowManager(taskManager);
		networkManager = new ClientNetworkManager();
	}

	@Override
	public void end() {
		taskManager.endServiceRoutine();
		ThreadManager.closeThreads();
	}

}