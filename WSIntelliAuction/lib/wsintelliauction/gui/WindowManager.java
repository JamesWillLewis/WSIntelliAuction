package wsintelliauction.gui;

import java.util.ArrayList;

import wsintelliauction.task.TaskManager;
import wsintelliauction.util.ErrorLogger;
import wsintelliauction.util.EventLogger;

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
	 * Reference to task backlog (for parsing control to windows)
	 */
	protected TaskManager taskmanager;

}
