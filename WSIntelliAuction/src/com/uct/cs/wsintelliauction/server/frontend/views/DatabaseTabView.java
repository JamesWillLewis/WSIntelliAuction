package com.uct.cs.wsintelliauction.server.frontend.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

import com.uct.cs.wsintelliauction.server.frontend.models.DatabaseTabModel;
import com.uct.cs.wsintelliauction.window.View;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class DatabaseTabView extends View<DatabaseTabModel> {
	private JTable table;
	private JTextField conditionField;
	private JTextField dbNameField;
	private JButton btnSubmitQuery;
	private JComboBox<String> comboBox;

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
		temp.setPreferredSize(new Dimension(637, 433));
		temp.setLayout(new MigLayout("", "[grow]", "[400,grow,fill][][grow,bottom]"));
		
		JPanel queryInputPanel = new JPanel();
		queryInputPanel.setBorder(new TitledBorder(new LineBorder(new Color(32, 32, 32)), "Table Query", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		temp.add(queryInputPanel, "cell 0 0,grow");
		queryInputPanel.setLayout(new MigLayout("", "[][100,grow][grow]", "[][][][grow]"));
		
		JLabel lblDatabase = new JLabel("Database:");
		queryInputPanel.add(lblDatabase, "cell 0 0,alignx trailing");
		
		dbNameField = new JTextField(model.getDatabaseName());
		dbNameField.setEditable(false);
		queryInputPanel.add(dbNameField, "cell 2 0,growx");
		dbNameField.setColumns(10);
		
		JLabel lblSelectTable = new JLabel("Select Table:");
		queryInputPanel.add(lblSelectTable, "cell 0 1,alignx trailing");
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(DatabaseTabModel.TABLE_LIST));
		queryInputPanel.add(comboBox, "cell 2 1,growx");
		
		JLabel lblConditionClause = new JLabel("Filter Clause (SQL):");
		queryInputPanel.add(lblConditionClause, "cell 0 2,alignx trailing");
		
		conditionField = new JTextField();
		queryInputPanel.add(conditionField, "cell 2 2,growx");
		conditionField.setColumns(10);
		
		btnSubmitQuery = new JButton("Submit Query");
		queryInputPanel.add(btnSubmitQuery, "cell 0 3,aligny bottom");
		
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

	public JButton getBtnSubmitQuery() {
		return btnSubmitQuery;
	}
	public JTextField getConditionField() {
		return conditionField;
	}
	public int getSelectedTable() {
		return comboBox.getSelectedIndex();
	}
}
