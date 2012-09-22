package com.uct.cs.wsintelliauction.gui.modules;

import com.uct.cs.wsintelliauction.gui.Model;
import com.uct.cs.wsintelliauction.util.ResourceManager;

public class ConsoleTabModel extends Model<ResourceManager> {

	private String eventLogConsoleText;

	private String errorLogConsoleText;

	public ConsoleTabModel(ResourceManager resourceManager) {
		super(resourceManager);
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
