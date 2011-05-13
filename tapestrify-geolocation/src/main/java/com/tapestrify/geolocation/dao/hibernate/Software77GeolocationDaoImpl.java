package com.tapestrify.geolocation.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Property;

import com.tapestrify.geolocation.dao.Software77GeolocationDao;
import com.tapestrify.geolocation.dom.Software77Geolocation;

public class Software77GeolocationDaoImpl implements Software77GeolocationDao {

	private static final String DELETE_ALL = "DELETE FROM Software77Geolocation";

	private Session session;

	/**
	 * @param session
	 * @author jmayaalv
	 */
	public Software77GeolocationDaoImpl(Session session) {
		super();
		this.session = session;
	}

	@Override
	public Software77Geolocation getByIpNumber(long ipNumber) {
		Criteria c = this.session.createCriteria(Software77Geolocation.class);
		c.add(Property.forName("ipFrom").ge(ipNumber)).add(Property.forName("ipTo").lt(ipNumber));
		return (Software77Geolocation) c.uniqueResult();
	}

	@Override
	public void save(Software77Geolocation geolocation) {
		this.session.saveOrUpdate(geolocation);
	}

	@Override
	public void deleteAll() {
		this.session.createQuery(DELETE_ALL).executeUpdate();
	}

	@Override
	public void batchInsert(List<Software77Geolocation> geolocations) {
		if (geolocations == null) {
			return;
		}

		int size = geolocations.size();
		for (int i = 0; i < size; i++) {
			this.session.save(geolocations.get(i));
			if (i % 20 == 0) { //20, same as the JDBC batch size
				//flush a batch of inserts and release memory:
				session.flush();
				session.clear();
			}
		}
	}
}
