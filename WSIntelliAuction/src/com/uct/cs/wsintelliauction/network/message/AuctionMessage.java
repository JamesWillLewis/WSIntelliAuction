package com.uct.cs.wsintelliauction.network.message;

import com.uct.cs.wsintelliauction.auction.AuctionDetails;

public class AuctionMessage extends Message {

	private static final long serialVersionUID = -7129160303026785009L;

	private AuctionDetails auctionDetails;

	public AuctionMessage(AuctionDetails auctionDetails) {
		this.auctionDetails = auctionDetails;
	}

	public AuctionDetails getAuctionDetails() {
		return auctionDetails;
	}

}
