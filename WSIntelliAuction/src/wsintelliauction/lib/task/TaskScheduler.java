package wsintelliauction.lib.task;

/**
 * General task manager for all application task managers. Used in conjunction with a
 * task backlog implementation (or just the default super class) 
 * as well as derived tasks, for handling task requests from various input stimuli.
 * 
 * @author James Lewis
 * 
 */
public class TaskScheduler {

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
	 * Construct a new task scheduler with the specified capacity.
	 * TOTAL capacity will be (PRIORITY_TYPES X BACKLOG_CAPACITY),
	 * since each priority is assigned a backlog. 
	 * @param BACKLOG_CAPACITY
	 */
	public TaskScheduler(final int BACKLOG_CAPACITY) {
		backlog = new TaskBacklog[Task.PRIORITY_TYPES];
		for(TaskBacklog b: backlog){
			b = new TaskBacklog(BACKLOG_CAPACITY);
		}
	}
	

	/**
	 * Submit a task to the task backlog for servicing.
	 * 
	 * @param t
	 *            Task to be executed.
	 */
	public void submitTask(Task t){
		
	}

	/**
	 * Begin servicing the task backlog.
	 */
	public void beginServiceRoutine(){
		
	}

	/**
	 * End the task servicing routine. Unprocessed tasks will be processed
	 * first, but no new tasks will be allowed.
	 */
	public void endServiceRoutine(){
		
	}

	/**
	 * Immediately end the task servicing routine. Unprocessed tasks will NOT be
	 * executed.
	 */
	public void killServiceRoutine(){
		
	}

}
