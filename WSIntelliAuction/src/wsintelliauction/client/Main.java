package wsintelliauction.client;

import wsintelliauction.client.backend.Driver;

public class Main {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Driver driver = new Driver(args);
		driver.exec();
	}
	

}

