package com.uct.cs.wsintelliauction.server.frontend.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.uct.cs.wsintelliauction.server.frontend.models.MainWindowModel;
import com.uct.cs.wsintelliauction.window.View;


public class MainWindowView extends View<MainWindowModel> {

	/**
	 * Window components
	 */
	private JFrame frame;
	private JTabbedPane tabs;

	private JMenuBar menuBar;
	private JMenu fileMenu, editMenu, optionsMenu, helpMenu;

	/**
	 * Create the application.
	 */
	public MainWindowView(MainWindowModel model) {
		super(model);
	}

	/**
	 * Initialise the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected void initialize() {
		frame = new JFrame("WSIntelliAuction Server");

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		optionsMenu = new JMenu("Options");
		helpMenu = new JMenu("Help");

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(optionsMenu);
		menuBar.add(helpMenu);

		frame.setContentPane(this);
		setLayout(new BorderLayout(0, 0));

		tabs = new JTabbedPane(JTabbedPane.TOP);
		add(tabs);

		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	public void addTab(JPanel tabPanel) {
		tabs.addTab(tabPanel.toString(), tabPanel);
	}

	public void show() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.setVisible(true);
			}
		});
	}

	public void addWindowListener(WindowListener mainWindowListener) {
		frame.addWindowListener(mainWindowListener);
	}
	
	public JFrame getFrame() {
		return frame;
	}

}
