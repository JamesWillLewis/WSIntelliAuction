package wsintelliauction.server.backend.device.driver;

import wsintelliauction.dev.Channel;
import wsintelliauction.dev.ChannelShadow;

/**
 * This class serves as the simulator for the cognitive device we would use.
 * In a real situation this class/package would be replaced by the appropriate device drivers
 * For this reason JavaDocs generation will not be taken as seriously here.
 */
public class CognativeDevice implements DeviceDriver 
{

	private final int AMOUNT_CHANNELS = 30;
	private final int DEFAULT_UPDATE_SPEED = 100;
	private final int MAX_POWER_LIMITATION = 2000;
	private final int FREQUENCY_DIVISIONS = 25;
	private final int RECONNECTION_THREASHOLD = 5000;
	private final float PROBABILITY_OF_PU_STATE_SWITCH = 0.5f;
	
	private Channel Channel[];				//Holds the current information about the channels and their status
	private ChannelShadow ChannelShadow[];	//Stores the heuristics information for the channel, i.e to detect if the channel has changed!
	
	public CognativeDevice()
	{
		Channel = new Channel[AMOUNT_CHANNELS];
		//Setup the device with the appropriate information
		for(int i = AMOUNT_CHANNELS; i >= 0 ; i--)
		{
			Channel[i] = new Channel( i, true, i * FREQUENCY_DIVISIONS, (i * FREQUENCY_DIVISIONS + FREQUENCY_DIVISIONS), (Math.random() * MAX_POWER_LIMITATION));	//Randomly assign a power limitation
			
			//Create a new channel shadow. All PU are initially active and marked with their last connect time.
			ChannelShadow[i] = new ChannelShadow(true, System.currentTimeMillis());
		}
		
	}
	
	/**
	 *Returns the amount of channels connected to the device.
	 *@return Number (int) of channels connected. 
	 */
	@Override	
	public int getAmountChannels() { return  AMOUNT_CHANNELS; }
	
	/**
	 * Gets the specified channel from the device.
	 * @return the desired Channel
	 */
	@Override	
	public Channel getChannelStatus(int index){ return Channel[index]; }
	
	/**
	 * Gets the default update speed of the device to help perform 
	 * in the desired manner.
	 * 
	 * @return the speed the device operates at on default settings (int)
	 */
	@Override
	public int getDefaultUpdateSpeed() { return DEFAULT_UPDATE_SPEED; }
	
	/**
	 * Updates the simulation, calling this is equivalent to 1 cycle.
	 * If a user is off-line there is a minimum time that must be satisfied before that user may come online again,
	 * This is to prevent very sporadic changes in the PU. So we can sell our leases efficiently. 
	 * 
	 */
	public void update()
	{
		for(int i = 0 ; i < AMOUNT_CHANNELS ; ++i) //For all channels
		{
			if(!ChannelShadow[i].getPUState()) //If the PU was previously off-line, then they are reconnecting 
			{							   	   //and the threshold limit must apply..
				
				//if the PU has been off-line for longer than the reconnect threshold, then they have passed the threshold test and 
				if((System.currentTimeMillis() - ChannelShadow[i].getTimeStamp()) > RECONNECTION_THREASHOLD) 			
				{
					Channel[i].setPUState(Math.random() > PROBABILITY_OF_PU_STATE_SWITCH); //there is a PROBABILITY_OF_PU_STATE_SWITCH chance of user changing states (connected/disconnected)
				}
			}
			else //Otherwise if the user was online, then no threshold exists
			{
				Channel[i].setPUState(Math.random() > PROBABILITY_OF_PU_STATE_SWITCH); //PROBABILITY_OF_PU_STATE_SWITCH chance of user going off-line and online.
			}
		}
		
	}

	public boolean hasChanged(int index) 
	{
		//if the users state has changed 
		if(Channel[index].getPUState() != ChannelShadow[index].getPUState()) 
		{	
			ChannelShadow[index].setPUState(Channel[index].getPUState()); //Change the channel heuristics appropriately.
			return true;	
		}
		
		//Otherwise nothing has changed
		return false;
	}
	
}
