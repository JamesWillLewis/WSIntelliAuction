package com.uct.cs.wsintelliauction.network;

import com.uct.cs.wsintelliauction.network.message.Message;
import com.uct.cs.wsintelliauction.utility.ResourceContainer;

/**
 * Identifies various {@link Message} class types of a particular message
 * received via a {@link NetworkConnection}. The message parser is responsible
 * for calling a suitable (overloaded) method in a derived class. Some message
 * interpretations are however universal to both the client server applications
 * and thus the message actions don't need overloading.
 * 
 * 
 * 
 * @author James Lewis
 * 
 */
public abstract class MessageParser<T extends ResourceContainer> {

	/**
	 * Application resource manager
	 */
	protected T resourceManager;

	public MessageParser(T resourceManager) {
		this.resourceManager = resourceManager;
	}

	/**
	 * Handle the supplied message.
	 * 
	 * @param message Message to parse
	 * @param con Connection responsible for the message.
	 */
	public abstract void parseMessage(Message message, NetworkConnection con);
	


}
