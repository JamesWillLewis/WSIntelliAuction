package wsintelliauction.gui;

 
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.SplashScreen;

import wsintelliauction.client.Main;
import wsintelliauction.misc.EventLogger;
import wsintelliauction.misc.ThreadManager;
 
public class Splash implements Runnable 
{
    
	private static final long UPDATE_SPEED = 31;	//Keep it Prime
	protected static volatile String Message = "";
	protected static volatile double PercentageComplete = 0;
	
	private SplashScreen Splash;
	private Graphics2D g = null;
	
	private void renderSplashFrame(Graphics2D g) 
    {
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(120,140,200,40);
        g.setPaintMode();
        
        g.setColor(Color.BLACK);
        g.fillRect(90, 238, 400, 16);
        
        g.setColor(Color.BLUE);
        g.fillRect(90, 238, (int) ((400*(PercentageComplete/100))), 16);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Harabara",Font.PLAIN, 14));
       
        g.drawString(Message, 100, 250);
        
        Splash.update();
    }
    
	public Splash() 
	{
		
		Splash =  SplashScreen.getSplashScreen();
		
		try
		{
	        if (Splash == null) {
	        	throw new Exception("SplashScreen.getSplashScreen() returned null");
	        }
	        g = Splash.createGraphics();
	        if (g == null) {
	        	throw new Exception("SplashScreen.getSplashScreen() returned null");
	        }
	        
		}
		catch(InterruptedException E)
		{
			 EventLogger.log("Error: "+E.getMessage()+" -> This is abnormal and a reinstall is recommended");
		}
		catch(Exception E)
		{
			
			 EventLogger.log("Error: "+E.getMessage()+ "-> This is usually due to an incorrectly named splash file and/or runtime argument");
		}
		
		renderSplashFrame(g);
		
		ThreadManager.assignThread(this);
		
    }
	
	@Override
	public void run() 
	{
	        while(PercentageComplete < 100)
	        {
	            renderSplashFrame(g);
	            ThreadManager.pauseThisForMillis(UPDATE_SPEED);
	        }
	        Splash.close();
	}

}

