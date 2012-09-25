package com.uct.cs.wsintelliauction.client.backend.network;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import com.uct.cs.wsintelliauction.network.Recipient;
import com.uct.cs.wsintelliauction.utility.FileStorable;

public class StorableServerList extends FileStorable<StorableServerList> implements
		Serializable {

	private static final long serialVersionUID = 1556501003509513387L;

	private ArrayList<Recipient> serverList;

	public StorableServerList() {
		serverList = new ArrayList<Recipient>();
	}

	public int size() {
		return serverList.size();
	}

	public Recipient get(int index) {
		return serverList.get(index);
	}

	public boolean add(Recipient e) {
		return serverList.add(e);
	}

	public Iterator<Recipient> iterator() {
		return serverList.iterator();
	}
	
	public ArrayList<Recipient> getServerList() {
		return serverList;
	}

	@Override
	public StorableServerList newInstance() {
		return new StorableServerList();
	}

	public Recipient remove(int index) {
		return serverList.remove(index);
	}

}
