package com.uct.cs.wsintelliauction.server.backend.device.engine;

import java.util.concurrent.atomic.AtomicBoolean;

import com.uct.cs.wsintelliauction.server.backend.device.driver.CognativeDevice;
import com.uct.cs.wsintelliauction.util.AbstractDriver;
import com.uct.cs.wsintelliauction.util.ThreadManager;


public class Driver extends AbstractDriver implements Runnable
{

	/*
	 * Here are our device driver variables, these are initialized on the super classes call to init.
	 * ChannelsConnected 	- States the amount of channels which are present on the connected device;
	 * UpdateSpeed 		- Gives the update speed desired in Hz, on cycle is defined as one observation 
	 * 						  of the channel network with a response about user usage.
	 * 
	 */
	private int ChannelsConnected, UpdateSpeed; 
	private AtomicBoolean Running;	
	
	
	CognativeDevice Dev; 
	
	public Driver(String[] args) 
	{
		super(args);
	}

	/**
	 * This method is used to begin execution of the driver class for the cognitive device.
	 * The channels that are connected are observed at a the frequency specified on driver initialization.
	 * The driver is responsible for communicating with the servers database to inform it of channel use.
	 */
	public void exec() 
	{
		ThreadManager.assignThread(this);
		Running.set(true);
	}

	public void init() 
	{
		//Setup the device..
		Dev = new CognativeDevice();
		ChannelsConnected = Dev.getAmountChannels();
		UpdateSpeed = Dev.getDefaultUpdateSpeed();
	}

	public void close() 
	{
		Running.set(false);
	}

	@Override
	public void run() 
	{
		while(Running.get())
		{
			//Pause this thread for 600ms to achieve to achieve the approximate frequency defined.
			ThreadManager.pauseThisForMillis(60000/Dev.getDefaultUpdateSpeed()); 

			Dev.update();
			for(int i = Dev.getAmountChannels() ; i >= 0 ; i--)
			{
				//Update the database only if there is a change.
				if(Dev.hasChanged(i))
				{
					//Retrieve the channel object
					Dev.getChannelStatus(i);
					
					
					/***
					 * TODO
					 * 
					 * HERE WE CHANGE THE DATABASE..
					 * 
					 */
					
					
				}
			}
		}
	}

}