package wsintelliauction.misc;

import wsintelliauction.task.TaskScheduler;

/**
 * Driver superclass. All executable applications in the system must derive an
 * implementation of this class. The driver is the entry point for any
 * application, and is instantiated via the Main method/Main class of an
 * application.
 * 
 * @author James Lewis
 * 
 * @param <TM>
 *            {@link TaskScheduler} type.
 */
public abstract class AbstractDriver {

	/**
	 * Parameter parser used for this driver.
	 */
	protected RuntimeParamParser paramParser;

	/**
	 * 
	 */
	public final boolean DEBUG;

	/**
	 * Construct new driver.
	 * 
	 * @param args
	 *            Raw arguments.
	 * @param taskManager
	 *            Task manager to handle tasks.
	 */
	public AbstractDriver(String[] args) {
		this.paramParser = new RuntimeParamParser(args);
		this.DEBUG = paramParser.getParam(RuntimeParamParser.DEBUG_OPTION).flagged;
		init();
	}

	/**
	 * Initiate the driver. Always called by the super constructor, to ensure
	 * program can't be executed before initiation has occurred.
	 */
	protected abstract void init();

	/**
	 * Begin program execution. Always called after the driver has been
	 * initiated, usually from the application point of entry.
	 */
	public abstract void exec();

	/**
	 * Ends the program, shutting down various services and destroying
	 * resources, closing streams, etc. All post-execution operations are done
	 * here.
	 */
	public abstract void end();

}
