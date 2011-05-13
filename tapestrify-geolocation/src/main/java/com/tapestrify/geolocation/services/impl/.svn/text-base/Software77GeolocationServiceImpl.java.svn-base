package com.tapestrify.geolocation.services.impl;

import java.util.List;

import com.tapestrify.geolocation.dao.Software77GeolocationDao;
import com.tapestrify.geolocation.dom.Software77Geolocation;
import com.tapestrify.geolocation.internal.IPUtils;
import com.tapestrify.geolocation.services.Software77GeolocationService;

public class Software77GeolocationServiceImpl implements Software77GeolocationService {

	private final Software77GeolocationDao software77GeolocationDao;
	
	/**
	 * @param software77GeolocationDao
	 * @author jmayaalv
	 */
	public Software77GeolocationServiceImpl(Software77GeolocationDao software77GeolocationDao) {
		super();
		this.software77GeolocationDao = software77GeolocationDao;
	}

	@Override
	public Software77Geolocation getByIpNumber(long ipNumber) {
		return this.software77GeolocationDao.getByIpNumber(ipNumber);
	}

	@Override
	public Software77Geolocation getByIp(String ip) {
		return getByIpNumber(IPUtils.getIPNumber(ip));
	}
	
	@Override
	public void save(Software77Geolocation geolocation) {
		this.software77GeolocationDao.save(geolocation);
	}

	@Override
	public void update(List<Software77Geolocation> geolocations) {
		this.software77GeolocationDao.deleteAll();
		this.software77GeolocationDao.batchInsert(geolocations);
		
	}

}
