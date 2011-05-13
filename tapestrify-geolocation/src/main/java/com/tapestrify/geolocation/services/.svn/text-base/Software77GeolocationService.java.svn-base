package com.tapestrify.geolocation.services;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.tapestrify.geolocation.dom.Software77Geolocation;


public interface Software77GeolocationService {

	@CommitAfter
	public void save(Software77Geolocation geolocation);

	public Software77Geolocation getByIpNumber(long ipNumber);
	
	public Software77Geolocation getByIp(String ip);

	@CommitAfter
	public void update(List<Software77Geolocation> geolocations);

}
