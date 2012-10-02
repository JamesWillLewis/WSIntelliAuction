package com.uct.cs.wsintelliauction.auction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import com.uct.cs.wsintelliauction.database.persistent.tables.Location;
import com.uct.cs.wsintelliauction.database.persistent.tables.Segment;
import com.uct.cs.wsintelliauction.network.message.AuctionClosureMessage;
import com.uct.cs.wsintelliauction.network.message.AuctionMessage;
import com.uct.cs.wsintelliauction.utility.ErrorLogger;

/**
 * 
 * Auction instance. An auction has predefined parameters as specified in it's AuctionDetails field.
 * An auction will accept bids if the auction is active.
 *
 */
public class Auction{

	/**
	 * True if auction is active, false is auction is over/hasn't started.
	 */
	private AtomicBoolean auctionOn;

	/**
	 * Describes the auction.
	 */
	private AuctionDetails auctionDetails;

	/**
	 * Bids submitted for this auction.
	 */
	private List<Bid> submittedBids;

	public Auction(Date auctionEndTime, Date leaseStartDate,
			Date leaseExpireDate, Location location, List<Segment> segments) {

		auctionDetails = new AuctionDetails(auctionEndTime, leaseStartDate,
				leaseExpireDate, location, segments);

		auctionOn = new AtomicBoolean(false);
		submittedBids = Collections.synchronizedList(new ArrayList<Bid>());

	}

	/**
	 * Begin this auction.
	 */
	public void startAuction() {
		auctionDetails.setAuctionStartTime(Calendar.getInstance().getTime());
		auctionOn.set(true);
	}

	/**
	 * Submits a bid to the list of bids for this auction.
	 * @param bid Bid to submit.
	 */
	public void submitBid(Bid bid) {
		if (auctionOn.get())
			submittedBids.add(bid);
		else{
			ErrorLogger.log("A client submitted bid after auction has closed. Rejected...");
		}
	}
	
	public Date getAuctionEndTime() {
		return auctionDetails.getAuctionEndTime();
	}

	public Location getLocation() {
		 return auctionDetails.getLocation();
	}

	public AuctionMessage getAuctionMessage() {
		return new AuctionMessage(auctionDetails);
	}

	public List<Segment> getAvailableSegments() {
		return auctionDetails.getAvailableSegments();
	}

	public Date getAuctionStartTime() {
		return auctionDetails.getAuctionStartTime();
	}

	public Date getLeaseExpireDate() {
		return auctionDetails.getLeaseExpireDate();
	}

	public Date getLeaseStartDate() {
		return auctionDetails.getLeaseStartDate();
	}
	
	public AtomicBoolean getAuctionOn() {
		return auctionOn;
	}

	public List<Bid> getSubmittedBids() {
		return submittedBids;
	}
	
	public void setAuctionOn(AtomicBoolean auctionOn) {
		this.auctionOn = auctionOn;
	}

	public void concludeAuction() {
		auctionOn.set(false);
	}

	public AuctionClosureMessage getClosureMessage() {
		return new AuctionClosureMessage();
	}
	
}
