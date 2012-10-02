package com.uct.cs.wsintelliauction.client.frontend.models;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.auction.Bid;
import com.uct.cs.wsintelliauction.client.backend.ClientResourceContainer;
import com.uct.cs.wsintelliauction.network.message.BidMessage;
import com.uct.cs.wsintelliauction.window.Model;

public class NewBidModel extends Model<ClientResourceContainer> {

	private SegmentTableModel segmentTableModel;

	public NewBidModel(ClientResourceContainer resourceManager) {
		super(resourceManager);
	}

	@Override
	public void reset() {
		segmentTableModel = new SegmentTableModel();
	}

	private class SegmentTableModel extends DefaultTableModel {

		public SegmentTableModel() {
			super(new String[] { "Segment Size (MHz)", "Minimum Power (W)" }, 0);
		}

		@Override
		public Object getValueAt(int row, int column) {
			switch (column) {
			case 0:
				return resourceManager.getCurrentAuction()
						.getAvailableSegments().get(row).getSegmentSize();
			case 1:
				return resourceManager.getCurrentAuction()
						.getAvailableSegments().get(row).getMinimumPower();
			default:
				return "???";
			}
		}

		@Override
		public int getRowCount() {
			return resourceManager.getCurrentAuction().getAvailableSegments()
					.size();
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}

	public SegmentTableModel getSegmentTableModel() {
		return segmentTableModel;
	}

	public void submitBid(int selectedSegment, double bidAmount) {
		Bid newBid = new Bid(resourceManager.getCurrentAuction()
				.getAvailableSegments().get(selectedSegment), bidAmount);
		resourceManager.getSubmittedBids().add(newBid);
		resourceManager.getNetworkManager().getServerConnection().sendMessage(new BidMessage(newBid));
		JOptionPane.showMessageDialog(null, "Bid was successfully submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
	}

}
