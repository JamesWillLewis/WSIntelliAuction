package wsintelliauction.server.frontend.views;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class DatabaseTabView extends JPanel {

	public DatabaseTabView() {
		setBorder(new TitledBorder(null, "Database Management",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	@Override
	public String getName() {
		return "Database";
	}
	
}
