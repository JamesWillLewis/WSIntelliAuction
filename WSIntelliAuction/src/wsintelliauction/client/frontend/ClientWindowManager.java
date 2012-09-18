package wsintelliauction.client.frontend;

import wsintelliauction.client.frontend.modules.MainWindowModule;
import wsintelliauction.gui.WindowManager;
import wsintelliauction.task.TaskManager;

public class ClientWindowManager extends WindowManager {

	public static final int NUM_WINDOWS = 1;

	public MainWindowModule mainWindowModule;

	/**
	 * Construct new window manager.
	 * 
	 * @param taskmanager
	 *            Task manager.
	 */
	public ClientWindowManager(TaskManager taskmanager) {
		this.taskmanager = taskmanager;
		mainWindowModule = new MainWindowModule(taskmanager);
	}

	/**
	 * Launch a new main window instance.
	 */
	public void launchMainWindow() {
		mainWindowModule.display();
	}

}
