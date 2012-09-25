package wsintelliauction.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

import com.uct.cs.wsintelliauction.network.NetworkConnection;
import com.uct.cs.wsintelliauction.network.message.InfoMessage;
import com.uct.cs.wsintelliauction.server.backend.network.ServerNetworkDriver;
import com.uct.cs.wsintelliauction.utility.ThreadHandler;

/**
 * Code snippet for creating a server which can send and receive objects over a
 * network.
 * 
 * @author James
 * 
 */
public class ObjectIOServerSnippet {

	public static void main(String[] args) {
		
		try {
			ServerSocket s = new ServerSocket(9000);
			
			System.out.println(s.getInetAddress().getHostName());
			
			s.accept();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		ServerNetworkManager serverNetworkManager = new ServerNetworkManager();
		serverNetworkManager.startServer();
		while (true) {
			final NetworkConnection client = serverNetworkManager
					.pollNextClient();

			Runnable sendT = new Runnable() {

				@Override
				public void run() {
					while (true) {
						ThreadManager.pauseThisForMillis(500);
						client.sendMessage(new InfoMessage("Hello client!"));
					}

				}
			};

			Runnable recieveT = new Runnable() {

				@Override
				public void run() {
					while (true) {
						System.out.println(client.consumeMessage());
					}

				}
			};

			ThreadManager.assignThread(sendT);
			ThreadManager.assignThread(recieveT);
		}
		*/
	}

}
