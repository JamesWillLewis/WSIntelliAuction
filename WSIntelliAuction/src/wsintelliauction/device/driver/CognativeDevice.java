package wsintelliauction.device.driver;

public class CognativeDevice implements DeviceDriver 
{

	/**
	 * This class serves as the simulator for the cognitive device we would use.
	 * In a real situation this class/package would be replaced by the appropriate device drivers
	 * For this reason JavaDocs generation will not be taken as seriously here.
	 */
	public CognativeDevice()
	{
		//Setup the device with the appropriate information
	}
	
	@Override
	public int getAmountChannels() 
	{
		// Return the amount of channels
		return 0;
	}

	@Override
	public String[] getChannelStatus(int index)
	{
		// Return the status of a channel
		return null;
	}
	
}
