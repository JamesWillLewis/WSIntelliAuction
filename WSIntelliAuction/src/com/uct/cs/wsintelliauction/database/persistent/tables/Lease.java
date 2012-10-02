package com.uct.cs.wsintelliauction.database.persistent.tables;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name="T_LEASES")
public class Lease implements Serializable{
	
	private static final long serialVersionUID = -3988839504656332592L;

	private Long id;

	/**
	 * Segment of the spectrum which was leased
	 */
	private Segment segment;
	
	/**
	 * Segment frequency band upper bound
	 */
	private int upperBound;
	
	/**
	 * Segment frequency band lower bound
	 */
	private int lowerBound;
	
	/**
	 * Location identifier for this segment
	 */
	private Location location;
	

	private String secondaryUserID;
	
	/**
	 * Number of hours allocated for this segment
	 */
	private Date leaseStartDate;
	
	/**
	 * Number of hours allocated for this segment
	 */
	private Date leaseEndDate;
	
	public Lease() {
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

	@ManyToOne (cascade = {CascadeType.ALL} )
	public Segment getSegment() {
		return segment;
	}

	public void setSegment(Segment segment) {
		this.segment = segment;
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

	@ManyToOne (cascade = {CascadeType.ALL} )
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getLeaseStartDate() {
		return leaseStartDate;
	}
	
	public void setLeaseStartDate(Date leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}
	

	public Date getLeaseEndDate() {
		return leaseEndDate;
	}
	
	public void setLeaseEndDate(Date leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}

	public String getSecondaryUserID() {
		return secondaryUserID;
	}
	
	public void setSecondaryUserID(String secondaryUserID) {
		this.secondaryUserID = secondaryUserID;
	}
	
	
}
