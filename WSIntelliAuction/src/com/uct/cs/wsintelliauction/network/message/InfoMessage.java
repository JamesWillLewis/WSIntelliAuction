package com.uct.cs.wsintelliauction.network.message;

public class InfoMessage extends Message{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2123976424211453936L;
	private final String data;
	
	public InfoMessage(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data;
	}
	
}
