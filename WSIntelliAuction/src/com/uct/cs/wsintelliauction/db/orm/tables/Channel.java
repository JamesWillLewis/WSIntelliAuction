package com.uct.cs.wsintelliauction.db.orm.tables;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table (name="T_CHANNELS")
public class Channel
{
	
	private Long id;
	/*
	 * Self explanatory attributes.
	 */
	private int channelNumber, lowerBound, upperBound;
	private double powerLimitation;
	private boolean puOwned;
	
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
		this.channelNumber = ChannelNumber;
		this.puOwned = PUState;
		this.lowerBound = LowerBound;
		this.upperBound = UpperBound;
		this.powerLimitation = PowerLimitation;
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
		return channelNumber;
	}

	public void setChannelNumber(int channelNumber) {
		this.channelNumber = channelNumber;
	}

	public int getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}

	public int getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}

	public double getPowerLimitation() {
		return powerLimitation;
	}

	public void setPowerLimitation(double powerLimitation) {
		this.powerLimitation = powerLimitation;
	}

	public boolean isPUOwned() {
		return puOwned;
	}

	public void setPUOwned(boolean puOwned) {
		this.puOwned = puOwned;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
