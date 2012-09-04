package com.uct.cs.wsintelliauction.network_interface.message;

public class TextMessage extends Message{

	private String data;
	
	public TextMessage(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	
}
