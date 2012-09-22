package com.uct.cs.wsintelliauction.server.backend;


import com.uct.cs.wsintelliauction.gui.Splash;

public class Main{
	

	/**
	 * please note that the program Must have a VM environment flag set, for
	 * -splash:splash\res\img\splash.png This is done using RunConfigurations in
	 * eclipse, go to Run->Run Configuration->Arguments->VM Arguments and type
	 * "-splash:res/img/splash.png" where splash is the splash image to be used.
	 * >> When shipped in a JAR, set an option in the manifest.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Driver driver = new Driver(args);
		driver.exec();
	}
}
