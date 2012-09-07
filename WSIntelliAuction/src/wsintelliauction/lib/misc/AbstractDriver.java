package wsintelliauction.lib.misc;

import wsintelliauction.lib.task.TaskManager;

/**
 * Driver superclass. All executable applications in the system
 * must derive an implementation of this class. The driver
 * is the entry point for any application, and is instantiated
 * via the Main method/Main class of an application. 
 * 
 * @author James Lewis
 *
 * @param <TM> {@link TaskManager} type.
 */
public abstract class AbstractDriver<TM extends TaskManager> {

	/**
	 * Parameter parser used for this driver.
	 */
	protected RuntimeParamParser paramParser;
	/**
	 * Task manager implementation used for this driver.
	 */
	protected TM taskManager;
	
	/**
	 * Construct new driver.
	 * 
	 * @param args Raw arguments.
	 * @param taskManager Task manager to handle tasks.
	 */
	public AbstractDriver(String[] args, TM taskManager) {
		this.paramParser = new RuntimeParamParser(args);
		this.taskManager = taskManager;
		init();
	}
	
	/**
	 * Initiate the driver.
	 * Always called by the super constructor,
	 * to ensure program can't be executed before initiation has occured.
	 */
	protected abstract void init();
	
	/**
	 * Begin program execution. Always called after the driver
	 * has been initiated, usually from the application point of entry.
	 */
	public abstract void exec();
	
}
