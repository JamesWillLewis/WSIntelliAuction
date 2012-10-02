package com.uct.cs.wsintelliauction.client.frontend.models;

import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.client.backend.ClientResourceContainer;
import com.uct.cs.wsintelliauction.database.persistent.tables.Lease;
import com.uct.cs.wsintelliauction.window.Model;

public class LeasesTabModel extends Model<ClientResourceContainer> {

	private LeaseTableModel leaseTableModel;

	public LeasesTabModel(ClientResourceContainer resourceContainer) {
		super(resourceContainer);
	}

	@Override
	public void reset() {
		leaseTableModel = new LeaseTableModel();
	}

	public DefaultTableModel getLeaseTableModel() {
		return leaseTableModel;
	}

	public class LeaseTableModel extends DefaultTableModel {

		public LeaseTableModel() {
			super(new String[] { "Lease #", "Segment", "Location",
					"Upper Bound", "Lower Bound", "Lease Begin Date",
					"Lease Expire Date" }, 0);
		}
		
		@Override
		public int getRowCount() {
			return resourceManager.getLeases().size();
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
		@Override
		public Object getValueAt(int row, int column) {
			Lease l = resourceManager.getLeases().get(row);
			switch(column){
			case 0:
				return l.getId();
			case 1:
				return l.getSegment().getSegmentSize() + "MHz";
			case 2:
				return l.getLocation().getRegionCode();
			case 3:
				return l.getUpperBound() + "MHz";
			case 4:
				return l.getLowerBound() + "MHz";
			case 5:
				return l.getLeaseStartDate();
			case 6:
				return l.getLeaseEndDate();
			default: return "???";
			
			}
		}

	}

}
