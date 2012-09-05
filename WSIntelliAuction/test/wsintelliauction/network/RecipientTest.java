package wsintelliauction.network;

import static org.junit.Assert.*;

import java.net.UnknownHostException;

import org.junit.Test;

import wsintelliauction.global.ErrorLogger;
import wsintelliauction.network.Recipient;


public class RecipientTest {

	@Test
	public final void test() {
		try{
		byte[] ipAddr = { (byte) 137, (byte) 158, 59, 46 };
		String ipAddrS = "137.158.59.46";
		int port = 80;
		
		Recipient r1 = new Recipient(ipAddr, port);
		
		String hostName = r1.getHostName();
		Recipient r2 = new Recipient(hostName, port);
		
		Recipient r3 = new Recipient(ipAddrS, port);
		
		assertEquals("IP address", r1.getInetAddress().getHostAddress(), r2
				.getInetAddress().getHostAddress());

		assertEquals("IP address", r1.getInetAddress().getHostAddress(), r3
				.getInetAddress().getHostAddress());
		}
		catch (UnknownHostException e){
			ErrorLogger.submitError("Unable to locate host: " +e.getMessage());
		}
		
	}

}
