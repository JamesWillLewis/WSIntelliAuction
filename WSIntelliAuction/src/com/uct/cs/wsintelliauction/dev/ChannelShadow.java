package com.uct.cs.wsintelliauction.dev;

/**
 * A Channel Shadow is a hueristics platform for the channels we use.
 * It stores information that may be of concern to us.
 */
public class ChannelShadow 
{
	/*
	 * Variable Declarations.
	 * 	Primary User State, true ~ online
	 * 						false ~ offline
	 *  Time Stamp, last time the user state changed
	 */
	private boolean PUState;
	private long TimeStamp;
	
	/**
	 * Constructs a channel heuristics node, known as a channel shadow.
	 * Given The Primary user status and Time Stamp.
	 * @param PUState
	 * @param TimeStamp
	 */
	public ChannelShadow(boolean PUState, long TimeStamp)
	{
		this.PUState = PUState;
		this.TimeStamp = TimeStamp;
	}
	
	/**
	 * Returns the TimeStamp
	 * @return TimeStamp long
	 */
	public long getTimeStamp(){
		return TimeStamp;
	}
	
	/**
	 * Returns the last saved PU State.
	 * @return PUState boolean
	 */
	public boolean getPUState(){
		return PUState;
	}
	/**
	 * Saves the last primary user state.
	 * @param PUState boolean
	 */
	public void setPUState(boolean PUState){
		this.PUState = PUState;
	}
	
	/**
	 * Saves the last primary users, State change time.
	 * @param TimeStamp long
	 */
	public void setTimeStamp(long TimeStamp){
		this.TimeStamp = TimeStamp;
	}

}
