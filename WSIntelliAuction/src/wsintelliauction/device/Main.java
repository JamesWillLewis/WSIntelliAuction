package wsintelliauction.device;

import wsintelliauction.device.engine.Driver;

public class Main {

	/**
	 * This Main is used to simply start the device engine. The drivers found under the device.driver package 
	 * will handle the hardware interface whilst the engine controls that driver and publishes the appropriate results.
	 */
	public static void main(String[] args) 
	{
		Driver driver = new Driver(args);
		driver.exec();
	}

}
