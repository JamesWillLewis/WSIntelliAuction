package wsintelliauction.server.backend;

public class Driver {

	
	
	public Driver() {

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Launching Server...");
		for(String arg: args){
			System.out.println("PARAMETER: "+arg);
		}
		new Driver();
	}

}