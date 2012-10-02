package com.uct.cs.wsintelliauction.server.backend.network;

import com.uct.cs.wsintelliauction.auction.Bid;
import com.uct.cs.wsintelliauction.network.MessageParser;
import com.uct.cs.wsintelliauction.network.NetworkConnection;
import com.uct.cs.wsintelliauction.network.message.BidMessage;
import com.uct.cs.wsintelliauction.network.message.Message;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.utility.EventLogger;

/**
 * 
 * Handler for various messages clients may dispatch to this server.
 * 
 * @author James Lewis
 *
 */
public class ServerMessageParser extends MessageParser<ServerResourceContainer> {

	public ServerMessageParser(ServerResourceContainer resourceManager) {
		super(resourceManager);
	}

	@Override
	public void parseMessage(Message message, NetworkConnection client) {
		EventLogger.log("Message received from client: "
				+ client.getRecipientAddress().getHostAddress());

		if(message instanceof BidMessage){
			Bid bid = ((BidMessage)message).getBid();
			bid.setClientAddress(client.getRecipientAddress());
			resourceManager.getSpectrumBroker().getCurrentAuction().submitBid(bid);
			resourceManager.getServerWindowManager().getMainWindowModule()
					.getAuctionTabModule().getModel().fireBidTableUpdate();
		}
		
	}

}
