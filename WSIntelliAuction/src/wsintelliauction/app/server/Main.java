package wsintelliauction.app.server;

import wsintelliauction.app.server.engine.Driver;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Driver driver = new Driver(args);
		driver.exec();
	}

}
