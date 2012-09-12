package wsintelliauction.server.control;

import wsintelliauction.gui.WindowManager;
import wsintelliauction.server.control.windows.mainwindow.MainWindow;
import wsintelliauction.task.TaskScheduler;

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
	public ServerWindowManager(TaskScheduler taskmanager) {
		super(NUM_WINDOWS, taskmanager); 
	}
	


}
