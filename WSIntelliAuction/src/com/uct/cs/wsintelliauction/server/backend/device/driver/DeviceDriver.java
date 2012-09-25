package com.uct.cs.wsintelliauction.server.backend.device.driver;

import com.uct.cs.wsintelliauction.database.persistent.tables.Channel;


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
	 * Gets the specified channel, so we can extract the status information..
	 * 				
	 * @param index
	 * @return Specified channel
	 */
	public Channel getChannelStatus(int index); 
	
	/**
	 * Returns the default device refresh speed in Hz.
	 * @return Integer - DeviceSpeed in Hz
	 */
	public int getDefaultUpdateSpeed();

}
