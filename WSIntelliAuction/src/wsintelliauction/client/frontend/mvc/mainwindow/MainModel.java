package wsintelliauction.client.frontend.mvc.mainwindow;

import java.util.ArrayList;

import wsintelliauction.gui.Model;
import wsintelliauction.net.Recipient;

public class MainModel extends Model {

	private ArrayList<Recipient> registeredServerList;

	@Override
	public void reset() {
		registeredServerList = new ArrayList<Recipient>();
	}

	public ArrayList<Recipient> getRegisteredServerList() {
		return registeredServerList;
	}
	

}
