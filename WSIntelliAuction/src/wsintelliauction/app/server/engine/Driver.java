package wsintelliauction.app.server.engine;

import wsintelliauction.app.server.engine.task.ServerTaskManager;
import wsintelliauction.lib.misc.AbstractDriver;

public class Driver extends AbstractDriver<ServerTaskManager> {

	public Driver(String[] args) {
		super(args, new ServerTaskManager());
	}

	@Override
	public void init() {
	}

	@Override
	public void exec() {

	}

}
