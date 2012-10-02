package com.uct.cs.wsintelliauction.network.message;

import com.uct.cs.wsintelliauction.auction.Bid;

public class BidMessage extends Message {

	private static final long serialVersionUID = 5476369529938686145L;
	
	private Bid bid;
	
	public BidMessage(Bid bid) {
		this.bid = bid;
	}
	
	public Bid getBid() {
		return bid;
	}

}
