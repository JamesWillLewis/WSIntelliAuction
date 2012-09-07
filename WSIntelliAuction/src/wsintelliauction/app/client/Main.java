package wsintelliauction.app.client;

import wsintelliauction.app.client.engine.Driver;

public class Main {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Driver driver = new Driver(args);
		driver.exec();
	}
	

}

