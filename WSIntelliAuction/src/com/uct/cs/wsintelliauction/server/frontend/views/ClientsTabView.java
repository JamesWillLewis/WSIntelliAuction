package com.uct.cs.wsintelliauction.server.frontend.views;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

import com.uct.cs.wsintelliauction.server.frontend.models.ClientsTabModel;
import com.uct.cs.wsintelliauction.window.View;

public class ClientsTabView extends View<ClientsTabModel> {
	
	
	public ClientsTabView(ClientsTabModel model) {
		super(model);
	}

	private JTable table;

	/**
	 *  @wbp.parser.entryPoint
	 */
	protected void initialize() {
		setBorder(new TitledBorder(null, "Connections",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[][grow]"));



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
