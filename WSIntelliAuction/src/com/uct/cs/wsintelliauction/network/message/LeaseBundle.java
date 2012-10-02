package com.uct.cs.wsintelliauction.network.message;

import java.util.ArrayList;

import com.uct.cs.wsintelliauction.database.persistent.tables.Lease;

public class LeaseBundle extends Message {

	private static final long serialVersionUID = 175923351395159751L;
	
	private ArrayList<Lease> leases;
	
	public LeaseBundle(ArrayList<Lease> leases) {
		this.leases = leases;
	}
	
	public ArrayList<Lease> getLeases() {
		return leases;
	}

}
