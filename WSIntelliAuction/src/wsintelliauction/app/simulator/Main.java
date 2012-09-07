package wsintelliauction.app.simulator;

import wsintelliauction.app.simulator.engine.Driver;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Driver driver = new Driver(args);
		driver.exec();
	}

}
