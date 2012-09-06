package wsintelliauction.app.server.control.windows.mainwindow;

import wsintelliauction.app.server.engine.TaskBacklog;
import wsintelliauction.lib.gui.Window;

public class MainWindow extends
		Window<MainWindowFrame, MainWindowData, MainWindowHandle> {

	public MainWindow(TaskBacklog backlog) {
		super(new MainWindowFrame(), new MainWindowData(),
				new MainWindowHandle(backlog));
	}

}
