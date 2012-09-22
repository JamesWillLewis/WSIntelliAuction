package com.uct.cs.wsintelliauction.net.message;

/**
 * Indicates that the server has disconnected.
 * 
 * @author James
 *
 */
public class CloseConnectionMessage extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6774572759680575701L;
	
	/**
	 * If the host creating this message was the host who initialized the disconnect.
	 */
	public boolean isInitializer;
	
	public CloseConnectionMessage(boolean isInitializer) {
		this.isInitializer = isInitializer;
	}

}
