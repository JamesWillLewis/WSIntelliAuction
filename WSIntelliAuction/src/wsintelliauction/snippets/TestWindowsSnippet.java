package wsintelliauction.snippets;

import wsintelliauction.server.frontend.ServerWindowManager;
import wsintelliauction.server.frontend.windows.mainwindow.MainWindowFrame;

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
		ServerWindowManager uiManager = new ServerWindowManager();
		//launch server-side primary window
		uiManager.openWindow(ServerWindowManager.WINDOW_PRIMARY);
		
		
		
	}
	
}
