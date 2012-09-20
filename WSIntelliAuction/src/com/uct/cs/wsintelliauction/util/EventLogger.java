package com.uct.cs.wsintelliauction.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 * Global class for logging events.
 * 
 * @author James Lewis
 * 
 */
public class EventLogger {

	/**
	 * Log file output stream.
	 */
	private static PrintWriter logOut;
	/**
	 * Log file directory.
	 */
	private static final String LOG_DIR = "logs//";
	/**
	 * Name of log file.
	 */
	private static final String EVENT_LOG_FILE = "event.log";

	/**
	 * Static constructor. Initializes the logger.
	 */
	static {
		try {
			File logsDir = new File(LOG_DIR);
			if (!logsDir.exists()) {
				logsDir.mkdir();
			}
			File logFile = new File(logsDir.getPath() + "//" + EVENT_LOG_FILE);
			logOut = new PrintWriter(new FileWriter(logFile, true), true);
		} catch (IOException e) {
			ErrorLogger.log(e.getMessage());
		}
	}

	/**
	 * Submits an event, writing it to the standard IO as well as recording the
	 * event in the event log, with a timestamp.
	 * 
	 * @param message
	 *            Message to log.
	 */
	public static void log(String message) {
		System.out.println(">>	" + message);
		logOut.println(Calendar.getInstance().getTime().toString() + " : "
				+ message);
	}
}
