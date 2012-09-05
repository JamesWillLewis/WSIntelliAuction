package wsintelliauction.server.backend;

import wsintelliauction.global.EventLogger;

public class Driver {

	private String args[];
	
	public Driver(String args[]) {
		this.args = args;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventLogger.log("Server application launched.");
		for(String arg: args){
			System.out.println("PARAMETER: "+arg);
		}
		new Driver(args);
	}

}
