package wsintelliauction.server.frontend.mvc.mainwindow.tabs;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class DatabaseTab extends JPanel {

	public DatabaseTab() {
		setBorder(new TitledBorder(null, "Database Management",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	@Override
	public String getName() {
		return "Database";
	}
	
}
