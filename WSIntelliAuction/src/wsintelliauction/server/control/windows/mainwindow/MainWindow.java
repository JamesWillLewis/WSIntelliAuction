package wsintelliauction.server.control.windows.mainwindow;

import wsintelliauction.gui.Window;
import wsintelliauction.task.TaskScheduler;

public class MainWindow extends
		Window<MainWindowFrame, MainWindowData, MainWindowHandle> {
	
	public MainWindow(TaskScheduler taskmanager) {
		super(new MainWindowFrame(), new MainWindowData(),
				new MainWindowHandle(taskmanager));
	}

}
