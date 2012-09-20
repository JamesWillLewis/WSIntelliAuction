package com.uct.cs.wsintelliauction.server.frontend.views;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.gui.View;
import com.uct.cs.wsintelliauction.server.frontend.models.LeasesTabModel;

import net.miginfocom.swing.MigLayout;

public class LeasesTabView  extends View<LeasesTabModel> {
	
	public LeasesTabView(LeasesTabModel model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	private JTable table;
	

	@Override
	protected void initialize() {
		setBorder(new TitledBorder(null, "Lease Management",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		JLabel lblFilter = new JLabel("Filter:");
		add(lblFilter, "flowx,cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Lease #", "Channel #", "Secondary User", "Frequency Band", "Power Limitation", "Lease Period", "State"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(129);
		table.getColumnModel().getColumn(2).setPreferredWidth(139);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.getColumnModel().getColumn(4).setPreferredWidth(121);
		table.getColumnModel().getColumn(5).setPreferredWidth(125);
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Pending", "Held", "Suspended", "Cancelled", "Expired"}));
		add(comboBox, "cell 0 0");
		
		JButton btnSuspendLease = new JButton("Suspend");
		add(btnSuspendLease, "flowx,cell 0 2");
		
		JButton btnCancelLease = new JButton("Terminate");
		add(btnCancelLease, "cell 0 2");
		
		JButton btnReallocate = new JButton("Reallocate");
		add(btnReallocate, "cell 0 2");
		
	}
	
	@Override
	public String toString() {
		return "Leases";
	}

}
