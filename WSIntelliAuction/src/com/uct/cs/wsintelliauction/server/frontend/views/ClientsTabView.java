package com.uct.cs.wsintelliauction.server.frontend.views;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.uct.cs.wsintelliauction.server.frontend.models.ClientsTabModel;
import com.uct.cs.wsintelliauction.window.View;

import net.miginfocom.swing.MigLayout;

public class ClientsTabView extends View<ClientsTabModel> {
	
	
	public ClientsTabView(ClientsTabModel model) {
		super(model);
	}

	private JTable table;

	/**
	 *  @wbp.parser.entryPoint
	 */
	protected void initialize() {
		setBorder(new TitledBorder(null, "Client Management",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[][grow]"));

		JLabel lblFilter = new JLabel("Filter:");
		add(lblFilter, "flowx,cell 0 0");

		JComboBox filterComboBox = new JComboBox();
		filterComboBox.setModel(new DefaultComboBoxModel(new String[] { "All",
				"Active", "Connected", "Has outstanding bid(s)",
				"Holds lease(s)" }));
		add(filterComboBox, "cell 0 0,alignx left");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 1,grow");

		table = new JTable(model.getClientTableModel());
		scrollPane.setViewportView(table);

	}

	@Override
	public String toString() {
		return "Clients";
	}

}
