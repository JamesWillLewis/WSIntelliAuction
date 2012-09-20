package com.uct.cs.wsintelliauction.dev;

/**
 * This class serves as a lease for channel connections, 
 * it stores the SUs data about the lease they own.
 */
public class Lease 
{
	
	/*
	 * Self Explanatory variables 
	 */
	private Channel ChannelLeased;		//The channel Leased
	private int TimeLeftInMillis;		//The time left in milliseconds before the lease expires
	private String PublicKey; 			//TODO Can Optionally have security attached to it
	
	
	/**
	 * Construct a lease for the SU, giving the following parameters.
	 * @param int, TimeLeftInMillis
	 * @param Channel, ChannelLeased
	 * @param int, FrequencyLowerBound
	 * @param int, FrequencyUpperBound
	 * @param double, PowerLimitation
	 */
	public Lease(int TimeLeftInMillis, Channel ChannelLeased, int FrequencyLowerBound, int FrequencyUpperBound, double PowerLimitation)
	{
		this.TimeLeftInMillis = TimeLeftInMillis;
		this.ChannelLeased = ChannelLeased;
	}
	
	/**
	 * Gets the Time left before the lease expires, in milliseconds
	 * @return int, Milliseconds left in lease.
	 */
	public int getTimeLeftInMillis() {
		return TimeLeftInMillis;
	}
	
	/**
	 * Returns the channel this lease if for.
	 * @return Channel, The Channel in question
	 */
	public Channel getChannelLeased() {
		return ChannelLeased;
	}
	
	/**
	 * Returns the Number/Index of the current channel leased
	 * @return int, The Channel in questions index. 
	 */
	public int getChannelNumLeased() {
		return ChannelLeased.getChannelNumber();
	}
	
	/**
	 * Returns The Frequency Lower Bounds in Hz
	 * @return int Frequency Lower Bounds in HZ
	 */
	public int getFrequencyLowerBound() {
		return ChannelLeased.getLowerBound();
	}
	
	/**
	 * Returns The Frequency Upper Bounds in Hz
	 * @return int Frequency Upper Bounds in HZ
	 */
	public int getFrequencyUpperBound() {
		return ChannelLeased.getUpperBound();
	}
	
	/**
	 * Returns the Power limitations of the channel in mW
	 * @return double Power Limitation of channel in mW
	 */
	public double getPowerLimitation() {
		return ChannelLeased.getPowerLimit();
	}
	
	/**
	 * The public Key associated with this channel
	 * @return Returns a Special MAGIC LAZER BEAM, that guards against all foe. PEW PEW
	 */
	public String getPublicKey() {
		return PublicKey;
	}
}
