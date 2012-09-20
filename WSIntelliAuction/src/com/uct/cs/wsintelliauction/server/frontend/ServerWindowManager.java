package com.uct.cs.wsintelliauction.server.frontend;

import com.uct.cs.wsintelliauction.gui.WindowManager;
import com.uct.cs.wsintelliauction.server.frontend.modules.MainWindowModule;

/**
 * Implementation of 
 * 
 * @author James Lewis
 *
 */
public class ServerWindowManager extends WindowManager {

	public static final int NUM_WINDOWS = 1;
	
	public MainWindowModule mainWindowModule;

	/**
	 * Construct new window manager.
	 * @param taskmanager Task manager.
	 */
	public ServerWindowManager() {
		mainWindowModule = new MainWindowModule();
	}
	
	/**
	 * Launch a new main window instance.
	 */
	public void launchMainWindow(){
		mainWindowModule.display();
	}

}
