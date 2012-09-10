package wsintelliauction.server.engine;

import wsintelliauction.misc.AbstractDriver;
import wsintelliauction.server.control.ServerWindowManager;
import wsintelliauction.task.Task;
import wsintelliauction.task.TaskProcessor;
import wsintelliauction.task.TaskScheduler;

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
		super(args, new TaskScheduler(BACKLOG_CAPACITY, new TaskProcessor() {
			
			@Override
			public void service(Task t) {
				// TODO Auto-generated method stub
				
			}
		}));
	}

	@Override
	public void init() {
		serverWindowManager = new ServerWindowManager(taskManager);
	}

	@Override
	public void exec() {
	
	}

}
