package wsintelliauction.gui;

/**
 * An underlying data model which is paired with a WindowFrame (and Handle),
 * allowing separation of the actual GUI components, and the data model which
 * holds the values displayed in the various fields. Also holds data such
 * as state (i.e., buttons selected, buttons pushed, position of slider, etc)
 * and all information storage which is required by the interface.
 * Ideally, the window frame which this object supports must not store ANY data, 
 * and only component instances and layout information.
 * 
 * @author James Lewis
 *
 */
public abstract class WindowData{
	
	/**
	 * 	Reference to the containing window.
	 */
	protected Window<?,?,?> windowRef;
	
	public void setWindowRef(Window<?,?,?> windowRef) {
		this.windowRef = windowRef;
	}
	
	/**
	 * Sets window reference.
	 * @param windowRef Window reference.
	 */
	public abstract void updateAll();

}
