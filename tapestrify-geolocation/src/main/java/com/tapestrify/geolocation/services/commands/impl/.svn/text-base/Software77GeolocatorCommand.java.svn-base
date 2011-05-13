package com.tapestrify.geolocation.services.commands.impl;

import com.tapestrify.geolocation.internal.Geolocation;
import com.tapestrify.geolocation.services.Software77GeolocationService;
import com.tapestrify.geolocation.services.commands.GeolocatorCommand;

public class Software77GeolocatorCommand implements GeolocatorCommand{

	private final Software77GeolocationService software77GeolocationService;
	
	/**
	 * @param software77GeolocationService
	 * @author jmayaalv
	 */
	public Software77GeolocatorCommand(Software77GeolocationService software77GeolocationService) {
		super();
		this.software77GeolocationService = software77GeolocationService;
	}

	@Override
	public Geolocation geolocate(long ipNumber) {
		return this.software77GeolocationService.getByIpNumber(ipNumber);
	}

}
