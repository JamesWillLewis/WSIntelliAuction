package wsintelliauction.lib.gui;

/**
 * An underlying data model which is paired with a WindowFrame (and Handle),
 * allowing seperation of the actual GUI components, and the data model which
 * holds the values displayed in the various fields. Also holds data such
 * as state (i.e., buttons selected, buttons pushed, position of slider, etc)
 * and all infomation storage which is required by the interface.
 * Ideally, the window frame which this object supports must not store ANY data, 
 * and only component instances and layout information.
 * 
 * @author James Lewis
 *
 * @param <E> WindowFrame subclass.
 */
public abstract class WindowData <E extends WindowFrame<?>>{
	
	/**
	 * WindowFrame reference. Used for access to the window frame
	 * which this data model supports - allows this model to assign
	 * values to various components of the frontend WindowFrame.
	 */
	protected E frameRef;
	
	/**
	 * Sets the WindowFrame which this model supports.
	 * @param frameRef WindowFrame reference.
	 */
	public void attachFrame(E frameRef){
		this.frameRef = frameRef;
	}

	/**
	 * Update all fields in the window frame.
	 */
	public abstract void updateAll();

}
