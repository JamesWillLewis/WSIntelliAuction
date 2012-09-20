package wsintelliauction.net;

import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;

import wsintelliauction.client.backend.net.ClientNetworkManager;
import wsintelliauction.net.Recipient;
import wsintelliauction.net.message.InfoMessage;
import wsintelliauction.util.AppConfig;
import wsintelliauction.util.ThreadManager;

/**
 * Code snippet for creating a client which can send and receive objects over a
 * network.
 * 
 * @author James
 * 
 */
public class ObjectIOClientSnippet {

	public static void main(String[] args) {
		while (true) {
			final ClientNetworkManager clientNetworkManager = new ClientNetworkManager();
			final int randomClientNum = (int) (Math.random() * 100);
			try {
				clientNetworkManager.connectTo(new Recipient("localhost",
						Integer.parseInt(AppConfig.getProperty("port"))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Runnable sendT = new Runnable() {

				@Override
				public void run() {
					while (true) {
						ThreadManager.pauseThisForMillis(500);
						clientNetworkManager
								.dispatchMessage(new InfoMessage("From: "
										+ randomClientNum));
					}

				}
			};

			Runnable recieveT = new Runnable() {

				@Override
				public void run() {
					while (true) {
						System.out.println(randomClientNum + " recieved: "
								+ clientNetworkManager.consumeMessage());
					}

				}
			};

			ThreadManager.assignThread(sendT);
			ThreadManager.assignThread(recieveT);
			ThreadManager.pauseThisForMillis(500);
		}
	}

}
