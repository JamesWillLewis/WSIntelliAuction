package wsintelliauction.lib.task;


/**
 * Super class for all application task managers.
 * Used in conjunction with a taskbacklog implementation
 * as well as derived tasks, for handling task requests from
 * various input stimuli.
 * 
 * @author James
 *
 */
public abstract class TaskManager {
	
	/**
	 * Array of task backlogs.
	 * Multiple task backlogs exist so priority
	 * can be assigned - different backlogs can have different priority,
	 * capacity, execute in different threads, be handled in different ways, etc.
	 */
	protected TaskBacklog[] backlog;
	
	public boolean ACTIVE;
	
	public abstract void submitTask(Task t);
	
	public abstract void beginServiceRoutine();
	
	public abstract void endServiceRoutine();

}
