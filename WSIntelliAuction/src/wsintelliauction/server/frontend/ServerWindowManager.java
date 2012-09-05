package wsintelliauction.server.frontend;

import wsintelliauction.server.frontend.windows.mainwindow.MainWindow;
import wsintelliauction.windowing.WindowData;
import wsintelliauction.windowing.WindowManager;

public class ServerWindowManager extends WindowManager {
	
	public static final int NUM_WINDOWS = 1;
	/**
	 * List of all window array indices
	 */
	public static final int WINDOW_PRIMARY = 0;

	public ServerWindowManager() {
		super(NUM_WINDOWS);
		initAllWindows();
	}
	
	/**
	 * Initialize all the windows in the "windows" package
	 */
	private void initAllWindows(){
		windows[WINDOW_PRIMARY] = new MainWindow();
	}
	
	public void openWindow(int index)
	{
		windows[index].getFrame().launch();
	}
	
	public void closeWindow(int index){
		windows[index].getFrame().launch();
	}
	
	public WindowData getWindowDataStructure(int index){
		if(windows[index] != null){
			return windows[index].getData();
		}
		else
			return null;
	}
}
