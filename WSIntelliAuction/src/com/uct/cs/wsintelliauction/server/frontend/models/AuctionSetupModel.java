package com.uct.cs.wsintelliauction.server.frontend.models;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.uct.cs.wsintelliauction.auction.Auction;
import com.uct.cs.wsintelliauction.database.persistent.tables.Location;
import com.uct.cs.wsintelliauction.database.persistent.tables.Segment;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.window.Model;

public class AuctionSetupModel extends Model<ServerResourceContainer> {

	private List<Location> locations;

	private Location selectedLocation;

	private Date auctionEndTime;

	private Date leaseStartDate;

	private Date leaseEndDate;

	public AuctionSetupModel(ServerResourceContainer resourceManager) {
		super(resourceManager);
	}

	public void setAuctionEndTime(Date auctionEndTime) {
		this.auctionEndTime = auctionEndTime;
	}

	public void setLeaseStartDate(Date leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}

	public void setLeaseEndDate(Date leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}

	public Date getAuctionEndTime() {
		return auctionEndTime;
	}

	@Override
	public void reset() {
		locations = resourceManager.getDatabaseDriver()
				.getTable(Location.class);
		if (locations != null && locations.size() > 0) {
			selectedLocation = locations.get(0);
		} else {
			JOptionPane.showMessageDialog(null,
					"No locations are listed in the geo-location database.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void setSelectedLocation(int index) {
		this.selectedLocation = locations.get(index);
	}

	public Location getSelectedLocation() {
		return selectedLocation;
	}

	public String[] getLocationStringList() {
		String[] locationList = new String[locations.size()];

		for (int i = 0; i < locationList.length; i++) {
			locationList[i] = locations.get(i).getRegionCode();
		}

		return locationList;
	}

	public Auction getAuction() {
		List<Segment> segments = resourceManager.getDatabaseDriver().query(
				"FROM Segment WHERE minimumPower < "
						+ selectedLocation.getPowerLimit()
						+ " ORDER BY segmentSize DESC");
		return new Auction(auctionEndTime, leaseStartDate, leaseEndDate,
				selectedLocation, segments);
	}

	public void submitAuction() {
		Auction newAuction = getAuction();
		resourceManager.getSpectrumBroker().submitNewAuction(newAuction);
	}

}
