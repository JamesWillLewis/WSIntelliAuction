package wsintelliauction.app.server.control;

import wsintelliauction.app.server.control.windows.mainwindow.MainWindow;
import wsintelliauction.lib.gui.WindowManager;
import wsintelliauction.lib.task.TaskScheduler;

/**
 * Implementation of 
 * 
 * @author James Lewis
 *
 */
public class ServerWindowManager extends WindowManager {

	public static final int NUM_WINDOWS = 1;
	/**
	 * List of all window array indices
	 */
	public static final int WINDOW_MAIN = 0;

	/**
	 * Construct new window manager.
	 * @param taskmanager Task manager.
	 */
	public ServerWindowManager(TaskScheduler taskmanager) {
		super(NUM_WINDOWS, taskmanager); 
	}
	
	/**
	 * Launch a new main window.
	 */
	public void launchMainWindow(){
		appendAndLaunchWindow(new MainWindow(taskmanager));
	}


}
