package com.uct.cs.wsintelliauction.auction;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Calendar;
import java.util.Date;

import com.uct.cs.wsintelliauction.database.persistent.tables.Segment;

public class Bid implements Serializable{

	private static final long serialVersionUID = -3250073389016774373L;

	private Segment segment;
	
	private double bidAmount;
	
	private Date bidTime;
	
	private transient InetAddress clientAddress;

	public Bid(Segment segment, double bidAmount) {
		super();
		this.segment = segment;
		this.bidAmount = bidAmount;
		bidTime = Calendar.getInstance().getTime();
	}
	
	public double getBidAmount() {
		return bidAmount;
	}
	
	public Segment getSegment() {
		return segment;
	}
	
	public Date getBidTime() {
		return bidTime;
	}
	
	public void setClientAddress(InetAddress clientAddress) {
		this.clientAddress = clientAddress;
	}
	
	public InetAddress getClientAddress() {
		return clientAddress;
	}
	
}
