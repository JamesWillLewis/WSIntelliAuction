package wsintelliauction.server.frontend.windows.mainwindow;

import wsintelliauction.windowing.Window;

public class MainWindow extends Window {

	public MainWindow() {
		super(new MainWindowFrame(), new MainWindowData(), new MainWindowHandle());
	}

}
