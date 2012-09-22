package com.uct.cs.wsintelliauction.util;

import com.uct.cs.wsintelliauction.gui.Splash;
import com.uct.cs.wsintelliauction.net.MessageParser;

/**
 * Centralized, globally accessible application resource container. Manages
 * access control to manager resources and serialized resources as well
 * as initialization and data persistence.
 * 
 * 
 * @author James Lewis
 */
public abstract class ResourceManager {

	/**
	 * Splash loader screen
	 */
	protected Splash splashLoader;
	
	/**
	 * Parameter parser used for this driver.
	 */
	protected RuntimeParamParser paramParser;

	public ResourceManager(String[] args) {
		splashLoader = new Splash();
		paramParser = new RuntimeParamParser(args);
		loadSerializedResources();
		initManagers();
	}
	
	public RuntimeParamParser getParamParser() {
		return paramParser;
	}
	
	public abstract void initManagers();
	
	public abstract void loadSerializedResources();

	public abstract void storeSerializedResources();
	
	public abstract void close();

	public abstract MessageParser getMessageParser();
}
