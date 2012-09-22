package com.uct.cs.wsintelliauction.client.frontend.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.uct.cs.wsintelliauction.client.frontend.models.MainWindowModel;
import com.uct.cs.wsintelliauction.gui.View;


public class MainWindowView extends View<MainWindowModel> {

	private JFrame frame;
	private JTabbedPane tabs;

	public MainWindowView(MainWindowModel model) {
		super(model);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	protected void initialize() {
		frame = new JFrame("Client Application");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setContentPane(this);
		setLayout(new BorderLayout(0, 0));
		tabs = new JTabbedPane(JTabbedPane.TOP);
		add(tabs, BorderLayout.CENTER);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
	public void addTab(JPanel tabPanel){
		tabs.addTab(tabPanel.toString() , tabPanel);
	}
	
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.setVisible(true);
			}
		});
	}

	public void addWindowListener(WindowListener l) {
		frame.addWindowListener(l);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
  
}
