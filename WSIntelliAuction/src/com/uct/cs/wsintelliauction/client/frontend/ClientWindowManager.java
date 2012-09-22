package com.uct.cs.wsintelliauction.client.frontend;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceManager;
import com.uct.cs.wsintelliauction.client.frontend.modules.MainWindowModule;
import com.uct.cs.wsintelliauction.gui.WindowManager;

public class ClientWindowManager extends WindowManager {


	public MainWindowModule mainWindowModule;

	/**
	 * Construct new window manager.
	 * 
	 * @param taskmanager
	 *            Task manager.
	 */
	public ClientWindowManager(ClientResourceManager resourceManager) {
		super(resourceManager);
		mainWindowModule = new MainWindowModule(resourceManager);
	}


	/**
	 * Launch a new main window instance.
	 */
	public void launchMainWindow() {
		mainWindowModule.display();
	}
	
	public MainWindowModule getMainWindowModule() {
		return mainWindowModule;
	}

}
