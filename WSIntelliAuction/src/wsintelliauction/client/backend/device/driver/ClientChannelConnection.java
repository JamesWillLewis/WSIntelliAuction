package wsintelliauction.client.backend.device.driver;


/**
 * This class serves as the simulator for the cognitive device we would use.
 * In a real situation this class/package would be replaced by the appropriate device drivers
 * For this reason JavaDocs generation will not be taken as seriously here.
 */
public class ClientChannelConnection implements DeviceDriver 
{
	@Override
	public void Connect(int ChannelNo, String Username, String Password) 
	{
		// TODO Handle Connection of client appropriately.
	}

	@Override
	public void Disconnect(int ChannelNo, int Status) 
	{
		// TODO Handles Disconnection of client.
	}

}
