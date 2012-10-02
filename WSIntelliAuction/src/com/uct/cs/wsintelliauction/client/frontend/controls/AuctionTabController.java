package com.uct.cs.wsintelliauction.client.frontend.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.uct.cs.wsintelliauction.client.frontend.models.AuctionTabModel;
import com.uct.cs.wsintelliauction.client.frontend.modules.NewBidModule;
import com.uct.cs.wsintelliauction.client.frontend.views.AuctionTabView;
import com.uct.cs.wsintelliauction.window.Controller;


public class AuctionTabController extends
		Controller<AuctionTabModel, AuctionTabView> {


	public AuctionTabController(AuctionTabView view, AuctionTabModel model) {
		super(view, model);
	}

	@Override
	protected void assignListeners() {
		view.getBtnBid().addActionListener(new NewBidEvent());
	}
	
	private class NewBidEvent implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			NewBidModule newBidModule = new NewBidModule(model.getResourceContainer(), view.getTable());
			newBidModule.display();
		}
		
	}

	public void update() {
		view.updateFields();
		model.getBidTableModel().fireTableDataChanged();
	}


}
