package wsintelliauction.gui.task;

import wsintelliauction.gui.Window;
import wsintelliauction.gui.WindowManager;
import wsintelliauction.task.Task;

public class LaunchWindowTask extends Task {
	
	private Window<?,?,?> windowToLaunch;
	private static WindowManager windowManager;

	public LaunchWindowTask(Window<?,?,?> windowToLaunch) {
		super("Launch new window. Type="+windowToLaunch.toString());
		this.windowToLaunch = windowToLaunch;
	}
	
	public static void setWindowManager(WindowManager windowManager) {
		LaunchWindowTask.windowManager = windowManager;
	}
	

	@Override
	public boolean perform() {
		if(windowManager != null){
			windowManager.appendAndLaunchWindow(windowToLaunch);
			return true;
		} else{
			return false;
		}
	}

}
