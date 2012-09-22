package com.uct.cs.wsintelliauction.util;

/**
 * Driver superclass. All executable applications in the system must derive an
 * implementation of this class. The driver is the entry point for any
 * application, and is instantiated via the Main method/Main class of an
 * application.
 * 
 * @author James Lewis
 * 
 * @param <TM>
 *            {@link TaskManager} type.
 */
public abstract class AbstractDriver {

	protected String[] args;

	/**
	 * Construct new driver.
	 * 
	 * @param args
	 *            Raw arguments.
	 * @param taskManager
	 *            Task manager to handle tasks.
	 */
	public AbstractDriver(String[] args) {
		this.args = args;
	}

	/**
	 * Begin program execution. Always called after the driver has been
	 * initiated, usually from the application point of entry.
	 */
	public abstract void exec();


}
