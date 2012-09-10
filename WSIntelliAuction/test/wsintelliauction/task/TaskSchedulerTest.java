package wsintelliauction.task;

import org.junit.Test;

import wsintelliauction.misc.EventLogger;

public class TaskSchedulerTest {

	@Test
	public final void testBeginServiceRoutine() {
		TaskProcessor taskProcessor = new TaskProcessor() {
			
			@Override
			public void service(Task t) {
				EventLogger.log("[UNIT TEST: TaskScheduler] - TASK EXECUTED: " + t);
			}
		};
		TaskScheduler taskScheduler = new TaskScheduler(32, taskProcessor);
		
		//write some code here to generate lots of tasks and submit them
		
		//also generalize the loggers and create a TEST logger.
		
		
	}

}
