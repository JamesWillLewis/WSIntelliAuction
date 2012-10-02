package com.uct.cs.wsintelliauction.client.frontend.controls;

import com.uct.cs.wsintelliauction.client.frontend.models.LeasesTabModel;
import com.uct.cs.wsintelliauction.client.frontend.views.LeasesTabView;
import com.uct.cs.wsintelliauction.window.Controller;



public class LeasesTabController extends
		Controller<LeasesTabModel, LeasesTabView> {

	public LeasesTabController(LeasesTabView view, LeasesTabModel model) {
		super(view, model);
	}

	@Override
	protected void assignListeners() {

	}

	public void fireTableChange() {
		model.getLeaseTableModel().fireTableDataChanged();
	}

}
