package com.uct.cs.wsintelliauction.server.frontend.views;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.gui.View;
import com.uct.cs.wsintelliauction.server.frontend.models.ChannelTabModel;

import net.miginfocom.swing.MigLayout;

public class ChannelTabView extends View<ChannelTabModel> {

	public ChannelTabView(ChannelTabModel model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	private JTable table;
	private final ButtonGroup filterButtonGroup = new ButtonGroup();


	@Override
	protected void initialize() {
		setBorder(new TitledBorder(null, "Channel Management",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[][grow]"));

		JLabel lblFilter = new JLabel("Filter:");
		add(lblFilter, "flowx,cell 0 0");

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "All",
				"Available", "Unavailable", "Leased" }));
		add(comboBox, "cell 0 0,alignx left");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 1,grow");

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null,
				null, null, null }, }, new String[] { "Channel ID",
				"Frequency Band", "Power Limitation", "Primary User",
				"Secondary User" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(138);
		table.getColumnModel().getColumn(2).setPreferredWidth(177);
		table.getColumnModel().getColumn(3).setPreferredWidth(137);
		table.getColumnModel().getColumn(4).setPreferredWidth(139);
		scrollPane.setViewportView(table);

	}
	
	@Override
	public String toString() {
		return "Channels";
	}
}
