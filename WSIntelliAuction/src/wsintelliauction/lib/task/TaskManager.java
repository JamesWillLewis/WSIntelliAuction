package wsintelliauction.lib.task;

/**
 * Super class for all application task managers. Used in conjunction with a
 * taskbacklog implementation as well as derived tasks, for handling task
 * requests from various input stimuli.
 * 
 * @author James
 * 
 */
public abstract class TaskManager {

	/**
	 * Array of task backlogs. Multiple task backlogs exist so priority can be
	 * assigned - different backlogs can have different priority, capacity,
	 * execute in different threads, be handled in different ways, etc.
	 */
	protected TaskBacklog[] backlog;

	/**
	 * If task manager active - servicing the task backlog.
	 */
	public boolean isActive;

	/**
	 * Submit a task to the taskbacklog for servicing.
	 * 
	 * @param t
	 *            Task to be executed.
	 */
	public abstract void submitTask(Task t);

	/**
	 * Begin servicing the task backlog.
	 */
	public abstract void beginServiceRoutine();

	/**
	 * End the task servicing routine. Unprocessed tasks will be processed
	 * first, but no new tasks will be allowed.
	 */
	public abstract void endServiceRoutine();

	/**
	 * Immediatly end the task servicing routine. Unprocessed tasks will NOT be
	 * executed.
	 */
	public abstract void killServiceRoutine();

}
