package wsintelliauction.server.control.windows.mainwindow;

import wsintelliauction.gui.Window;
import wsintelliauction.task.TaskManager;

public class MainWindow extends
		Window<MainWindowFrame, MainWindowData, MainWindowHandle> {
	
	public MainWindow(TaskManager taskmanager) {
		super(new MainWindowFrame(), new MainWindowData(),
				new MainWindowHandle(taskmanager));
	}
	
	@Override
	public String toString() {
		return "Main";
	}

}
