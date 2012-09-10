package wsintelliauction;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import wsintelliauction.net.message.InfoMessage;


/**
 * Code snippet for creating a server which can send and receive objects
 * over a network.
 * 
 * @author James
 *
 */
public class ObjectIOServerSnippet {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			ServerSocket server = new ServerSocket(1024);
			System.out.println("Server opened : " + InetAddress.getLocalHost().getHostName());
			Socket clientS = server.accept();
			System.out.println("Client connected to: "+clientS.getInetAddress().getHostName());
			
			ObjectInputStream stream = new ObjectInputStream(clientS.getInputStream());
			
			while(true){
				InfoMessage m = (InfoMessage)stream.readObject();
				System.out.println(m.getData());
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
