/**
 * 
 */
package com.tapestrify.geolocation.dom;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tapestrify.geolocation.internal.Geolocation;

/**
 * @author jmayaalv
 *
 */
@Entity
@Table(name="geo_software77_geolocation")
public class Software77Geolocation implements Geolocation {
	
	private long id;
	private long ipFrom;
	private long ipTo;
	private long assigned;
	private String registry;
	private String country;
	private String countryCode;
	private String region;
	private Date creationDate;
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the ipFrom
	 */
	@Column(nullable=false)
	public long getIpFrom() {
		return ipFrom;
	}

	/**
	 * @param ipFrom the ipFrom to set
	 */
	public void setIpFrom(long ipFrom) {
		this.ipFrom = ipFrom;
	}

	/**
	 * @return the ipTo
	 */
	@Column(nullable=false)
	public long getIpTo() {
		return ipTo;
	}

	/**
	 * @param ipTo the ipTo to set
	 */
	public void setIpTo(long ipTo) {
		this.ipTo = ipTo;
	}

	/**
	 * @return the assigned
	 */
	@Column(nullable=false)
	public long getAssigned() {
		return assigned;
	}

	/**
	 * @param assigned the assigned to set
	 */
	public void setAssigned(long assigned) {
		this.assigned = assigned;
	}

	/**
	 * @return the registry
	 */
	public String getRegistry() {
		return registry;
	}

	/**
	 * @param registry the registry to set
	 */
	public void setRegistry(String registry) {
		this.registry = registry;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the countryCode
	 */
	@Column(nullable=false)
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * @return the creationDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
