package com.uct.cs.wsintelliauction.client.frontend;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceContainer;
import com.uct.cs.wsintelliauction.client.frontend.modules.MainWindowModule;
import com.uct.cs.wsintelliauction.window.WindowDriver;

public class ClientWindowDriver extends WindowDriver {


	public MainWindowModule mainWindowModule;

	/**
	 * Construct new window manager.
	 * 
	 * @param taskmanager
	 *            Task manager.
	 */
	public ClientWindowDriver(ClientResourceContainer resourceManager) {
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
