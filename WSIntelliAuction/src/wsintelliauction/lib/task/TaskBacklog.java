package wsintelliauction.lib.task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import wsintelliauction.lib.misc.ErrorLogger;

/**
 * Wraps a synchronized blocking queue which holds tasks.
 * Handles synchronization, initialization, and put/get access functions.
 * 
 * @author James Lewis
 *
 */
public class TaskBacklog {

	/**
	 * Synchronous queue of backlog tasks.
	 */
	private BlockingQueue<Task> backLog;
	/**
	 * Maximum tasks that can be in the backlog.
	 */
	public final int BACKLOG_CAPACITY;
	
	/**
	 * Initialize task backlog.
	 * 
	 * @param BACKLOG_CAPACITY Maximum tasks that can be in the backlog.
	 */
	public TaskBacklog(final int BACKLOG_CAPACITY) {
		this.BACKLOG_CAPACITY = BACKLOG_CAPACITY;
		backLog = new ArrayBlockingQueue<Task>(BACKLOG_CAPACITY, true);
	}
	
	/**
	 * Append task to backlog, potentially blocking
	 * if queue is full (will wait for space to become available).
	 * 
	 * @param task Task to put in queue.
	 */
	public void enqueue(Task task){
		try {
			backLog.put(task);
		} catch (InterruptedException e) {
			ErrorLogger.log("Unable to submit task: " + task.toString());
		}
	}
	
	/**
	 * Pop task from backlog.
	 * If no tasks available, method blocks
	 * waiting for a task to become available.
	 * 
	 * @return Head of backlog.
	 */
	public Task dequeue(){
		Task next = null;
		try {
			next = backLog.take();
		} catch (InterruptedException e) {
			ErrorLogger.log("Task backlog interrupt while polling next task.");
			next = new NullTask();
		}
		return next;
	}
	
}
