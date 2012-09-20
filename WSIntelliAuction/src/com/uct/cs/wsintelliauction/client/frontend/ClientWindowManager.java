package com.uct.cs.wsintelliauction.client.frontend;

import com.uct.cs.wsintelliauction.client.frontend.modules.MainWindowModule;
import com.uct.cs.wsintelliauction.gui.WindowManager;

public class ClientWindowManager extends WindowManager {

	public static final int NUM_WINDOWS = 1;

	public MainWindowModule mainWindowModule;

	/**
	 * Construct new window manager.
	 * 
	 * @param taskmanager
	 *            Task manager.
	 */
	public ClientWindowManager() {
		mainWindowModule = new MainWindowModule();
	}

	/**
	 * Launch a new main window instance.
	 */
	public void launchMainWindow() {
		mainWindowModule.display();
	}

}
