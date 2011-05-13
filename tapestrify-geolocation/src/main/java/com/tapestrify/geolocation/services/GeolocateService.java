package com.tapestrify.geolocation.services;

import com.tapestrify.geolocation.internal.Geolocation;

public interface GeolocateService {

	public Geolocation geolocate(String ip);
	
	public Geolocation geolocate(long ipNumber);
	
}
