package com.uct.cs.wsintelliauction.net;

import java.util.concurrent.atomic.AtomicBoolean;

import com.uct.cs.wsintelliauction.net.message.CloseConnectionMessage;
import com.uct.cs.wsintelliauction.net.message.Message;
import com.uct.cs.wsintelliauction.util.ResourceManager;

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
public abstract class MessageParser<T extends ResourceManager> {

	/**
	 * If this parser is servicing incoming messages from the network manager
	 */
	private AtomicBoolean servicingMessages;

	private T resourceManager;

	public MessageParser(T resourceManager) {
		this.resourceManager = resourceManager;
		servicingMessages = new AtomicBoolean(true);
	}

	public void parseMessage(Message message) {
	
	}
	
	
	public AtomicBoolean isServicingMessages() {
		return servicingMessages;
	}

	public void setServicingMessages(AtomicBoolean servicingMessages) {
		this.servicingMessages = servicingMessages;
	}

}
