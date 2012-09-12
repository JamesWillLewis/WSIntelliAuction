package wsintelliauction.device.engine;

import wsintelliauction.misc.AbstractDriver;

public class Driver extends AbstractDriver
{

	//Debug Flag
	private final static boolean Debug = true;
	
	/*
	 * Here are our device driver variables, these are initialized on the super classes call to init.
	 * CHANNELS_CONNECTED 	- States the amount of channels which are present on the connected device;
	 * UPDATE_SPEED 		- Gives the update speed desired in Hz, on cycle is defined as one observation 
	 * 						  of the channel network with a response about user usage.
	 * 
	 */
	private int CHANNELS_CONNECTED, UPDATE_SPEED;
	private boolean Running;
	
	public Driver(String[] args) 
	{
		//I'm a bit fuzzy here about how the TaskManager is used
		super(args);
	}

	/**
	 * This method is used to begin execution of the driver class for the cognitive device.
	 * The channels that are connected are observed at a the frequency specified on driver initialization.
	 * The driver is responsible for communicating with the servers database to inform it of channel use.
	 */
	public void exec() 
	{
		while(Running)
		{
			//Do our channel computations
		}
	}

	@Override
	public void init() 
	{
		CHANNELS_CONNECTED = 30;
		UPDATE_SPEED = 100;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}