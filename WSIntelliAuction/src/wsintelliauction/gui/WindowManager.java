package wsintelliauction.gui;

import java.util.ArrayList;

import wsintelliauction.server.engine.TaskBacklog;

public abstract class WindowManager {

	protected ArrayList<Window<?,?,?>> activeWindows;
	
	protected TaskBacklog backlog;

	public WindowManager(int NUM_WINDOWS, TaskBacklog backlog) {
		activeWindows = new ArrayList<Window<?,?,?>>(NUM_WINDOWS);
		this.backlog = backlog;
	}
	
	public abstract WindowData<?> launchNewWindow(int id);

}
