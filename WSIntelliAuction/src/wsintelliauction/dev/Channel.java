package wsintelliauction.dev;

public class Channel 
{
	/*
	 * Self explanatory attributes.
	 */
	private int ChannelNumber, LowerBound, UpperBound;
	private double PowerLimitation;
	boolean PUState;
	
	/**
	 * Constructs a channel with the specified properties.
	 * 
	 * @param int ChannelNumber
	 * @param boolean PrimaryUserActive
	 * @param int LowerBound
	 * @param int UpperBound
	 * @param double PowerLimitation
	 */
	public Channel(int ChannelNumber,boolean PUState,int LowerBound,int UpperBound,double PowerLimitation)
	{
		this.ChannelNumber = ChannelNumber;
		this.PUState = PUState;
		this.LowerBound = LowerBound;
		this.UpperBound = UpperBound;
		this.PowerLimitation = PowerLimitation;
	}
	
	/**
	 * Set the current primary users state
	 * @param boolean PUState
	 */
	public void setPUState(boolean PUState){
		this.PUState = PUState;
	}
	
	/**
	 * Returns the current channels index number.
	 * @return int ChannelNumber
	 */
	public int getChannelNumber(){
		return ChannelNumber;
	}
	
	/**
	 * Returns the current primary users state.
	 * @return boolean PUState
	 */
	public boolean getPUState(){
		return PUState;
	}
	
	/**
	 * Returns the frequency lower bound.
	 * @return int LowerBound
	 */
	public int getLowerBound(){
		return LowerBound;
	}
	
	/**
	 * Returns the frequency upper bound.
	 * @return int UpperBound
	 */
	public int getUpperBound(){
		return UpperBound;
	}
	
	/**
	 * Returns the power limitations for the channel
	 * @return double PowerLimitation
	 */
	public double getPowerLimit(){
		return PowerLimitation;
	}
}
