package wsintelliauction.server.frontend;

import wsintelliauction.gui.WindowManager;
import wsintelliauction.server.frontend.modules.MainWindowModule;
import wsintelliauction.task.TaskManager;

/**
 * Implementation of 
 * 
 * @author James Lewis
 *
 */
public class ServerWindowManager extends WindowManager {

	public static final int NUM_WINDOWS = 1;
	
	public MainWindowModule mainWindowModule;

	/**
	 * Construct new window manager.
	 * @param taskmanager Task manager.
	 */
	public ServerWindowManager(TaskManager taskmanager) {
		this.taskmanager = taskmanager;
		mainWindowModule = new MainWindowModule(taskmanager);
	}
	
	/**
	 * Launch a new main window instance.
	 */
	public void launchMainWindow(){
		mainWindowModule.display();
	}

}
