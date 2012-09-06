package wsintelliauction.lib.task;

import wsintelliauction.lib.misc.EventLogger;

public abstract class Task {
	
	protected final String DESCRIPTOR;
	
	public Task(final String DESCRIPTOR) {
		this.DESCRIPTOR = DESCRIPTOR;
	}

	
	/**
	 * Execute this particular task,
	 * representing a finite unit of work.
	 * Usually involves work performed on various other
	 * objects referenced by a derived subclass.
	 * @return True if task completed succesfully.
	 */
	public boolean execute(){
		EventLogger.log("TASK EXECUTED:		" + toString());
		boolean status = perform();
		if(status)
			EventLogger.log("TASK COMPLETE:		" + toString());
		else
			EventLogger.log("TASK FAILED:		" + toString());
		return status;
	}
	
	public abstract boolean perform();

	@Override
	public String toString() {
		return DESCRIPTOR;
	}
}
