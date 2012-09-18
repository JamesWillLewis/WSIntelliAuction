package wsintelliauction.client.frontend;

import wsintelliauction.client.frontend.mvc.mainwindow.MainMVC;
import wsintelliauction.gui.WindowManager;
import wsintelliauction.task.TaskManager;

public class ClientWindowManager extends WindowManager {

	public static final int NUM_WINDOWS = 1;
	
	public ClientWindowManager(TaskManager taskmanager) {
		super(NUM_WINDOWS, taskmanager);
	}

	public void launchMainWindow() {
		appendAndLaunchWindow(new MainMVC(this.taskmanager));
	}


}
