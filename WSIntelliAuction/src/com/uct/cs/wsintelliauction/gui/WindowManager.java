package com.uct.cs.wsintelliauction.gui;

import com.uct.cs.wsintelliauction.util.ResourceManager;



/**
 * 
 * Window management super class. Maintains a list of active windows which
 * compose the graphical user interface, as well as various functions for
 * Initialization, control and communication. The window manager is responsible
 * for all creation and management of windows. Each application must derive its
 * own window manager if it utilizes a GUI.
 * 
 * @author James Lewis
 * 
 */
public abstract class WindowManager {
	
	protected ResourceManager resourceManager;

	public WindowManager(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}
	
	
	

}
