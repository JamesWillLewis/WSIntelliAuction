package wsintelliauction.server.backend;


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
			Main.percentageComplete++;
			switch (i) {
			case 0:
				Main.displayMessage = "Loading JRE 1.6 runtime environment";
				break;
			case 10:
				Main.displayMessage = "Loading bootstrap classes";
				break;
			case 20:
				Main.displayMessage = "Loading Java SE 1.7 library";
				break;
			case 30:
				Main.displayMessage = "Resolving external references";
				break;
			case 40:
				Main.displayMessage = "Loading third party libraries";
				break;
			case 50:
				Main.displayMessage = "Linking libraries";
				break;
			case 60:
				Main.displayMessage = "Scanning program file-system";
				break;
			case 70:
				Main.displayMessage = "Loading resources";
				break;
			case 80:
				Main.displayMessage = "Initializing JRE runtime engine";
				break;
			case 90:
				Main.displayMessage = "Launching application";
				break;
			}

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

		//new Main();

		Driver driver = new Driver(args);
		driver.exec();
	}
}
