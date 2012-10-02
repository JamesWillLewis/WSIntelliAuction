package com.uct.cs.wsintelliauction.client.frontend.models;

import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.auction.AuctionDetails;
import com.uct.cs.wsintelliauction.auction.Bid;
import com.uct.cs.wsintelliauction.client.backend.ClientResourceContainer;
import com.uct.cs.wsintelliauction.window.Model;

public class AuctionTabModel extends Model<ClientResourceContainer> {

	private boolean auctionActive;
	
	private BidTableModel bidTableModel;

	public AuctionTabModel(ClientResourceContainer resourceContainer) {
		super(resourceContainer);
	}

	@Override
	public void reset() {
		bidTableModel = new BidTableModel();
	}

	public ClientResourceContainer getResourceContainer() {
		return resourceManager;
	}

	public AuctionDetails getAuctionDetails() {
		return resourceManager.getCurrentAuction();
	}

	public boolean isAuctionActive() {
		return auctionActive;
	}

	public void setAuctionActive(boolean auctionActive) {
		this.auctionActive = auctionActive;
	}

	public class BidTableModel extends DefaultTableModel {

		public BidTableModel() {
			super(new String[] { "Segment", "Amount", "Submission Time" }, 0);
		}
		
		@Override
		public Object getValueAt(int row, int column) {
			Bid b = resourceManager.getSubmittedBids().get(row);
			
			switch(column){
				case 0:
					return b.getSegment().getSegmentSize();
				case 1:
					return b.getBidAmount();
				case 2:
					return b.getBidTime();
				default: return "???";
			}
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
		@Override
		public int getRowCount() {
			return resourceManager.getSubmittedBids().size();
		}

	}
	
	public BidTableModel getBidTableModel() {
		return bidTableModel;
	}

}
