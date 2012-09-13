package wsintelliauction.client.device.driver;


/**
 * This is the driver interface for the client hardware. 
 * All drivers for the client channel connection hardware should follow his guide for 
 * API construction, as this allows the device engine to operate it in the appropriate manner;
 */
public interface DeviceDriver 
{
	/**
	 * Allows the client to connect to the channel specified. The client must then connect using their 
	 * user name and password to authenticate the users access rights to that slot.
	 * 
	 * @param ChannelNo
	 * @param Username
	 * @param Password
	 */
	public void Connect(int ChannelNo, String Username, String Password);
	
	/**
	 * Disconnects the client from the specified channel, the client must give 
	 * the server some information on the reason for its disconnection. 
	 * This is done with the status flag. 
	 * Status: 	 0 	-	The client disconnected manually.
	 * 			 1	- 	The client disconnected as end of lease was reached.
	 * 			 2	- 	The client disconnected as a result of the PU coming online. 	  
	 * 
	 * @param ChannelNo
	 * @param Status
	 */
	public void Disconnect(int ChannelNo, int  Status);
	
}
