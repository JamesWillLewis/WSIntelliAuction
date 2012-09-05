package com.uct.cs.wsintelliauction.global;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

public class ErrorLogger {

	private static PrintWriter logOut;
	private static final String LOG_DIR = "logs//";
	private static final String ERROR_LOG_FILE = "error.log";

	static {
		try {
			File logsDir = new File(LOG_DIR);
			if(!logsDir.exists()){
				logsDir.mkdir();
			}		
			File logFile = new File(logsDir.getPath() + "//" + ERROR_LOG_FILE);
			logOut = new PrintWriter(new FileWriter(logFile, true), true);
		} catch (IOException e) {
			System.err.println("Error: Unable to open " + ERROR_LOG_FILE);
		}
	}

	/**
	 * Submits an error, writing it to the standard error IO
	 * as well as recording the error in the error log, with a timestamp.
	 * 
	 * Synchronized to ensure atomicity.
	 * 
	 * @param message
	 */
	public static void submitError(String message) {
		System.err.println("RUNTIME ERROR:	" + message.toUpperCase());
		logOut.println(Calendar.getInstance().getTime().toString() + " : "
				+ message);
	}
}
