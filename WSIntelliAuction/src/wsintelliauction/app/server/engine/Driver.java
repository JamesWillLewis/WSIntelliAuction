package wsintelliauction.app.server.engine;

import wsintelliauction.app.server.control.ServerWindowManager;
import wsintelliauction.lib.misc.AbstractDriver;
import wsintelliauction.lib.task.TaskScheduler;

public class Driver extends AbstractDriver {

	/**
	 * Window manager for server-side administrator GUI.
	 */
	private ServerWindowManager serverWindowManager;
	
	/**
	 * 
	 * @param args
	 */
	public static final int BACKLOG_CAPACITY = 64;
	
	public Driver(String[] args) {
		super(args, new TaskScheduler(BACKLOG_CAPACITY));
	}

	@Override
	public void init() {
		serverWindowManager = new ServerWindowManager(taskManager);
	}

	@Override
	public void exec() {
	
	}

}
