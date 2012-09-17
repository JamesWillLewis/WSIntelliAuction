package wsintelliauction.gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.SplashScreen;

import wsintelliauction.misc.EventLogger;
import wsintelliauction.misc.ThreadManager;

/** 
 * This class is intended to be a super class to a main class.
 * That is, the class that contains the "public static void main(String []args)" method.
 * It gives the class splash screen functionality and the ability to load splash screen 
 * images and text dynamically. The splash screen is started in its own thread and updates according 
 * to the two static variables below "Percentage complete" and "Message", which are edited in the 
 * Main thread. This allows us to perform some loading task while the splash screen is being displayed.
 */
public class Splash implements Runnable 
{
    
	/*
	 * Our Variables.
	 * 
	 * UPDATE_SPEED - How fast the splash thread polls the Shared variables "Percentage" & "Message"
	 * Message - The current message the splash should display.
	 * PercentageComplete - The current percentage complete of the loader.
	 */
	private static final long UPDATE_SPEED = 31;	//Keep it Prime
	
	protected static volatile String displayMessage = "";	
	protected static double percentageComplete = 0;
	
	/*
	 * More Variables
	 * - Splash Screen to display
	 * - 2D Graphics We are drawing.
	 */
	private SplashScreen Splash;
	private Graphics2D g = null;
	
	/**
	 * This is called to renderThe Splash screen
	 * TODO Make this function a bit more flexible
	 * @param Graphics2d g to draw on.
	 */
	private void renderSplashFrame(Graphics2D g) 
    {
		//Hear we set the graphics to be transparent
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(120,140,200,40);
        g.setPaintMode();
        
        //Here we paint the black loading bar
        g.setColor(Color.BLACK);
        g.fillRect(90, 238, 400, 16);
        
        //Then we paint the blue loading bar
        g.setColor(Color.BLUE);
        g.fillRect(90, 238, (int) ((400*(percentageComplete/100))), 16);
        
        //Then the white text over the loading bar
        g.setColor(Color.WHITE);
        g.setFont(new Font("Harabara",Font.PLAIN, 14));
        g.drawString(displayMessage, 100, 250);
        
        //Finally update the splash screen
        Splash.update();
    }
    
	/**
	 * Constructs a new splash screen and runs it in a separate thread, returning control to the calling 
	 * subclass. This allows the inheriting class to control the splash dynamically, displaying messages 
	 * and percentage complete by setting static variables "Message" and "PercentageComplete" respectively.
	 */
	public Splash() 
	{
		//Get the SplashScreen object used for Java startup splash screen control on systems that support display
		Splash =  SplashScreen.getSplashScreen();
	
		try
		{
			//Check that the splash screen is existent (Computer supports splash display)
	        if (Splash == null) {
	        	throw new Exception("SplashScreen.getSplashScreen() returned null");
	        }
	        //Create the splash graphics called g.
	        g = Splash.createGraphics();
	        if (g == null) {
	        	throw new Exception("SplashScreen.creatGraphics() returned null");
	        }
	        
		}
		catch(InterruptedException E){
			 EventLogger.log("Error: "+E.getMessage()+" -> This is abnormal and a reinstall is recommended");
		}catch(Exception E){
			 EventLogger.log("Error: "+E.getMessage()+ "-> This is usually due to an incorrectly named splash file and/or runtime argument");
		}
		
		//Render the graphics frame as early as possible, dont have to wait for thread startup.
		renderSplashFrame(g);
		
		//Begin the splash screen thread.
		ThreadManager.assignThread(this);
		
    }
	
	@Override
	public void run() 
	{
			//While the program is still loading
	        while(percentageComplete < 100)
	        {
	        	//Render the splash frame
	            renderSplashFrame(g);
	            //Then pause for UPDATE_SPEED milliseconds
	            ThreadManager.pauseThisForMillis(UPDATE_SPEED);
	        }
	        //Finally close the splash display.
	        Splash.close();
	}

}

