package wsintelliauction.lib.task;

import java.util.concurrent.atomic.AtomicBoolean;

import wsintelliauction.lib.misc.ErrorLogger;
import wsintelliauction.lib.misc.EventLogger;
import wsintelliauction.lib.misc.ThreadManager;

/**
 * General task manager for all application task managers. Used in conjunction
 * with a task backlog implementation (or just the default super class) as well
 * as derived tasks, for handling task requests from various input stimuli.
 * 
 * @author James Lewis
 * 
 */
public class TaskScheduler {

	/**
	 * Underlying task backlog queue.
	 */
	protected final TaskBacklog backlog;

	/**
	 * If task manager active - servicing the task backlog.
	 */
	private AtomicBoolean isServicing;
	/**
	 * If task manager active - servicing the task backlog.
	 */
	private AtomicBoolean isAccepting;

	protected final TaskProcessor taskProcessor;

	/**
	 * Construct a new task scheduler with the specified capacity.
	 * 
	 * @param BACKLOG_CAPACITY
	 */
	public TaskScheduler(final int BACKLOG_CAPACITY, TaskProcessor taskProcessor) {
		backlog = new TaskBacklog(BACKLOG_CAPACITY);
		isServicing = new AtomicBoolean(false);
		isAccepting = new AtomicBoolean(false);
		this.taskProcessor = taskProcessor;
	}

	/**
	 * Submit a task to the task backlog for servicing.
	 * 
	 * @param t
	 *            Task to be executed.
	 */
	public void submitTask(Task t) {
		EventLogger.log("New task submitted: " + t.toString());
		if (isAccepting.get())
			backlog.enqueue(t);
		else
			ErrorLogger.log("Task scheduler not active.");
	}

	/**
	 * Begin servicing the task backlog and accepting tasks. This routine relays
	 * to the serviceCycle routine in a separate thread.
	 */
	public void beginServiceRoutine() {
		EventLogger.log("Starting service routine...");
		if (!isServicing.get()) {
			Runnable serviceRunnable = new Runnable() {

				@Override
				public void run() {
					isAccepting.set(true);
					isServicing.set(true);
					serviceCycle();
				}
			};
			ThreadManager.assignThread(serviceRunnable);
		} else {
			ErrorLogger
					.log("Can't start a service routine which is already active.");
		}
	}

	/**
	 * Polls the backlog and executes task servicing within a loop, while the
	 * isServicing flag is true.
	 */
	protected void serviceCycle() {
		while (isServicing.get()) {
			if (backlog.getBacklogTasksLeft() < 1 && !isAccepting.get()) {
				isServicing.set(false);
			} else {
				Task toDo = backlog.dequeue();
				if (!(toDo instanceof NullTask))
					taskProcessor.service(toDo);
			}
		}
	}

	/**
	 * End the task servicing routine. Unprocessed tasks will be processed
	 * first, but no new tasks will be allowed.
	 */
	public void endServiceRoutine() {
		isAccepting.set(false);
	}

	/**
	 * Immediately end the task servicing routine. Unprocessed tasks will NOT be
	 * executed.
	 */
	public void killServiceRoutine() {
		isAccepting.set(false);
		isServicing.set(false);
	}

	/**
	 * Returns the accepting flag status.
	 * 
	 * @return True if accepting flag is high.
	 */
	public AtomicBoolean isAccepting() {
		return isAccepting;
	}

	/**
	 * Returns the service flag status.
	 * 
	 * @return True if servicing flag is high.
	 */
	public AtomicBoolean isServicing() {
		return isServicing;
	}

}
