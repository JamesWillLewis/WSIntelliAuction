package wsintelliauction.server.control.windows.mainwindow;

import wsintelliauction.gui.Window;
import wsintelliauction.server.engine.TaskBacklog;

public class MainWindow extends
		Window<MainWindowFrame, MainWindowData, MainWindowHandle> {

	public MainWindow(TaskBacklog backlog) {
		super(new MainWindowFrame(), new MainWindowData(),
				new MainWindowHandle(backlog));
	}

}
