package com.uct.cs.wsintelliauction.server.frontend.views;

import javax.swing.border.TitledBorder;

import com.uct.cs.wsintelliauction.gui.View;
import com.uct.cs.wsintelliauction.server.frontend.models.DatabaseTabModel;


public class DatabaseTabView  extends View<DatabaseTabModel>{



	public DatabaseTabView(DatabaseTabModel model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		setBorder(new TitledBorder(null, "Database Management",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
	}
	
	@Override
	public String toString() {
		return "Database";
	}
	
}
