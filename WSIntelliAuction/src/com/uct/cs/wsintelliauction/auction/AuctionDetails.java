package com.uct.cs.wsintelliauction.auction;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.uct.cs.wsintelliauction.database.persistent.tables.Location;
import com.uct.cs.wsintelliauction.database.persistent.tables.Segment;

public class AuctionDetails implements Serializable {

	private static final long serialVersionUID = 7967008840426325579L;

	protected Date auctionStartTime, auctionEndTime;

	protected Date leaseStartDate, leaseExpireDate;

	protected Location location;
	
	protected List<Segment> availableSegments;

	public AuctionDetails(Date auctionEndTime,
			Date leaseStartDate, Date leaseExpireDate, Location location,
			List<Segment> availableSegments) {
		this.auctionEndTime = auctionEndTime;
		this.leaseStartDate = leaseStartDate;
		this.leaseExpireDate = leaseExpireDate;
		this.location = location;
		this.availableSegments = availableSegments;
	}

	public Date getAuctionStartTime() {
		return auctionStartTime;
	}

	public void setAuctionStartTime(Date auctionStartTime) {
		this.auctionStartTime = auctionStartTime;
	}

	public Date getAuctionEndTime() {
		return auctionEndTime;
	}

	public void setAuctionEndTime(Date auctionEndTime) {
		this.auctionEndTime = auctionEndTime;
	}

	public Date getLeaseStartDate() {
		return leaseStartDate;
	}

	public void setLeaseStartDate(Date leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}

	public Date getLeaseExpireDate() {
		return leaseExpireDate;
	}

	public void setLeaseExpireDate(Date leaseExpireDate) {
		this.leaseExpireDate = leaseExpireDate;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Segment> getAvailableSegments() {
		return availableSegments;
	}

	public void setAvailableSegments(List<Segment> availableSegments) {
		this.availableSegments = availableSegments;
	}
	
	
	
	
	
}
