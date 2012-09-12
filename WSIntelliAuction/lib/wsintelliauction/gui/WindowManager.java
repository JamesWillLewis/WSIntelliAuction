package wsintelliauction.gui;

import java.util.ArrayList;

import wsintelliauction.misc.ErrorLogger;
import wsintelliauction.misc.EventLogger;
import wsintelliauction.task.TaskScheduler;

/**
 * 
 * Window management super class. Maintains a list of active windows which
 * compose the graphical user interface, as well as various functions for
 * initialisation, control and communication. The window manager is responsible
 * for all creation and management of windows. Each application must derive its
 * own window manager if it utilises a GUI.
 * 
 * @author James Lewis
 * 
 */
public abstract class WindowManager {

	/**
	 * List of active windows.
	 */
	protected ArrayList<Window<?, ?, ?>> activeWindows;

	/**
	 * Reference to task backlog (for parsing control to windows)
	 */
	protected TaskScheduler taskmanager;

	/**
	 * Construct the window manager and initialise window list.
	 * 
	 * @param NUM_WINDOWS
	 *            'Assumed' amount of active windows.
	 * @param backlog
	 *            Reference to task backlog.
	 */
	public WindowManager(int NUM_WINDOWS, TaskScheduler taskmanager) {
		activeWindows = new ArrayList<Window<?, ?, ?>>(NUM_WINDOWS);
		this.taskmanager = taskmanager;
	}

	/**
	 * Appends the given window to the active window list and launches the
	 * window.
	 * 
	 * @param w
	 *            New window to launch.
	 */
	public void appendAndLaunchWindow(Window<?, ?, ?> w) {
		if (w != null) {
			activeWindows.add(w);
			w.launchWindow();
			EventLogger.log("New window launched: " + w.getClass());
		} else{
			ErrorLogger.log("Cannot load NULL window");
		}
		
	}

	/**
	 * Closes the specified window and removes it from the active window list.
	 * 
	 * @param w
	 *            Window to close.
	 */
	public void closeAndRemoveWindow(Window<?, ?, ?> w) {
		w.closeWindow();
		if (activeWindows.contains(w))
			activeWindows.remove(w);
		else
			ErrorLogger.log("Window manager does not contain window: "
					+ w.getClass());
		EventLogger.log("Window closed: " + w.getClass());
	}

}
