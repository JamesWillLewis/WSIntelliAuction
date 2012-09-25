package com.uct.cs.wsintelliauction.window.modules;

import com.uct.cs.wsintelliauction.utility.ResourceContainer;
import com.uct.cs.wsintelliauction.window.Model;

public class ConsoleTabModel extends Model<ResourceContainer> {

	private String eventLogConsoleText;

	private String errorLogConsoleText;

	public ConsoleTabModel(ResourceContainer resourceContainer) {
		super(resourceContainer);
	}

	@Override
	public void reset() {
		eventLogConsoleText = "";
		errorLogConsoleText = "";
	}

	public String getErrorLogConsoleText() {
		return errorLogConsoleText;
	}

	public void setErrorLogConsoleText(String errorLogConsoleText) {
		this.errorLogConsoleText = errorLogConsoleText;
	}

	public void setEventLogConsoleText(String eventLogConsoleText) {
		this.eventLogConsoleText = eventLogConsoleText;
	}

	public String getEventLogConsoleText() {
		return eventLogConsoleText;
	}

	public void appendToErrorLogConsoleText(String entry) {
		errorLogConsoleText += entry + '\n';
	}

	public void appendToEventLogConsoleText(String entry) {
		eventLogConsoleText += entry + '\n';
	}

}
