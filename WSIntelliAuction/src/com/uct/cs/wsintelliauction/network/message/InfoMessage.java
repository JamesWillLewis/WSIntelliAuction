package com.uct.cs.wsintelliauction.network.message;

public class InfoMessage extends Message{

	private String data;
	
	public InfoMessage(String data) {
		this.data = data;
		messageType = MessageTypes.INFO;
	}
	
	public String getData() {
		return data;
	}
	
}
