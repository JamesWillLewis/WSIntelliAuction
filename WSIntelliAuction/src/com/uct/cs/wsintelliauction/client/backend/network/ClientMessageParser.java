package com.uct.cs.wsintelliauction.client.backend.network;

import javax.swing.JOptionPane;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceContainer;
import com.uct.cs.wsintelliauction.database.persistent.tables.Lease;
import com.uct.cs.wsintelliauction.network.MessageParser;
import com.uct.cs.wsintelliauction.network.NetworkConnection;
import com.uct.cs.wsintelliauction.network.message.AuctionClosureMessage;
import com.uct.cs.wsintelliauction.network.message.AuctionMessage;
import com.uct.cs.wsintelliauction.network.message.LeaseBundle;
import com.uct.cs.wsintelliauction.network.message.LeaseMessage;
import com.uct.cs.wsintelliauction.network.message.Message;
import com.uct.cs.wsintelliauction.utility.EventLogger;

public class ClientMessageParser extends MessageParser<ClientResourceContainer> {

	public ClientMessageParser(ClientResourceContainer resourceManager) {
		super(resourceManager);
	}

	@Override
	public void parseMessage(Message message, NetworkConnection server) {
		EventLogger.log("New Message Arrived: "
				+ message.getClass().getSimpleName());

		if (message instanceof AuctionMessage) {
			AuctionMessage m = (AuctionMessage) message;
			EventLogger
					.log("New auction message received from server, for location: "
							+ m.getAuctionDetails().getLocation()
									.getRegionCode());
			resourceManager.setCurrentAuction(m.getAuctionDetails());

			JOptionPane.showMessageDialog(null,
					"An auction is currently taking place for\n"
							+ "location code: "
							+ m.getAuctionDetails().getLocation()
									.getRegionCode(), "New Auction",
					JOptionPane.INFORMATION_MESSAGE);
			resourceManager.getSubmittedBids().clear();
			resourceManager.getWindowManager().getMainWindowModule()
					.getAuctionTabModule().getModel().setAuctionActive(true);
			resourceManager.getWindowManager().getMainWindowModule()
					.getAuctionTabModule().getController().update();

		} else if (message instanceof AuctionClosureMessage) {
			JOptionPane.showMessageDialog(null, "The auction has now finished."

			, "Auction Closed", JOptionPane.INFORMATION_MESSAGE);
			resourceManager.getWindowManager().getMainWindowModule()
			.getAuctionTabModule().getModel().setAuctionActive(false);
			
			resourceManager.getWindowManager().getMainWindowModule()
			.getAuctionTabModule().getController().update();
			
		} else if (message instanceof LeaseMessage) {
			Lease l = ((LeaseMessage) message).getLease();
			JOptionPane.showMessageDialog(null,
					"You have acquired a lease for a " + l.getSegment().getSegmentSize()
							+ "MHz size segment for the location: "
							+ l.getLocation().getRegionCode(),
					"Auction Closed", JOptionPane.INFORMATION_MESSAGE);
			resourceManager.getLeases().add(l);
			resourceManager.getWindowManager().getMainWindowModule()
					.getLeasesTabModule().getController().fireTableChange();
		} else if (message instanceof LeaseBundle) {
			LeaseBundle l = ((LeaseBundle) message);
			resourceManager.getLeases().clear();

			for (Lease lease : l.getLeases()) {
				resourceManager.getLeases().add(lease);
			}
			resourceManager.getWindowManager().getMainWindowModule()
					.getLeasesTabModule().getController().fireTableChange();

		}
	}

}
