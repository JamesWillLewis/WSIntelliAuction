package wsintelliauction.app.server.control;

import wsintelliauction.app.server.control.windows.mainwindow.MainWindow;
import wsintelliauction.app.server.engine.TaskBacklog;
import wsintelliauction.lib.gui.Window;
import wsintelliauction.lib.gui.WindowData;
import wsintelliauction.lib.gui.WindowManager;
import wsintelliauction.lib.misc.ErrorLogger;

public class ServerWindowManager extends WindowManager {

	public static final int NUM_WINDOWS = 1;
	/**
	 * List of all window array indices
	 */
	public static final int WINDOW_MAIN = 0;

	public ServerWindowManager(TaskBacklog backlog) {
		super(NUM_WINDOWS, backlog); 
	}

	@Override
	public WindowData<?> launchNewWindow(int id) {
		Window<?, ?, ?> newWindow = null;
		switch (id) {
		case WINDOW_MAIN:
			newWindow = new MainWindow(backlog);
			break;
		default:
			ErrorLogger.log("Invalid window launch.");
		}
		activeWindows.add(newWindow);
		return newWindow.getData();
	}

}
