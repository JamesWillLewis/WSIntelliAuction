package wsintelliauction.app;

import wsintelliauction.app.server.control.ServerWindowManager;
import wsintelliauction.app.server.control.windows.mainwindow.MainWindowFrame;

/**
 * To test the various UI managers and their associated windows.
 * This class is used instead of unit tests, since unit tests
 * immediatly closes the window (kills the thread).
 * 
 * @author James
 * 
 */
public class TestWindowsSnippet {

	public static void main(String[] args){
		ServerWindowManager manager = new ServerWindowManager(null);
		manager.launchNewWindow(ServerWindowManager.WINDOW_MAIN);
		
		
	}
	
}
