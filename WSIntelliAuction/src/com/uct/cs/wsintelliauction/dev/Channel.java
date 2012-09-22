package com.uct.cs.wsintelliauction.dev;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Channel 
{
	private Long id;
	/*
	 * Self explanatory attributes.
	 */
	private int ChannelNumber, LowerBound, UpperBound;
	private double PowerLimitation;
	boolean PUOwned;
	
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
		this.PUOwned = PUState;
		this.LowerBound = LowerBound;
		this.UpperBound = UpperBound;
		this.PowerLimitation = PowerLimitation;
	}
	
	/**
	 * All persistent classes must have a default constructor.
	 */
	public Channel(){}
	

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
		return id;
	}

	public int getChannelNumber() {
		return ChannelNumber;
	}

	public void setChannelNumber(int channelNumber) {
		ChannelNumber = channelNumber;
	}

	public int getLowerBound() {
		return LowerBound;
	}

	public void setLowerBound(int lowerBound) {
		LowerBound = lowerBound;
	}

	public int getUpperBound() {
		return UpperBound;
	}

	public void setUpperBound(int upperBound) {
		UpperBound = upperBound;
	}

	public double getPowerLimitation() {
		return PowerLimitation;
	}

	public void setPowerLimitation(double powerLimitation) {
		PowerLimitation = powerLimitation;
	}

	public boolean isPUOwned() {
		return PUOwned;
	}

	public void setPUOwned(boolean pUState) {
		PUOwned = pUState;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	
	
	
	
}
