package com.uct.cs.wsintelliauction.client.backend.device.engine;

import com.uct.cs.wsintelliauction.util.AbstractDriver;


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

	public void end() 
	{
		t.interrupt();	
	}

}
