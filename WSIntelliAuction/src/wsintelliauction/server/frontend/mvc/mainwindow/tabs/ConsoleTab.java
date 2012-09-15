package wsintelliauction.server.frontend.mvc.mainwindow.tabs;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class ConsoleTab extends JPanel {

	public ConsoleTab() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Console Messages", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
	}

	@Override
	public String getName() {
		return "Console";
	}
}
