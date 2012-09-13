package wsintelliauction.client.device;

import wsintelliauction.misc.AbstractDriver;


/**
 *  This class serves as 
 * 
 */
public class Driver extends AbstractDriver implements Runnable
{

	public Driver(String[] args) 
	{
		super(args);
	}

	private boolean Running = false;
	private Thread t;
	@Override
	public void run() 
	{
		while(Running)
		{
			//TODO Do our client stuff
		}
	}

	@Override
	protected void init() 
	{
		t = new Thread(this);
		// TODO Initialize our variables
	}

	@Override
	public void exec() 
	{
		t.start();
	}

	@Override
	public void end() 
	{
		t.interrupt();	
	}

}
