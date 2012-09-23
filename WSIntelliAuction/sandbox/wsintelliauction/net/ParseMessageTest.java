package wsintelliauction.net;

import com.uct.cs.wsintelliauction.net.message.CloseConnectionMessage;
import com.uct.cs.wsintelliauction.net.message.ConnectionMessage;
import com.uct.cs.wsintelliauction.net.message.InfoMessage;
import com.uct.cs.wsintelliauction.net.message.Message;

public class ParseMessageTest {

	
	public static void main(String[] args){
		
		Message m = new CloseConnectionMessage(true);
		
		System.out.println( (m instanceof InfoMessage) );
		
	}
	
}
