package com.uct.cs.wsintelliauction.server.frontend;



import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.server.frontend.modules.MainWindowModule;
import com.uct.cs.wsintelliauction.utility.ResourceContainer;
import com.uct.cs.wsintelliauction.window.WindowDriver;

/**
 * Implementation of 
 * 
 * @author James Lewis
 *
 */
public class ServerWindowDriver extends WindowDriver {

	
	public MainWindowModule mainWindowModule;

	/**
	 * Construct new window manager.
	 * @param taskmanager Task manager.
	 */
	public ServerWindowDriver(ServerResourceContainer resourceManager) {
		super(resourceManager);
		mainWindowModule = new MainWindowModule(resourceManager);
	}
	
	/**
	 * Launch a new main window instance.
	 */
	public void launchMainWindow(){
		mainWindowModule.display();
	}
	
	public MainWindowModule getMainWindowModule() {
		return mainWindowModule;
	}

}
