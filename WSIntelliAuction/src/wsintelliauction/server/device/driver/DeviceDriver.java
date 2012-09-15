package wsintelliauction.server.device.driver;


/**
 * This is the driver interface. All drivers for the Channel detection hardware should follow his guide for 
 * API construction, as this allows the device engine to operate it in the appropriate manner;
 */
public interface DeviceDriver 
{
	/**
	 * Indicates the amount of channels connected to the device, 
	 * this is used for indexing the channels appropriately.
	 * 
	 * 	@param none
	 * 	@return Integer representation of amount of connected channels
	 */
	public int getAmountChannels();
	
	/**
	 * Gets the status information for a specific channel.
	 * The returned array follows a specific order for the status information;
	 * <h1>Defined as:</h1>
	 * <ul> 	
	 * <li>			0	Channel Number		-	Specific integer number of channel </li>
	 * <li>			1	PU Present			-	Boolean flag for PU presence </li>
	 * <li>			2	Lower Frequency		-	Integer Lower Frequency Bound in Hz</li> 
	 * <li>			3	Upper Frequency		-	Integer Upper Frequency Bound in Hz</li>
	 * <li>			4	Power Limitation	-	Integer Power Limitation in mW</li>
	 * </ul>
	 * 		@TODO	More to be added later most probably  
	 * 				
	 * @param index
	 * @return String Array of status information
	 */
	public int[] getChannelStatus(int index); 
	
	/**
	 * Returns the default device refresh speed in Hz.
	 * @return Integer - DeviceSpeed in Hz
	 */
	public int getDefaultUpdateSpeed();

}
