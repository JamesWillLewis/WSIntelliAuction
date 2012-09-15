package wsintelliauction.server.frontend.mvc.mainwindow.tabs;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ClientsTab extends JPanel {

	public ClientsTab() {
		setBorder(new TitledBorder(null, "Client Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}
	
	@Override
	public String getName() {
		return "Client";
	}
}
