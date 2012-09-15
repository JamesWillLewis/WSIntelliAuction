package wsintelliauction.server.device.driver;

/**
 * This class serves as the simulator for the cognitive device we would use.
 * In a real situation this class/package would be replaced by the appropriate device drivers
 * For this reason JavaDocs generation will not be taken as seriously here.
 */
public class CognativeDevice implements DeviceDriver 
{

	private final int AMOUNT_CHANNELS = 30;
	private final int DEFAULT_UPDATE_SPEED = 100;
	private final int AMOUNT_STATUS_BITS = 5;
	private final int MAX_POWER_LIMITATION = 2000;
	private final int FREQUENCY_DIVISIONS = 25;
	private final int MINIMUM_TIME_OFFLINE_BEFORE_COMING_ONLINE = 5000;
	
	private int[][] Channel;			//Holds the current information about the channels and their status
	private int[][] PreviousChannel;	//Stores the heuristics information for the channel, i.e to detect if the channel has changed!
	
	public CognativeDevice()
	{
		//Setup the device with the appropriate information
		Channel = new int[AMOUNT_CHANNELS][AMOUNT_STATUS_BITS];
		for(int i = Channel.length ; i >= 0 ; i--)
		{
			Channel[i][0] = i;	//Initialize the channel numbers
			Channel[i][2] = i * FREQUENCY_DIVISIONS;	//Split Channels into appropriate frequency range
			Channel[i][3] = i * FREQUENCY_DIVISIONS + FREQUENCY_DIVISIONS;
			Channel[i][4] = (int) (Math.random() * MAX_POWER_LIMITATION);	//Randomly assign a power limitation
			
			PreviousChannel[i][0] = 1; //Initially all users are online.
			PreviousChannel[i][1] = (int) System.currentTimeMillis(); //Mark the last time a change happened.
		}
		
	}
	
	@Override	//Return the amount of channels.
	public int getAmountChannels() { return  AMOUNT_CHANNELS; }
	
	@Override	//Return the status of that channel.
	public int[] getChannelStatus(int index){ return Channel[index]; }
	
	@Override	//Return the default operating speed of the device.
	public int getDefaultUpdateSpeed() { return DEFAULT_UPDATE_SPEED; }
	
	/**
	 * Updates the simulation, calling this is equivalent to 1 cycle.
	 * If a user is off-line there is a minimum time that must be satisfied before that user may come online again,
	 * This is to prevent very sporadic changes in the PU. So we can sell our leases efficiently. 
	 * 
	 */
	public void update()
	{
		for(int i = 0 ; i < AMOUNT_CHANNELS ; ++i)
		{
			if(PreviousChannel[i][0] == 0)
			{
				if((System.currentTimeMillis() - PreviousChannel[i][1]) > MINIMUM_TIME_OFFLINE_BEFORE_COMING_ONLINE)			
				{
					Channel[i][1] = Math.round( (float) Math.random()); //50 - 50 chance of user going off-line and online.
				}
			}
			else if(PreviousChannel[i][0] == 1)
			{
				Channel[i][1] = Math.round( (float) Math.random()); //50 - 50 chance of user going off-line and online.
			}
		}
		
	}

	public boolean hasChanged(int index) 
	{
		
		if((Channel[index][1] == 1 && PreviousChannel[index][0] == 0)) 
		{
			PreviousChannel[index][0] = 1;
			return true;
		}
		else if(Channel[index][1] == 0 && PreviousChannel[index][0] == 1)
		{
			PreviousChannel[index][0] = 0;
			return true;
		}
		
		return false;
	}
	
}
