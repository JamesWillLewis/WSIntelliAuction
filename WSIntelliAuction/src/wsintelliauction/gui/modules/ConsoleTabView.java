package wsintelliauction.gui.modules;

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

import net.miginfocom.swing.MigLayout;
import wsintelliauction.gui.View;

public class ConsoleTabView extends View<ConsoleTabModel> {



	public ConsoleTabView(ConsoleTabModel model) {
		super(model);
	}

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
		eventPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Event Message Dialog", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setLeftComponent(eventPanel);
		eventPanel.setLayout(new MigLayout("", "[][grow]", "[grow][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setAutoscrolls(true);
		eventPanel.add(scrollPane, "cell 0 0 2 1,grow");
		
		JTextArea eventTextPane = new JTextArea();
		eventTextPane.setFont(new Font("Dialog", Font.PLAIN, 12));
		eventTextPane.setEditable(false);
		eventTextPane.setForeground(new Color(152, 251, 152));
		eventTextPane.setText("Fri Sep 14 18:43:44 CAT 2012 : Starting service routine...\r\nFri Sep 14 18:43:45 CAT 2012 : New window launched: class wsintelliauction.server.control.mvc.mainwindow.MainMVC\r\nSat Sep 15 23:51:36 CAT 2012 : Starting service routine...\r\nSat Sep 15 23:51:40 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSat Sep 15 23:58:23 CAT 2012 : Starting service routine...\r\nSat Sep 15 23:58:24 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 00:00:19 CAT 2012 : Starting service routine...\r\nSun Sep 16 00:00:20 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 00:00:34 CAT 2012 : Starting service routine...\r\nSun Sep 16 00:00:35 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 00:02:06 CAT 2012 : Starting service routine...\r\nSun Sep 16 00:02:07 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 00:02:42 CAT 2012 : Starting service routine...\r\nSun Sep 16 00:02:43 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 00:03:20 CAT 2012 : Starting service routine...\r\nSun Sep 16 00:03:21 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 00:40:05 CAT 2012 : Starting service routine...\r\nSun Sep 16 00:40:06 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 00:45:04 CAT 2012 : Starting service routine...\r\nSun Sep 16 00:45:05 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 00:47:56 CAT 2012 : Starting service routine...\r\nSun Sep 16 00:47:57 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 11:45:50 CAT 2012 : Starting service routine...\r\nSun Sep 16 11:45:53 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:05:15 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:05:16 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:22:29 CAT 2012 : Starting service routine...\r\n>>\r\nSun Sep 16 12:23:35 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:24:09 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:24:10 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:24:30 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:24:47 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:24:48 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:27:30 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:27:31 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:32:58 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:32:59 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:38:59 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:38:59 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:39:37 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:39:38 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:40:26 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:40:27 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:40:43 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:40:44 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:41:17 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:41:17 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:41:49 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:41:50 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:42:22 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:42:23 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:43:28 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:43:29 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:43:55 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:43:55 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:44:08 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:44:09 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:45:36 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:45:37 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:45:48 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:45:49 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:46:37 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:46:38 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:47:52 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:47:52 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:49:15 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:49:16 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:49:42 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:49:42 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:49:47 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:49:48 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:50:15 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:50:16 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:51:04 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:51:05 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:51:58 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:51:59 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:52:21 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:52:22 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:55:08 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:55:09 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:55:27 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:55:28 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:55:49 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:55:49 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:57:46 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:57:47 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:59:28 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:59:28 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 12:59:49 CAT 2012 : Starting service routine...\r\nSun Sep 16 12:59:49 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 13:00:07 CAT 2012 : Starting service routine...\r\nSun Sep 16 13:00:08 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 13:02:27 CAT 2012 : Starting service routine...\r\nSun Sep 16 13:02:28 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 13:23:18 CAT 2012 : Starting service routine...\r\nSun Sep 16 13:23:19 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 13:23:22 CAT 2012 : Starting service routine...\r\nSun Sep 16 13:23:23 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 13:55:26 CAT 2012 : Starting service routine...\r\nSun Sep 16 13:55:27 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 13:56:41 CAT 2012 : Starting service routine...\r\nSun Sep 16 13:56:42 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 13:57:13 CAT 2012 : Starting service routine...\r\nSun Sep 16 13:57:14 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 13:57:48 CAT 2012 : Starting service routine...\r\nSun Sep 16 13:57:49 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 13:58:16 CAT 2012 : Starting service routine...\r\nSun Sep 16 13:58:17 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 13:58:47 CAT 2012 : Starting service routine...\r\nSun Sep 16 13:58:48 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 14:00:35 CAT 2012 : Starting service routine...\r\nSun Sep 16 14:00:35 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 14:06:29 CAT 2012 : Starting service routine...\r\nSun Sep 16 14:06:29 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 14:22:09 CAT 2012 : Starting service routine...\r\nSun Sep 16 14:22:10 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 14:24:21 CAT 2012 : Starting service routine...\r\nSun Sep 16 14:24:22 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 14:40:22 CAT 2012 : Starting service routine...\r\nSun Sep 16 14:40:22 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 20:15:29 CAT 2012 : Error: SplashScreen.getSplashScreen() returned null-> This is usually due to an incorrectly named splash file and/or runtime argument\r\nSun Sep 16 20:20:09 CAT 2012 : Starting service routine...\r\nSun Sep 16 20:20:09 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 20:21:48 CAT 2012 : Starting service routine...\r\nSun Sep 16 20:21:49 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 20:22:44 CAT 2012 : Starting service routine...\r\nSun Sep 16 20:22:45 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 20:23:26 CAT 2012 : Starting service routine...\r\nSun Sep 16 20:23:27 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 20:27:45 CAT 2012 : Error: SplashScreen.getSplashScreen() returned null-> This is usually due to an incorrectly named splash file and/or runtime argument\r\nSun Sep 16 20:28:20 CAT 2012 : Error: SplashScreen.getSplashScreen() returned null-> This is usually due to an incorrectly named splash file and/or runtime argument\r\nSun Sep 16 20:28:34 CAT 2012 : Error: SplashScreen.getSplashScreen() returned null-> This is usually due to an incorrectly named splash file and/or runtime argument\r\nSun Sep 16 20:28:40 CAT 2012 : Error: SplashScreen.getSplashScreen() returned null-> This is usually due to an incorrectly named splash file and/or runtime argument\r\nSun Sep 16 20:28:51 CAT 2012 : Error: SplashScreen.getSplashScreen() returned null-> This is usually due to an incorrectly named splash file and/or runtime argument\r\nSun Sep 16 20:32:38 CAT 2012 : Error: SplashScreen.getSplashScreen() returned null-> This is usually due to an incorrectly named splash file and/or runtime argument\r\nSun Sep 16 20:33:21 CAT 2012 : Starting service routine...\r\nSun Sep 16 20:33:21 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 20:40:45 CAT 2012 : Starting service routine...\r\nSun Sep 16 20:40:45 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 20:52:05 CAT 2012 : Starting service routine...\r\nSun Sep 16 20:52:06 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 20:56:51 CAT 2012 : Starting service routine...\r\nSun Sep 16 20:56:51 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\nSun Sep 16 20:57:04 CAT 2012 : Starting service routine...\r\nSun Sep 16 20:57:04 CAT 2012 : New window launched: class wsintelliauction.server.frontend.mvc.mainwindow.MainMVC\r\n>>");
		scrollPane.setViewportView(eventTextPane);
		
		JButton btnLoadLogFile = new JButton("Load Event Log");
		btnLoadLogFile.setToolTipText("Loads all messages from event log into this dialog");
		eventPanel.add(btnLoadLogFile, "cell 0 1");
		
		JButton eventClearButton = new JButton("Clear");
		eventPanel.add(eventClearButton, "cell 1 1,alignx right");
		
		JPanel errorPanel = new JPanel();
		errorPanel.setBorder(new TitledBorder(null, "Error Message Dialog", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setRightComponent(errorPanel);
		errorPanel.setLayout(new MigLayout("", "[][grow]", "[grow][]"));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		errorPanel.add(scrollPane_1, "cell 0 0 2 1,grow");
		
		JTextArea errorTextPane = new JTextArea();
		errorTextPane.setEditable(false);
		errorTextPane.setFont(new Font("Dialog", Font.PLAIN, 12));
		errorTextPane.setForeground(new Color(255, 127, 80));
		errorTextPane.setText(">> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>>\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>> Error message example\r\n>>");
		scrollPane_1.setViewportView(errorTextPane);
		
		JButton btnNewButton = new JButton("Load Error Log");
		btnNewButton.setToolTipText("Loads all messages from error log into this dialog");
		errorPanel.add(btnNewButton, "cell 0 1");
		
		JButton errorClearButton = new JButton("Clear");
		errorPanel.add(errorClearButton, "cell 1 1,alignx right");	 
		
		//moves the scroll viewport to the bottom of the text area.	
		scrollPane.getViewport().setViewPosition(new Point(0, scrollPane.getViewport().getViewSize().height));
		scrollPane_1.getViewport().setViewPosition(new Point(0, scrollPane_1.getViewport().getViewSize().height));
	}
	
	@Override
	public String toString() {
		return "Console";
	}



}
