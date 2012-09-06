package wsintelliauction.lib.task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import wsintelliauction.lib.misc.ErrorLogger;

public class TaskBacklog {

	private BlockingQueue<Task> backLog;
	public final int BACKLOG_CAPACITY;
	
	public TaskBacklog(final int BACKLOG_CAPACITY) {
		this.BACKLOG_CAPACITY = BACKLOG_CAPACITY;
		backLog = new ArrayBlockingQueue<Task>(BACKLOG_CAPACITY, true);
	}
	
	public void enqueue(Task task){
		try {
			backLog.put(task);
		} catch (InterruptedException e) {
			ErrorLogger.log("Unable to submit task: " + task.toString());
		}
	}
	
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
