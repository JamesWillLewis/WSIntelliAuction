package com.uct.cs.wsintelliauction.client.backend;


public class Main
{

	/**
	 * please note that the program Must have a VM environment flag set the splash image to be used.
	 * This is done using RunConfigurations in eclipse, go to Run->Run Configuration->Arguments->VM Arguments 
	 * and type "-splash:res/img/splash.png" where splash is the splash image to be used.
	 * @param args
	 */
	public static void main(String[] args) {
		Driver driver = new Driver(args);
		driver.exec();
	}
}

