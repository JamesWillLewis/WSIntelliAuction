package com.uct.cs.wsintelliauction.server.frontend.models;

import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.auction.Auction;
import com.uct.cs.wsintelliauction.auction.Bid;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.utility.ResourceContainer;
import com.uct.cs.wsintelliauction.window.Model;

public class AuctionTabModel extends Model<ServerResourceContainer> {

	private BidTableModel bidTableModel;

	public AuctionTabModel(ServerResourceContainer resourceContainer) {
		super(resourceContainer);
	}

	@Override
	public void reset() {
		bidTableModel = new BidTableModel();
	}

	public ServerResourceContainer getResourceContainer() {
		return resourceManager;
	}

	public Auction getCurrentAuction() {
		return resourceManager.getSpectrumBroker().getCurrentAuction();
	}

	public BidTableModel getBidTableModel() {
		return bidTableModel;
	}

	private class BidTableModel extends DefaultTableModel {

		public BidTableModel() {
			super(new String[] { "Client", "Segment", "Amount",
					"Submission Time" }, 0);
		}

		@Override
		public Object getValueAt(int row, int column) {
			if (resourceManager.getSpectrumBroker().getCurrentAuction() == null) {
				return null;
			} else {
				Bid b = resourceManager.getSpectrumBroker().getCurrentAuction().getSubmittedBids().get(row);
				switch (column) {
				case 0:
					return b.getClientAddress().getHostName();
				case 1:
					return b.getSegment().getSegmentSize();
				case 2:
					return b.getBidAmount();
				case 3:
					return b.getBidTime().toString();
				default:
					return "???";
				}
			}
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

		@Override
		public int getRowCount() {
			if (resourceManager.getSpectrumBroker().getCurrentAuction() == null)
				return 0;
			else
				return resourceManager.getSpectrumBroker().getCurrentAuction()
						.getSubmittedBids().size();
		}
	}

	public void fireBidTableUpdate() {
		bidTableModel.fireTableDataChanged();
	}

}
