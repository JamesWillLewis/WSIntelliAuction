package com.uct.cs.wsintelliauction.snippets;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.uct.cs.wsintelliauction.network_interface.message.TextMessage;

/**
 * Code snippet for creating a client which can send and receive objects
 * over a network.
 * 
 * @author James
 *
 */
public class ObjectIOClientSnippet {

	public static void main(String[] args) throws InterruptedException {
		try {
			Socket s = new Socket("James-PC",1024);
			System.out.println("Client connected to: "+s.getInetAddress().getHostName());
			
			ObjectOutputStream stream = new ObjectOutputStream(s.getOutputStream());
			int i = 0;
			while(true){
				Thread.sleep(2000);
				i++;
				stream.writeObject(new TextMessage("hello " + i));
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
