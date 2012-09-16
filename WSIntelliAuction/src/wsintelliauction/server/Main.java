package wsintelliauction.server;

import wsintelliauction.server.backend.Driver;

import wsintelliauction.gui.Splash;

public class Main extends Splash {
	/**
	 * Default Constructor, calls the splash screen constructor and a method to
	 * compute our loading tasks, which in turn progress the Splash.
	 */
	public Main() {
		// Creates the splash screen in a new thread, so we can continue loading
		// our program as usual.
		super();

		// Simulate a loaders
		simulateOurWorkLoad();
	}

	/**
	 * This simulates the work our so called "Loader" would be doing, this
	 * increments the splash screen. This would technically be replaced by our
	 * loading tasks which would incremented the splash loader appropriately.
	 * This may be replaced all together by a new class which has a sole purpose
	 * of initializing our program.
	 */
	public void simulateOurWorkLoad() {
		for (int i = 0; i < 100; ++i) {
			Main.PercentageComplete++;
			if (i < 50)
				Main.Message = "Hell fucking yeah";
			else
				Main.Message = "Niggas be hating";

			try {
				Thread.sleep(71); 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

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

		new Main();

		Driver driver = new Driver(args);
		driver.exec();
	}
}
