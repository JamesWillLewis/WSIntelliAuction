package com.uct.cs.wsintelliauction.database.persistent.tables;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Identifier a particular location in the geo-location database which has bandwidth
 * to auction. The bandwidth must be contiguous. 
 * 
 * The total bandwidth is auctioned off to secondary users in discrete pre-defined
 * segments, which define a bandwidth and a minimum signal propagation power.
 * 
 * @author James Lewis
 *
 */
@Entity
@Table(name = "T_LOCATION")
public class Location implements Serializable
{

	private static final long serialVersionUID = -5368367289056658893L;

	private Long id;

	/**
	 * Region identifier code-name. Follows the format
	 * [COUNTRY-CODE]_[PROVINCE-CODE]_[REGION-CODE]_[BLOCK] I.e, for South Africa,
	 * Western Cape, Cape Town, BLOCK_4B: ZA_WC_CT_4B.
	 */
	private String regionCode;

	/**
	 * Total (contiguous) available spectrum bandwidth (MHz) up for auction. 
	 * Defined as B = upperBound - lowerBound.
	 * Must no be greater than 100MHz, typically less than 50MHz.
	 * 
	 * Must be a multiple of the multiplex TV channel bandwidth (8 MHz).
	 */
	private int availableSpectrum;

	/**
	 * Spectrum upper bound (MHz). Must be > that lowerBound, and satisfies
	 * upperBound = lowerBound + availableBandwidth.
	 * 
	 * Minimum value of 614MHz, maximum value of 790MHz.
	 */
	private int upperBound;

	/**
	 * Spectrum lower bound (MHz). Must be < that upperBound, and satisfies
	 * lowerBound = upperBound - availableBandwidth.
	 * 
	 * Minimum value of 614MHz, maximum value of 790MHz.
	 */
	private int lowerBound;
	/**
	 * Signal propagation power limitation for this region. (W)
	 * Dependent on various variables associated with the location,
	 * such as the geography of the location, population density, 
	 * size of the location, etc. 
	 */
	private double powerLimit;


	/**
	 * All persistent classes must have a default constructor.
	 */
	public Location() {
	}

	
	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public int getAvailableSpectrum() {
		return availableSpectrum;
	}

	public void setAvailableSpectrum(int availableSpectrum) {
		this.availableSpectrum = availableSpectrum;
	}

	public int getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}

	public int getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}

	public double getPowerLimit() {
		return powerLimit;
	}

	public void setPowerLimit(double powerLimit) {
		this.powerLimit = powerLimit;
	}
	

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
