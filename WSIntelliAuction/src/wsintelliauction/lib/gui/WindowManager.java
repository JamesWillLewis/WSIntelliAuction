package wsintelliauction.lib.gui;

import java.util.ArrayList;

import wsintelliauction.lib.task.TaskBacklog;
import wsintelliauction.lib.task.TaskManager;

public abstract class WindowManager {

	protected ArrayList<Window<?,?,?>> activeWindows;
	
	protected TaskManager backlog;

	public WindowManager(int NUM_WINDOWS, TaskManager backlog) {
		activeWindows = new ArrayList<Window<?,?,?>>(NUM_WINDOWS);
		this.backlog = backlog;
	}
	
	public abstract WindowData<?> launchNewWindow(int id);

}
