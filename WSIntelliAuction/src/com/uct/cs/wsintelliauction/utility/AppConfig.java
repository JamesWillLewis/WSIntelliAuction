package com.uct.cs.wsintelliauction.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

/**
 * Wraps a Properties object, allowing global static access for setting and
 * getting properties, as well as defining the default properties file.
 * 
 * @author James Lewis
 * 
 */
public class AppConfig {

	private final static Properties properties;

	private final static File propertiesFile;

	public final static String PROPERTIES_FILE_NAME = "wsintelliauction.cfg.xml";

	static {
		propertiesFile = new File(PROPERTIES_FILE_NAME);
		properties = new Properties();
		if (propertiesFile.exists())
			load();
		else {
			JOptionPane
					.showMessageDialog(
							null,
							"Unable to locate wsintelliauction.cfg.xml configuration file.",
							"Fatal Error",
							JOptionPane.ERROR_MESSAGE);
			ErrorLogger.log("Unable to locate wsintelliauction.cfg.xml configuration file");
			System.exit(1);
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static void setProperty(String key, String value) {
		properties.setProperty(key, value);
		store();
	}

	public static void load() {
		try {
			properties.loadFromXML(new FileInputStream(propertiesFile));
		} catch (FileNotFoundException e) {
			ErrorLogger.log("Error loading properties file");
		} catch (IOException e) {
			ErrorLogger.log("Error loading properties file");
		}
	}

	public static void store() {
		try {
			properties.storeToXML(new FileOutputStream(propertiesFile),
					"Configuration Properties");
		} catch (IOException e) {
			ErrorLogger.log("Error writing properties file");
		}
	}

}
