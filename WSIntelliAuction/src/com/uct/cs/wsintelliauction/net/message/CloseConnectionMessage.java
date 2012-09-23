package com.uct.cs.wsintelliauction.net.message;

/**
 * Indicates that the server has disconnected.
 * 
 * @author James
 *
 */
public class CloseConnectionMessage extends ConnectionMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6774572759680575701L;
	
	/**
	 * If the host instantiating this message was the host who initialized the disconnect.
	 */
	public boolean isInitializer;
	
	/**
	 * If this message was created due to a communication failure.
	 */
	public boolean communicationFail;
	
	public CloseConnectionMessage(boolean isInitializer) {
		this.isInitializer = isInitializer;
		communicationFail = false;
	}

}
