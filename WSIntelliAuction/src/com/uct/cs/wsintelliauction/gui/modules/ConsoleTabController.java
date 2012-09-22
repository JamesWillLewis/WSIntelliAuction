package com.uct.cs.wsintelliauction.gui.modules;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.uct.cs.wsintelliauction.gui.Controller;
import com.uct.cs.wsintelliauction.util.ErrorLogger;
import com.uct.cs.wsintelliauction.util.EventLogger;

public class ConsoleTabController extends
		Controller<ConsoleTabModel, ConsoleTabView> {

	public ConsoleTabController(ConsoleTabView view, ConsoleTabModel model) {
		super(view, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void assignListeners() {
		view.getBtnLoadEventLog().addActionListener(new LoadEventLogEvent());
		view.getBtnLoadErrorLog().addActionListener(new LoadErrorLogEvent());
		view.getBtnClearError().addActionListener(new ClearErrorLogEvent());
		view.getBtnClearEvent().addActionListener(new ClearEventLogEvent());

	}

	public void appendMessageToErrorConsole(String entry) {
		model.appendToErrorLogConsoleText(entry);
		view.refreshErrorPane();
	}

	public void appendMessageToEventConsole(String entry) {
		model.appendToEventLogConsoleText(entry);
		view.refreshEventPane();
	}

	public class LoadEventLogEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.setEventLogConsoleText(EventLogger.loadLogFile());
			view.refreshEventPane();
		}

	}

	public class LoadErrorLogEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.setErrorLogConsoleText(ErrorLogger.loadLogFile());
			view.refreshErrorPane();
		}

	}

	public class ClearEventLogEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.setEventLogConsoleText("");
			view.refreshEventPane();
		}

	}

	public class ClearErrorLogEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.setErrorLogConsoleText("");
			view.refreshErrorPane();
		}

	}

}
