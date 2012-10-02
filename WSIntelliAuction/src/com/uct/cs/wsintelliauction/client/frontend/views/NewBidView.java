package com.uct.cs.wsintelliauction.client.frontend.views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

import net.miginfocom.swing.MigLayout;

import com.uct.cs.wsintelliauction.client.frontend.models.NewBidModel;
import com.uct.cs.wsintelliauction.window.View;
import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField;

public class NewBidView extends View<NewBidModel> {
	
	private JFrame wrapper;
	private JTable table;
	private JButton btnCancel;
	private JButton btnSubmitBid;
	private JFormattedTextField bidAmountField;

	public NewBidView(NewBidModel model) {
		super(model);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	protected void initialize() {
		wrapper = new JFrame();
		wrapper.setPreferredSize(new Dimension(300, 300));
		wrapper.setTitle("New Bid");
		wrapper.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		wrapper.setContentPane(this);
		wrapper.setLocationRelativeTo(null);
		
		wrapper.pack();
		wrapper.getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[grow][][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		wrapper.getContentPane().add(scrollPane, "cell 0 0 2 1,grow");
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(model.getSegmentTableModel());
		
		scrollPane.setViewportView(table);
		
		JLabel lblBidValue = new JLabel("Bid Value (Monetary Units):");
		wrapper.getContentPane().add(lblBidValue, "flowx,cell 0 1,alignx left");
		
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(2);
		
		bidAmountField = new JFormattedTextField(format);
		
	
		wrapper.getContentPane().add(bidAmountField, "cell 1 1,growx");
		
		btnSubmitBid = new JButton("Submit Bid");
		wrapper.getContentPane().add(btnSubmitBid, "flowx,cell 0 2");
		
		btnCancel = new JButton("Cancel");
		wrapper.getContentPane().add(btnCancel, "cell 0 2");
		
	}
	
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				wrapper.setVisible(true);
			}
		});
	}
	
	public JFrame getWrapper() {
		return wrapper;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
	public JButton getBtnSubmitBid() {
		return btnSubmitBid;
	}
	
	public JTable getTable() {
		return table;
	}
	public JFormattedTextField getBidAmountField() {
		return bidAmountField;
	}
}
