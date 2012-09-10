package wsintelliauction.app.server.control.windows.mainwindow;

import wsintelliauction.lib.gui.Window;
import wsintelliauction.lib.task.TaskScheduler;

public class MainWindow extends
		Window<MainWindowFrame, MainWindowData, MainWindowHandle> {
	
	public MainWindow(TaskScheduler taskmanager) {
		super(new MainWindowFrame(), new MainWindowData(),
				new MainWindowHandle(taskmanager));
	}

}
