package wsintelliauction.lib.task;

import wsintelliauction.lib.misc.EventLogger;

/**
 * Abstract super-class for all tasks. A task represents 
 * a unit of work, which the particular application must handle.
 * This class is derived into many subclasses, where each subclass
 * defines what exactly the particular task must do.
 * A task backlog stores all tasks still to be executed, and the task
 * manager handles execution of tasks. Derived subclasses will
 * aggregate all references which might be required for this task
 * to be realized. The taskmanager services each task, calling the
 * <code>perform()</code> function.
 * 
 * @author James Lewis
 *
 */
public abstract class Task {
	
	/**
	 * Textual description of the task.
	 */
	protected final String DESCRIPTOR;
	
	/**
	 * Super constructor.
	 * 
	 * @param DESCRIPTOR Task descriptor to set.
	 */
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
	
	/**
	 * Perform all work which this task describes.
	 * 
	 * @return True if task completed succesfully.
	 */
	public abstract boolean perform();

	@Override
	public String toString() {
		return DESCRIPTOR;
	}
}
