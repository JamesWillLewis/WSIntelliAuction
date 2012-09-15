package wsintelliauction.server.frontend.mvc.mainwindow.tabs;

import java.awt.SplashScreen;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class AuctionTab extends JPanel {

	public AuctionTab() {
		setBorder(new TitledBorder(null, "Auction Management",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}
	
	@Override
	public String getName() {
		return "Auction";
	}
}
