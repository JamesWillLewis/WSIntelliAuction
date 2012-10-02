package com.uct.cs.wsintelliauction.client.frontend.views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

import com.uct.cs.wsintelliauction.auction.AuctionDetails;
import com.uct.cs.wsintelliauction.client.frontend.models.AuctionTabModel;
import com.uct.cs.wsintelliauction.window.View;

public class AuctionTabView extends View<AuctionTabModel> {

	private JButton btnBid;
	private JTextField startTimeField;
	private JTextField endTimeField;
	private JTextField locationField;
	private JTextField spectrumField;
	private JTextField lowerBoundField;
	private JTextField upperBoundField;
	private JTextField leaseStartField;
	private JTextField leaseEndField;
	private JTextField maxPowerField;
	private JTable table;

	public AuctionTabView(AuctionTabModel model) {
		super(model);
	}

	@Override
	/**
	 * @wbp.parser.entryPoint
	 */
	protected void initialize() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Auction Details", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		setLayout(new MigLayout("", "[grow]", "[grow][]"));

		JPanel auctionPanel = new JPanel();
		auctionPanel.setBorder(new TitledBorder(null, "Current Auction",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(auctionPanel, "cell 0 0,grow");
		auctionPanel.setLayout(new MigLayout("", "[55px,grow][][grow]",
				"[16px][][][][][][][][][][grow]"));

		JLabel lblNewLabel = new JLabel("Start Time:");
		auctionPanel.add(lblNewLabel, "cell 0 0,alignx left,aligny top");

		startTimeField = new JTextField();
		startTimeField.setEditable(false);
		auctionPanel.add(startTimeField, "cell 2 0,alignx right");
		startTimeField.setColumns(20);

		JLabel lblEndTime = new JLabel("End Time:");
		auctionPanel.add(lblEndTime, "cell 0 1");

		endTimeField = new JTextField();
		endTimeField.setEditable(false);
		auctionPanel.add(endTimeField, "cell 2 1,alignx right");
		endTimeField.setColumns(20);

		JLabel lblLocation = new JLabel("Location:");
		auctionPanel.add(lblLocation, "cell 0 2");

		locationField = new JTextField();
		locationField.setEditable(false);
		auctionPanel.add(locationField, "cell 2 2,alignx right");
		locationField.setColumns(20);

		JLabel lblSpectrumAvailable = new JLabel("Spectrum Available:");
		auctionPanel.add(lblSpectrumAvailable, "cell 0 3");

		spectrumField = new JTextField();
		spectrumField.setEditable(false);
		auctionPanel.add(spectrumField, "cell 2 3,alignx right");
		spectrumField.setColumns(20);

		JLabel lblLowerBound = new JLabel("Lower Bound:");
		auctionPanel.add(lblLowerBound, "cell 0 4");

		lowerBoundField = new JTextField();
		lowerBoundField.setEditable(false);
		auctionPanel.add(lowerBoundField, "cell 2 4,alignx right");
		lowerBoundField.setColumns(20);

		JLabel lblUpperBound = new JLabel("Upper Bound:");
		auctionPanel.add(lblUpperBound, "cell 0 5");

		upperBoundField = new JTextField();
		upperBoundField.setEditable(false);
		auctionPanel.add(upperBoundField, "cell 2 5,alignx right");
		upperBoundField.setColumns(20);

		JLabel lblMaxPowerLimit = new JLabel("Max Power Limit:");
		auctionPanel.add(lblMaxPowerLimit, "cell 0 6");

		maxPowerField = new JTextField();
		maxPowerField.setEditable(false);
		auctionPanel.add(maxPowerField, "cell 2 6,alignx right,aligny center");
		maxPowerField.setColumns(20);

		JLabel lblLeaseStartTime = new JLabel("Lease Start Time:");
		auctionPanel.add(lblLeaseStartTime, "cell 0 7");

		leaseStartField = new JTextField();
		leaseStartField.setEditable(false);
		auctionPanel.add(leaseStartField, "cell 2 7,alignx right");
		leaseStartField.setColumns(20);

		JLabel lblLeaseEndTime = new JLabel("Lease End Time:");
		auctionPanel.add(lblLeaseEndTime, "cell 0 8");

		leaseEndField = new JTextField();
		leaseEndField.setEditable(false);
		auctionPanel.add(leaseEndField, "cell 2 8,alignx right");
		leaseEndField.setColumns(20);

		JScrollPane scrollPane = new JScrollPane();
		auctionPanel.add(scrollPane, "cell 0 10 3 1,growx,aligny bottom");

		table = new JTable();
		table.setModel(model.getBidTableModel());
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		scrollPane.setViewportView(table);

		btnBid = new JButton("New Bid");
		btnBid.setEnabled(model.isAuctionActive());
		add(btnBid, "cell 0 1");

	}

	@Override
	public String toString() {
		return "Auction";
	}

	public JButton getBtnBid() {
		return btnBid;
	}

	public void updateFields() {
		AuctionDetails a = model.getAuctionDetails();
		if (a != null) {
			startTimeField.setText(a.getAuctionStartTime().toString());
			endTimeField.setText(a.getAuctionEndTime().toString());
			locationField.setText(a.getLocation().getRegionCode());
			spectrumField.setText(a.getLocation().getAvailableSpectrum()
					+ " MHz");
			lowerBoundField.setText(a.getLocation().getLowerBound() + " MHz");
			upperBoundField.setText(a.getLocation().getUpperBound() + " MHz");
			leaseStartField.setText(a.getLeaseStartDate().toString());
			leaseEndField.setText(a.getLeaseExpireDate().toString());
			maxPowerField.setText(a.getLocation().getPowerLimit() + " W");
			btnBid.setEnabled(model.isAuctionActive());
		}
	}
	
	public JTable getTable() {
		return table;
	}

}
