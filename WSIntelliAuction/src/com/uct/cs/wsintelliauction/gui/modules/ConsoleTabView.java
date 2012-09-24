package com.uct.cs.wsintelliauction.gui.modules;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.uct.cs.wsintelliauction.gui.View;

import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;

public class ConsoleTabView extends View<ConsoleTabModel> {

	private JTextArea eventTextPane;
	private JTextArea errorTextPane;
	private JButton btnLoadEventLog;
	private JButton btnLoadErrorLog;
	private JButton btnClearEvent;
	private JButton btnClearError;

	public ConsoleTabView(ConsoleTabModel model) {
		super(model);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	protected void initialize() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Console Messages", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setContinuousLayout(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane);

		JPanel eventPanel = new JPanel();
		eventPanel.setBorder(new TitledBorder(
				new LineBorder(new Color(0, 0, 0)), "Event Message Dialog",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setLeftComponent(eventPanel);
		eventPanel.setLayout(new MigLayout("", "[][grow]", "[grow][]"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setAutoscrolls(true);
		eventPanel.add(scrollPane, "cell 0 0 2 1,grow");

		eventTextPane = new JTextArea();
		eventTextPane.setFont(new Font("Dialog", Font.BOLD, 12));
		eventTextPane.setEditable(false);
		eventTextPane.setForeground(new Color(0, 128, 0));
		eventTextPane.setText(model.getEventLogConsoleText());
		scrollPane.setViewportView(eventTextPane);

		btnLoadEventLog = new JButton("Load Event Log");
		btnLoadEventLog
				.setToolTipText("Loads all messages from event log into this dialog");
		eventPanel.add(btnLoadEventLog, "cell 0 1");

		btnClearEvent = new JButton("Clear");
		eventPanel.add(btnClearEvent, "cell 1 1,alignx right");

		JPanel errorPanel = new JPanel();
		errorPanel.setBorder(new TitledBorder(null, "Error Message Dialog",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setRightComponent(errorPanel);
		errorPanel.setLayout(new MigLayout("", "[][grow]", "[grow][]"));

		JScrollPane scrollPane_1 = new JScrollPane();
		errorPanel.add(scrollPane_1, "cell 0 0 2 1,grow");

		errorTextPane = new JTextArea();
		errorTextPane.setEditable(false);
		errorTextPane.setFont(new Font("Dialog", Font.BOLD, 12));
		errorTextPane.setForeground(new Color(255, 0, 0));
		errorTextPane.setText(model.getErrorLogConsoleText());
		scrollPane_1.setViewportView(errorTextPane);

		btnLoadErrorLog = new JButton("Load Error Log");
		btnLoadErrorLog
				.setToolTipText("Loads all messages from error log into this dialog");
		errorPanel.add(btnLoadErrorLog, "cell 0 1");

		btnClearError = new JButton("Clear");
		errorPanel.add(btnClearError, "cell 1 1,alignx right");

		// moves the scroll viewport to the bottom of the text area.
		scrollPane.getViewport().setViewPosition(
				new Point(0, scrollPane.getViewport().getViewSize().height));
		scrollPane_1.getViewport().setViewPosition(
				new Point(0, scrollPane_1.getViewport().getViewSize().height));
	}
	
	public void refreshEventPane(){
		eventTextPane.setText(model.getEventLogConsoleText());
	}
	
	public void refreshErrorPane(){
		errorTextPane.setText(model.getErrorLogConsoleText());
	}

	@Override
	public String toString() {
		return "Console";
	}

	public JButton getBtnClearError() {
		return btnClearError;
	}
	public JButton getBtnClearEvent() {
		return btnClearEvent;
	}
	public JButton getBtnLoadEventLog() {
		return btnLoadEventLog;
	}
	
	public JButton getBtnLoadErrorLog() {
		return btnLoadErrorLog;
	}
	
}
