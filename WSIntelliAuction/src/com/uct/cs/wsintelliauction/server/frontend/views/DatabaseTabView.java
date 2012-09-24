package com.uct.cs.wsintelliauction.server.frontend.views;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.uct.cs.wsintelliauction.gui.View;
import com.uct.cs.wsintelliauction.server.frontend.models.DatabaseTabModel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JButton;

public class DatabaseTabView extends View<DatabaseTabModel> {
	private JTable table;
	private JButton btnExecuteQuery;
	private JTextArea txtrSelect;

	public DatabaseTabView(DatabaseTabModel model) {
		super(model);
	}


	/**
	 * @wbp.parser.entryPoint
	 */
	protected void initialize() {
		setLayout(new BorderLayout());
		JPanel temp = new JPanel();
		
		temp.setBorder(new TitledBorder(null, "Database Management",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		temp.setPreferredSize(new Dimension(548, 367));
		temp.setLayout(new MigLayout("", "[grow]", "[400,grow,fill][][grow,bottom]"));
		
		JPanel queryInputPanel = new JPanel();
		queryInputPanel.setBorder(new TitledBorder(new LineBorder(new Color(32, 32, 32)), "HQL Query Input", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		temp.add(queryInputPanel, "cell 0 0,grow");
		queryInputPanel.setLayout(new MigLayout("", "[grow]", "[329.00,grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		queryInputPanel.add(scrollPane, "cell 0 0,grow");
		
		txtrSelect = new JTextArea();
		txtrSelect.setFont(new Font("Dialog", Font.BOLD, 12));
		txtrSelect.setText("SELECT -- leave this out if you want to select all (do not use SELECT *)\r\n\t{column1, column2, column3, ...}\r\nFROM \r\n\t{tableName}\r\nWHERE\r\n\t{condition}");
		txtrSelect.setForeground(new Color(0, 0, 255));
		scrollPane.setViewportView(txtrSelect);
		
		
		btnExecuteQuery = new JButton("Execute Query");
		temp.add(btnExecuteQuery, "cell 0 1");
		
		JPanel queryOutputPanel = new JPanel();
		queryOutputPanel.setBorder(new TitledBorder(new LineBorder(new Color(32, 32, 32)), "Query Result", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		temp.add(queryOutputPanel, "cell 0 2,grow");
		queryOutputPanel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		queryOutputPanel.add(scrollPane_1, "cell 0 0,grow");
		
		table = new JTable(model.getResultTable());
		scrollPane_1.setViewportView(table);
		add(temp);
	}

	@Override
	public String toString() {
		return "Database";
	}

	public JButton getBtnExecuteQuery() {
		return btnExecuteQuery;
	}
	public JTextArea getTxtrSelect() {
		return txtrSelect;
	}
}
