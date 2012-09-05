package wsintelliauction.network.message;

public class InfoMessage extends Message{


	private static final long serialVersionUID = 1988739302576718985L;

	private String data;
	
	public InfoMessage(String data) {
		this.data = data;
		messageType = MessageTypes.INFO;
	}
	
	public String getData() {
		return data;
	}
	
}
