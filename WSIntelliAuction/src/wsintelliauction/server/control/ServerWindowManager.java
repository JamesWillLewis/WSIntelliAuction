package wsintelliauction.server.control;

import wsintelliauction.gui.WindowManager;
import wsintelliauction.server.control.windows.mainwindow.MainWindow;
import wsintelliauction.task.TaskManager;

/**
 * Implementation of 
 * 
 * @author James Lewis
 *
 */
public class ServerWindowManager extends WindowManager {

	public static final int NUM_WINDOWS = 1;

	/**
	 * Construct new window manager.
	 * @param taskmanager Task manager.
	 */
	public ServerWindowManager(TaskManager taskmanager) {
		super(NUM_WINDOWS, taskmanager); 
	}
	
	public void launchMainWindow(){
		appendAndLaunchWindow(new MainWindow(this.taskmanager));
	}

}
