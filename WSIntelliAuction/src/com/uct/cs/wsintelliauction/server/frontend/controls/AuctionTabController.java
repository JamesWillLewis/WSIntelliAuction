package com.uct.cs.wsintelliauction.server.frontend.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.uct.cs.wsintelliauction.auction.Auction;
import com.uct.cs.wsintelliauction.auction.Bid;
import com.uct.cs.wsintelliauction.server.frontend.models.AuctionTabModel;
import com.uct.cs.wsintelliauction.server.frontend.modules.AuctionSetupModule;
import com.uct.cs.wsintelliauction.server.frontend.views.AuctionTabView;
import com.uct.cs.wsintelliauction.window.Controller;

public class AuctionTabController extends
		Controller<AuctionTabModel, AuctionTabView> {

	private MainWindowController mainWindowController;

	public AuctionTabController(AuctionTabView view, AuctionTabModel model,
			MainWindowController mainWindowController) {
		super(view, model);
		this.mainWindowController = mainWindowController;
	}

	@Override
	protected void assignListeners() {
		view.getBtnInitiateNewAuction().addActionListener(
				new InitiateNewAuctionEvent());
	}

	public class InitiateNewAuctionEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			mainWindowController.setWindowEnabled(false);
			AuctionSetupModule auctionSetupModule = new AuctionSetupModule(
					model.getResourceContainer());
			auctionSetupModule
					.getView()
					.getBtnCancel()
					.addActionListener(
							new NewAuctionSetupWindowClosedEvent(
									auctionSetupModule));
			auctionSetupModule
					.getView()
					.getWrapper()
					.addWindowListener(
							new NewAuctionSetupWindowClosedEvent(
									auctionSetupModule));
			auctionSetupModule
					.getView()
					.getBtnOk()
					.addActionListener(
							new SubmitNewAuctionEvent(auctionSetupModule));
			auctionSetupModule.display();
		}
	}

	public class NewAuctionSetupWindowClosedEvent extends WindowAdapter
			implements ActionListener {

		private AuctionSetupModule parent;

		public NewAuctionSetupWindowClosedEvent(AuctionSetupModule parent) {
			this.parent = parent;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			mainWindowController.setWindowEnabled(true);
			parent.getView().getWrapper().setVisible(false);
			parent.getView().getWrapper().dispose();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			mainWindowController.setWindowEnabled(true);
			parent.getView().getWrapper().setVisible(false);
			parent.getView().getWrapper().dispose();
		}
	}

	public class SubmitNewAuctionEvent implements ActionListener {

		private AuctionSetupModule setupForm;

		public SubmitNewAuctionEvent(AuctionSetupModule parent) {
			this.setupForm = parent;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (setupForm.getController().newAuctionEvent()) {
				mainWindowController.setWindowEnabled(true);
				setupForm.getView().getWrapper().setVisible(false);
				setupForm.getView().getWrapper().dispose();
				view.updateFields();
			}
		}

	}

}
