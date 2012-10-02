package com.uct.cs.wsintelliauction.client.frontend.views;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

import com.uct.cs.wsintelliauction.client.frontend.models.LeasesTabModel;
import com.uct.cs.wsintelliauction.window.View;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class LeasesTabView  extends View<LeasesTabModel> {
	
	public LeasesTabView(LeasesTabModel model) {
		super(model);
	}

	private JTable table;
	

	@Override
	protected void initialize() {
		setBorder(new TitledBorder(new LineBorder(new Color(32, 32, 32)), "Leases Owned", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[grow][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		table.setModel(model.getLeaseTableModel());

		scrollPane.setViewportView(table);
		
	}
	
	@Override
	public String toString() {
		return "Leases";
	}

}
