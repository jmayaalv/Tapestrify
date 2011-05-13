package com.tapestrify.geolocation.services.impl;

import org.apache.tapestry5.ioc.internal.util.InternalUtils;

import com.tapestrify.geolocation.internal.Geolocation;
import com.tapestrify.geolocation.internal.IPUtils;
import com.tapestrify.geolocation.services.GeolocateService;
import com.tapestrify.geolocation.services.commands.GeolocatorCommand;
import com.tapestrify.geolocation.services.marker.GeolocatorChain;

public class GeolocateServiceImpl implements GeolocateService {
	
	@GeolocatorChain
	private final GeolocatorCommand geolocatorChain;
	
	/**
	 * @param geolocatorCommand
	 * @author jmayaalv
	 */
	public GeolocateServiceImpl(GeolocatorCommand geolocatorChain) {
		super();
		this.geolocatorChain = geolocatorChain;
	}

	@Override
	public Geolocation geolocate(String ip) {
		if (InternalUtils.isBlank(ip) || ip.contains("1%0")){
			return null;
		}
		return this.geolocatorChain.geolocate(IPUtils.getIPNumber(ip));
	}

	@Override
	public Geolocation geolocate(long ipNumber) {
		return this.geolocatorChain.geolocate(ipNumber);
	}

}
