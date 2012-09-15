package wsintelliauction.server.frontend.mvc.mainwindow.tabs;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class DeviceTab extends JPanel {

	public DeviceTab() {
		setBorder(new TitledBorder(null, "Device Management",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	
	@Override
	public String getName() {
		return "Devices";
	}
}
