package com.uct.cs.wsintelliauction.server.frontend;



import com.uct.cs.wsintelliauction.gui.WindowManager;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceManager;
import com.uct.cs.wsintelliauction.server.frontend.modules.MainWindowModule;
import com.uct.cs.wsintelliauction.util.ResourceManager;

/**
 * Implementation of 
 * 
 * @author James Lewis
 *
 */
public class ServerWindowManager extends WindowManager {

	
	public MainWindowModule mainWindowModule;

	/**
	 * Construct new window manager.
	 * @param taskmanager Task manager.
	 */
	public ServerWindowManager(ServerResourceManager resourceManager) {
		super(resourceManager);
		mainWindowModule = new MainWindowModule(resourceManager);
	}
	
	/**
	 * Launch a new main window instance.
	 */
	public void launchMainWindow(){
		mainWindowModule.display();
	}

}
