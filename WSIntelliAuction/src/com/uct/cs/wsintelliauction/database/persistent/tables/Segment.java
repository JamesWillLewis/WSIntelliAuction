package com.uct.cs.wsintelliauction.database.persistent.tables;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_SEGMENTS")
public class Segment implements Serializable {

	private static final long serialVersionUID = 5200192537698074358L;


	private Long id;


	/**
	 * Band-width of this segment, in MHz. Segment size must be < associated
	 * location's available spectrum. The segment size typically depends on the
	 * technology that implements it.
	 * 
	 * Typical values: LTE/3G channel bandwidths (5 MHz, 10 MHz,
	 * 15 MHz, 20 MHz), public safety application (1 MHz), Wi-Fi (22 MHz),
	 * Mobile TV (8 MHz),
	 * 
	 */
	private int segmentSize;

	/**
	 * Minimum power requirements for transmission. Generally dependent on the
	 * spectrum size of the segment, which relates to which particular
	 * technology will utilize this segment.
	 * 
	 * Typical values: 4W for LTE/3G, 1W for Public Safety applications and
	 * 100mW for Mobile TV (DVB-H) or Wi-Fi.
	 */
	private double minimumPower;

	public Segment() {

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
	

	public int getSegmentSize() {
		return segmentSize;
	}

	public void setSegmentSize(int segmentSize) {
		this.segmentSize = segmentSize;
	}

	public double getMinimumPower() {
		return minimumPower;
	}

	public void setMinimumPower(double minimumPower) {
		this.minimumPower = minimumPower;
	}

}
