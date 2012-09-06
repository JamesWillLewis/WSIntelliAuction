package wsintelliauction.gui;

import java.util.Hashtable;

public abstract class WindowManager {

	protected Window[] windows;

	public WindowManager(int NUM_WINDOWS) {
		windows = new Window[NUM_WINDOWS];
	}

}
