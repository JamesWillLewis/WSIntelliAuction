package wsintelliauction.global;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class EventLogger {

	private static PrintWriter logOut;
	private static final String LOG_DIR = "logs//";
	private static final String EVENT_LOG_FILE = "event.log";

	static {
		try {
			File logsDir = new File(LOG_DIR);
			if(!logsDir.exists()){
				logsDir.mkdir();
			}		
			File logFile = new File(logsDir.getPath() + "//" + EVENT_LOG_FILE);
			logOut = new PrintWriter(new FileWriter(logFile, true), true);
		} catch (IOException e) {
			ErrorLogger.log(e.getMessage());
		}
	}

	/**
	 * Submits an event, writing it to the standard IO
	 * as well as recording the event in the event log, with a timestamp.
	 * 
	 * Synchronized to ensure atomicity.
	 * 
	 * @param message
	 */
	public static void log(String message) {
		System.out.println(">>	" + message.toUpperCase());
		logOut.println(Calendar.getInstance().getTime().toString() + " : "
				+ message);
	}
}
