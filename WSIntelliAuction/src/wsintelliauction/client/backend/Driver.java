package wsintelliauction.client.backend;

import wsintelliauction.client.frontend.ClientNetworkManager;
import wsintelliauction.client.frontend.ClientWindowManager;
import wsintelliauction.misc.AbstractDriver;
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
	
	public Driver(String[] args) {
		super(args);
		taskManager = new TaskManager(128);
		windowManager = new ClientWindowManager(taskManager);
		networkManager = new ClientNetworkManager();
	}

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}