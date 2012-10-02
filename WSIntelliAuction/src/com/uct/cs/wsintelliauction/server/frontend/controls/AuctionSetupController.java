package com.uct.cs.wsintelliauction.server.frontend.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import com.uct.cs.wsintelliauction.auction.Auction;
import com.uct.cs.wsintelliauction.database.persistent.tables.Location;
import com.uct.cs.wsintelliauction.server.frontend.models.AuctionSetupModel;
import com.uct.cs.wsintelliauction.server.frontend.views.AuctionSetupView;
import com.uct.cs.wsintelliauction.window.Controller;

public class AuctionSetupController extends
		Controller<AuctionSetupModel, AuctionSetupView> {

	public AuctionSetupController(AuctionSetupView view, AuctionSetupModel model) {
		super(view, model);
	}

	@Override
	protected void assignListeners() {
		view.getComboBox().addActionListener(new NewLocationSelectedEvent());

	}

	public class NewLocationSelectedEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.setSelectedLocation(view.getComboBox().getSelectedIndex());
			Location selectLocation = model.getSelectedLocation();
			view.getUpperBoundField().setText(
					selectLocation.getUpperBound() + " MHz");
			view.getLowerBoundField().setText(
					selectLocation.getLowerBound() + " MHz");
			view.getSpectrumSizeField().setText(
					selectLocation.getAvailableSpectrum() + " MHz");
			view.getPowerLimitField().setText(
					selectLocation.getPowerLimit() + " W");
		}

	}

	public boolean newAuctionEvent() {
		Date auctionEndTime = (Date) view.getEndTimeSpinner().getValue();
		Date leaseStartTime = (Date) view.getLeaseStartSpinner().getValue();
		Date leaseEndTime = (Date) view.getLeaseEndSpinner().getValue();

		if (leaseStartTime.before(auctionEndTime)) {
			JOptionPane
					.showMessageDialog(
							view,
							"The lease start time can not be before the auction end time.",
							"Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (leaseEndTime.before(leaseStartTime)) {
			JOptionPane
					.showMessageDialog(
							view,
							"The lease expire time can not be before the lease start time.",
							"Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {

			model.setAuctionEndTime(auctionEndTime);
			model.setLeaseStartDate(leaseStartTime);
			model.setLeaseEndDate(leaseEndTime);
			model.submitAuction();
			return true;
		}
	}

}
