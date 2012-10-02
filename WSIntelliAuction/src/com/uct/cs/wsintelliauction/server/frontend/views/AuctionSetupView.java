package com.uct.cs.wsintelliauction.server.frontend.views;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import com.uct.cs.wsintelliauction.server.frontend.models.AuctionSetupModel;
import com.uct.cs.wsintelliauction.window.View;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;

public class AuctionSetupView extends View<AuctionSetupModel> {

	private JFrame wrapper;
	private JComboBox<String> comboBox;
	private JTextField spectrumSizeField;
	private JTextField upperBoundField;
	private JTextField lowerBoundField;
	private JTextField powerLimitField;
	private JButton btnOk;
	private JButton btnCancel;
	private JSpinner endTimeSpinner;
	private JLabel lblLeaseStart;
	private JLabel lblLeaseEnd;
	private JSpinner leaseStartSpinner;
	private JSpinner leaseEndSpinner;

	public AuctionSetupView(AuctionSetupModel model) {
		super(model);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	protected void initialize() {
		wrapper = new JFrame();
		wrapper.setTitle("Auction settings");
		wrapper.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		wrapper.setContentPane(this);

		wrapper.setLocationRelativeTo(null);
		wrapper.getContentPane().setLayout(
				new MigLayout("", "[][100px:n][grow,right]",
						"[][][][][][][][][grow]"));

		JLabel lblAuctionContextLocation = new JLabel(
				"Auction context location:");
		wrapper.getContentPane().add(lblAuctionContextLocation,
				"cell 0 0,alignx trailing");

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(model
				.getLocationStringList()));

		wrapper.getContentPane().add(comboBox, "cell 2 0,growx");

		lblLeaseStart = new JLabel("Lease Start:");
		wrapper.getContentPane().add(lblLeaseStart, "cell 0 1,alignx trailing");

		Calendar auctionEndMin = Calendar.getInstance();
		auctionEndMin.add(Calendar.MINUTE, 0);
		Calendar auctionEndVal = Calendar.getInstance();
		auctionEndVal.add(Calendar.MINUTE, 1);

		Calendar leaseStartMin = Calendar.getInstance();
		leaseStartMin.add(Calendar.MINUTE, 30);
		Calendar leaseStartVal = Calendar.getInstance();
		leaseStartVal.add(Calendar.MINUTE, 31);

		Calendar leaseExpireMin = Calendar.getInstance();
		leaseExpireMin.add(Calendar.MINUTE, 30);
		Calendar leaseExpireVal = Calendar.getInstance();
		leaseExpireVal.add(Calendar.MINUTE, 31);

		leaseStartSpinner = new JSpinner();
		leaseStartSpinner.setModel(new SpinnerDateModel(
				leaseStartVal.getTime(), leaseStartMin.getTime(), null,
				Calendar.MINUTE));
		wrapper.getContentPane().add(leaseStartSpinner, "cell 2 1,growx");

		lblLeaseEnd = new JLabel("Lease End:");
		wrapper.getContentPane().add(lblLeaseEnd, "cell 0 2,alignx trailing");

		leaseEndSpinner = new JSpinner();
		leaseEndSpinner.setModel(new SpinnerDateModel(leaseExpireVal.getTime(),
				leaseExpireMin.getTime(), null, Calendar.MINUTE));
		wrapper.getContentPane().add(leaseEndSpinner, "cell 2 2,growx");

		JLabel lblSpectrumSize = new JLabel("Spectrum Size (MHz):");
		wrapper.getContentPane().add(lblSpectrumSize,
				"cell 0 3,alignx trailing");

		spectrumSizeField = new JTextField();
		spectrumSizeField.setEditable(false);
		wrapper.getContentPane().add(spectrumSizeField, "cell 2 3,growx");
		spectrumSizeField.setColumns(10);

		JLabel lblUpperBoundmhz = new JLabel("Upper Bound (MHz):");
		wrapper.getContentPane().add(lblUpperBoundmhz,
				"cell 0 4,alignx trailing");

		upperBoundField = new JTextField();
		upperBoundField.setEditable(false);
		wrapper.getContentPane().add(upperBoundField, "cell 2 4,growx");
		upperBoundField.setColumns(10);

		JLabel lblLowerBoundmhz = new JLabel("Lower Bound (MHz):");
		wrapper.getContentPane().add(lblLowerBoundmhz,
				"cell 0 5,alignx trailing");

		lowerBoundField = new JTextField();
		lowerBoundField.setEditable(false);
		wrapper.getContentPane().add(lowerBoundField, "cell 2 5,growx");
		lowerBoundField.setColumns(10);

		JLabel lblPowerLimitw = new JLabel("Power Limit (W):");
		wrapper.getContentPane()
				.add(lblPowerLimitw, "cell 0 6,alignx trailing");

		powerLimitField = new JTextField();
		powerLimitField.setEditable(false);
		wrapper.getContentPane().add(powerLimitField, "cell 2 6,growx");
		powerLimitField.setColumns(10);

		JLabel lblAuctionPeriodhrs = new JLabel("Auction End Time:");
		wrapper.getContentPane().add(lblAuctionPeriodhrs,
				"cell 0 7,alignx trailing");

		endTimeSpinner = new JSpinner();

		endTimeSpinner.setModel(new SpinnerDateModel(auctionEndVal.getTime(),
				auctionEndMin.getTime(), null, Calendar.MINUTE));

		wrapper.getContentPane().add(endTimeSpinner, "cell 2 7,growx");

		btnOk = new JButton("Begin");
		btnOk.setPreferredSize(new Dimension(100, 0));
		wrapper.getContentPane().add(btnOk,
				"flowx,cell 0 8 2 1,alignx left,aligny bottom");

		btnCancel = new JButton("Cancel");
		btnCancel.setPreferredSize(new Dimension(100, 22));
		wrapper.getContentPane().add(btnCancel, "cell 0 8 2 1,aligny bottom");
		initFields();
		wrapper.pack();
	}

	private void initFields() {
		getUpperBoundField().setText(
				model.getSelectedLocation().getUpperBound() + " MHz");
		getLowerBoundField().setText(
				model.getSelectedLocation().getLowerBound() + " MHz");
		getSpectrumSizeField().setText(
				model.getSelectedLocation().getAvailableSpectrum() + " MHz");
		getPowerLimitField().setText(
				model.getSelectedLocation().getPowerLimit() + " W");
	}

	public void show() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				wrapper.setVisible(true);
			}
		});
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public JTextField getUpperBoundField() {
		return upperBoundField;
	}

	public JTextField getLowerBoundField() {
		return lowerBoundField;
	}

	public JTextField getPowerLimitField() {
		return powerLimitField;
	}

	public JTextField getSpectrumSizeField() {
		return spectrumSizeField;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JFrame getWrapper() {
		return wrapper;
	}

	public JSpinner getEndTimeSpinner() {
		return endTimeSpinner;
	}

	public JSpinner getLeaseStartSpinner() {
		return leaseStartSpinner;
	}

	public JSpinner getLeaseEndSpinner() {
		return leaseEndSpinner;
	}
}
