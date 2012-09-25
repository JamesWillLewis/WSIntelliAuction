package wsintelliauction.net;

import com.uct.cs.wsintelliauction.network.message.CloseConnectionMessage;
import com.uct.cs.wsintelliauction.network.message.ConnectionMessage;
import com.uct.cs.wsintelliauction.network.message.InfoMessage;
import com.uct.cs.wsintelliauction.network.message.Message;

public class ParseMessageTest {

	
	public static void main(String[] args){
		
		Message m = new CloseConnectionMessage(true);
		
		System.out.println( (m instanceof InfoMessage) );
		
	}
	
}
