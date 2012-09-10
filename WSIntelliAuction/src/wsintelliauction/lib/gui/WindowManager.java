package wsintelliauction.lib.gui;

import java.util.ArrayList;

import wsintelliauction.lib.misc.ErrorLogger;
import wsintelliauction.lib.misc.EventLogger;
import wsintelliauction.lib.task.TaskScheduler;

/**
 * 
 * Window management super class. Maintains a list of active windows which
 * compose the graphical user interface, as well as various functions for initialisation,
 * control and communication. The window manager is responsible for all creation and management
 * of windows. Each application must derive its own window manager if it utilises a GUI.
 * 
 * @author James Lewis
 * 
 */
public abstract class WindowManager {

	/**
	 *	List of active windows.
	 */
	protected ArrayList<Window<?, ?, ?>> activeWindows;

	/**
	 * Reference to task backlog (for parsing control to windows)
	 */
	protected TaskScheduler taskmanager;

	/**
	 * Construct the window manager and initialise window list.
	 * 
	 * @param NUM_WINDOWS 'Assumed' amount of active windows.
	 * @param backlog Reference to task backlog.
	 */
	public WindowManager(int NUM_WINDOWS, TaskScheduler taskmanager) {
		activeWindows = new ArrayList<Window<?, ?, ?>>(NUM_WINDOWS);
		this.taskmanager = taskmanager;
	}
	
	/**
	 * Appends the given window to the active window list
	 * and launches the window.
	 * @param w New window to launch.
	 */
	protected void appendAndLaunchWindow(Window<?,?,?> w){
		activeWindows.add(w);
		w.launchWindow();
		EventLogger.log("New window launched: " + w.getClass());
	}
	
	/**
	 * Closes the specified window and removes it from the
	 * active window list.
	 * @param w Window to close.
	 */
	protected void closeAndRemoveWindow(Window<?,?,?> w){
		w.closeWindow();
		if(activeWindows.contains(w))
			activeWindows.remove(w);
		else
			ErrorLogger.log("Window manager does not contain window: "+ w.getClass());
		EventLogger.log("Window closed: " + w.getClass());
	}
	
	

}
