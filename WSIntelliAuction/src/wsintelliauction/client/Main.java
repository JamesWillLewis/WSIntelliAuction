package wsintelliauction.client;

import wsintelliauction.client.backend.Driver;
import wsintelliauction.gui.Splash;

public class Main extends Splash
{
	
	public Main()
	{
		super();
		simulateOurWorkLoad();
	}
	
	public void simulateOurWorkLoad()
	{
		for(int i = 0 ; i < 100 ; ++i)
		{
			Main.PercentageComplete++;
			Main.Message = "Hell Fucking Yeah";
			try 
			{
				Thread.sleep(71);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * please note that the program Must have a VM environment flag set the splash image to be used.
	 * This is done using RunConfigurations in eclipse, go to Run->Run Configuration->Arguments->VM Arguments 
	 * and type "-splash:res/img/splash.png" where splash is the splash image to be used.
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();
		
		Driver driver = new Driver(args);
		driver.exec();
	}
}

