package com.uct.cs.wsintelliauction.client.frontend.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.client.frontend.models.NewBidModel;
import com.uct.cs.wsintelliauction.client.frontend.views.NewBidView;
import com.uct.cs.wsintelliauction.utility.ErrorLogger;
import com.uct.cs.wsintelliauction.window.Controller;

public class NewBidController extends Controller<NewBidModel, NewBidView> {

	private JTable bidTable;

	public NewBidController(NewBidView view, NewBidModel model, JTable bidTable) {
		super(view, model);
		this.bidTable = bidTable;
	}

	@Override
	protected void assignListeners() {
		view.getBtnSubmitBid().addActionListener(new SubmitBidEvent());
		view.getBtnCancel().addActionListener(new CancelEvent());
	}

	public class SubmitBidEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int selectedSegment = view.getTable().getSelectedRow();

			try {
				view.getBidAmountField().commitEdit();
			} catch (ParseException e1) {
				ErrorLogger.log(e1.getMessage());
			}

			if (selectedSegment < 0) {
				JOptionPane.showMessageDialog(null,
						"You must select a segment to bid for.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else if (view.getBidAmountField().getValue() == null
					|| ((Number) view.getBidAmountField().getValue())
							.intValue() <= 0) {
				JOptionPane.showMessageDialog(null,
						"You must bid a positive, non-negative amount.",
						"Error", JOptionPane.ERROR_MESSAGE);
			} else {

				int opt = JOptionPane
						.showConfirmDialog(
								null,
								"Are you sure you want to submit this bid? \n "
										+ "Once a bid has been submitted it cannot be reversed.\n"
										+ "You are financially committed to your bid.\n"
										+ "If this bid wins, you are legally required to pay the bid price.",
								"Confirm bid", JOptionPane.YES_NO_OPTION,
								JOptionPane.WARNING_MESSAGE);
				if (opt == JOptionPane.YES_OPTION) {
					double bidAmount = ((Number) view.getBidAmountField()
							.getValue()).doubleValue();

					model.submitBid(selectedSegment, bidAmount);
					((DefaultTableModel) bidTable.getModel())
							.fireTableDataChanged();
					view.getWrapper().setVisible(false);
					view.getWrapper().dispose();
				}
			}
		}

	}

	public class CancelEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.getWrapper().setVisible(false);
			view.getWrapper().dispose();
		}
	}

}
