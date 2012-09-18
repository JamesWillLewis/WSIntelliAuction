package wsintelliauction.net;

import wsintelliauction.net.NetworkConnection;
import wsintelliauction.net.message.InfoMessage;
import wsintelliauction.server.backend.net.ServerNetworkManager;
import wsintelliauction.util.ThreadManager;

/**
 * Code snippet for creating a server which can send and receive objects over a
 * network.
 * 
 * @author James
 * 
 */
public class ObjectIOServerSnippet {

	public static void main(String[] args) {
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
	}

}
