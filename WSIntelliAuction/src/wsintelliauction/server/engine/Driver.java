package wsintelliauction.server.engine;

import wsintelliauction.gui.task.LaunchWindowTask;
import wsintelliauction.misc.AbstractDriver;
import wsintelliauction.server.control.ServerNetworkManager;
import wsintelliauction.server.control.ServerWindowManager;
import wsintelliauction.server.control.windows.mainwindow.MainWindow;
import wsintelliauction.task.TaskScheduler;

public class Driver extends AbstractDriver {

	/**
	 * Window manager for server-side administrator GUI.
	 */
	private ServerWindowManager serverWindowManager;
	/**
	 * Server network manager.
	 */
	private ServerNetworkManager serverNetworkManager;
	/**
	 * Task scheduler for this application.
	 */
	private TaskScheduler taskScheduler;
	
	/**
	 * 
	 * @param args
	 */
	public static final int BACKLOG_CAPACITY = 64;
	
	public Driver(String[] args) {
		super(args);
	}

	@Override
	public void init() {
	
		//init the managers
		taskScheduler = new TaskScheduler(64);
		serverWindowManager = new ServerWindowManager(taskScheduler);
		serverNetworkManager = new ServerNetworkManager();
		
		
		//set task static references
		LaunchWindowTask.setWindowManager(serverWindowManager);
		
		//begin servicing
		taskScheduler.beginServiceRoutine();
	}

	@Override
	public void exec() {
		LaunchWindowTask launchMainWindow = new LaunchWindowTask(new MainWindow(taskScheduler));
		taskScheduler.submitTask(launchMainWindow);
	}

	@Override
	public void end() {
		taskScheduler.endServiceRoutine();
	}

}
