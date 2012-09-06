package wsintelliauction.gui;

import wsintelliauction.server.engine.TaskBacklog;

public abstract class WindowHandle<E extends WindowData<?>> {

	protected E dataRef;
	protected TaskBacklog backlog;

	public WindowHandle(TaskBacklog backlog) {
		this.backlog = backlog;
	}

	public void attachData(E dataRef) {
		this.dataRef = dataRef;
	}

}
