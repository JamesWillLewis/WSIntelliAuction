package com.uct.cs.wsintelliauction.network.message;

import com.uct.cs.wsintelliauction.database.persistent.tables.Lease;

public class LeaseMessage extends Message {

	private static final long serialVersionUID = -1423868678235795441L;
	
	private Lease lease;
	
	public LeaseMessage(Lease lease) {
		this.lease = lease;
	}
	
	public Lease getLease() {
		return lease;
	}
	
}
