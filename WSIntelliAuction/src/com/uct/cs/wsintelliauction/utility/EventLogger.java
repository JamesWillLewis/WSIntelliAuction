package com.uct.cs.wsintelliauction.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import com.uct.cs.wsintelliauction.window.modules.ConsoleTabController;

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

	private static ConsoleTabController consoleTabController;

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
		System.out.println(Calendar.getInstance().getTime().toString() + " : "
				+ message);
		if (consoleTabController != null) {
			consoleTabController.appendMessageToEventConsole(Calendar
					.getInstance().getTime().toString()
					+ " : " + message);
		}
		if (logOut != null)
			logOut.println(Calendar.getInstance().getTime().toString() + " : "
					+ message);

	}

	public static void setConsoleTabController(
			ConsoleTabController consoleTabController) {
		EventLogger.consoleTabController = consoleTabController;
	}

	public static String loadLogFile() {
		File logFile = new File(LOG_DIR + EVENT_LOG_FILE);
		String log = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(logFile));
			String line = "";
			while ((line = br.readLine()) != null) {
				log += line + '\n';
			}
			br.close();
		} catch (FileNotFoundException e) {
			ErrorLogger.log(e.getMessage());
		} catch (IOException e) {
			ErrorLogger.log(e.getMessage());
		}
		return log;
	}

}
