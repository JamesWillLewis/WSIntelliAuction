package wsintelliauction.server.device.engine;

import wsintelliauction.misc.AbstractDriver;

public class Driver extends AbstractDriver implements Runnable
{

	//Debug Flag
	private final static boolean Debug = true;  //the abstract driver superclass already has debug mode defined in it
	
	/*
	 * Here are our device driver variables, these are initialized on the super classes call to init.
	 * CHANNELS_CONNECTED 	- States the amount of channels which are present on the connected device;
	 * UPDATE_SPEED 		- Gives the update speed desired in Hz, on cycle is defined as one observation 
	 * 						  of the channel network with a response about user usage.
	 * 
	 */
	private int CHANNELS_CONNECTED, UPDATE_SPEED; // ----- only use this style for constants (i.e. things beginning with final) ----
	//if it is meant to be a constant, put the FINAL keyword before it, and set it HERE (or in the contructor)
	
	private boolean Running;	// ----- make this an AtomicBoolean
	private Thread t; //------ use my thread manager. It uses a thread pool. 
	
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
		t = new Thread(this); // USE MY THREAD MANAGER! Its there for a reason
		t.start();
	}

	@Override
	public void init() 
	{
		//if this is meant to be const
		CHANNELS_CONNECTED = 30;
		UPDATE_SPEED = 100;
	}

	@Override
	public void end() {
		//-----------------------------------------------------------------
		// Don't use interrupts or force a thread to stop. The thread will stop anyway once it has run through all its commands.
		// If you need to control ending a thread, it probably means the thread is in a loop, in that case have a while condition like
		// while(running.get()) {the code}
		// and making running an AtomicBoolean so there aren't any issues.
		// In the case of this method, the code below should simply do something like running.set(false);
		//-----------------------------------------------------------------
		
		// TODO Stop our thread
		//t.stop() is deprecated, cause it unlocks all the monitors t locks, which is undesired and causes errors.
		t.interrupt();
	}

	@Override
	public void run() 
	{
		while(Running)
		{
			//TODO Run our driver stuff
		}
	}

}