package wsintelliauction.server.frontend.mvc.mainwindow.tabs;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class LeasesTab extends JPanel {

	public LeasesTab() {
		setBorder(new TitledBorder(null, "Lease Management",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}
	
	@Override
	public String getName() {
		return "Leases";
	}

}
