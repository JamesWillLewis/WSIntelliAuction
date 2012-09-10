package wsintelliauction.gui;

import wsintelliauction.task.TaskScheduler;

/**
 * Window handle super class. Each window is paired with a window handle, which
 * the window uses for handling of all window events (such as button pressed
 * events, input data change event, button selected events, scroll events, etc)
 * and then submits an associated task to the task manager for further handling.
 * 
 * @author James Lewis
 * 
 */
public abstract class WindowHandle {

	/**
	 * Reference to the containing window.
	 */
	protected Window<?,?,?> windowRef;
	/**
	 * Reference to the applications global task manager.
	 */
	protected TaskScheduler taskManager;

	/**
	 * Constructs a new window handle.
	 * 
	 * @param taskManager Task manager reference.
	 */
	public WindowHandle(TaskScheduler taskManager) {
		this.taskManager = taskManager;
	}

	/**
	 * Sets window reference.
	 * @param windowRef Window reference.
	 */
	public void setWindowRef(Window<?,?,?> windowRef) {
		this.windowRef = windowRef;
	}
	

}
