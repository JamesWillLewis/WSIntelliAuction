package wsintelliauction.lib.gui;

import wsintelliauction.lib.task.TaskManager;

public abstract class WindowHandle<E extends WindowData<?>> {

	protected E dataRef;
	protected TaskManager backlog;

	public WindowHandle(TaskManager backlog) {
		this.backlog = backlog;
	}

	public void attachData(E dataRef) {
		this.dataRef = dataRef;
	}

}
