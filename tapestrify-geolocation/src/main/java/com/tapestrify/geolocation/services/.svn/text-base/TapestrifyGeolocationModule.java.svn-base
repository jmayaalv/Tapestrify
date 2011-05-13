package com.tapestrify.geolocation.services;

import java.util.List;

import org.apache.tapestry5.hibernate.HibernateEntityPackageManager;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.annotations.Marker;
import org.apache.tapestry5.ioc.annotations.SubModule;
import org.apache.tapestry5.ioc.services.ChainBuilder;

import com.tapestrify.core.services.TapestrifyModule;
import com.tapestrify.geolocation.dao.Software77GeolocationDao;
import com.tapestrify.geolocation.dao.hibernate.Software77GeolocationDaoImpl;
import com.tapestrify.geolocation.services.commands.GeolocatorCommand;
import com.tapestrify.geolocation.services.commands.Importer;
import com.tapestrify.geolocation.services.commands.impl.Software77GeolocatorCommand;
import com.tapestrify.geolocation.services.commands.impl.Software77Importer;
import com.tapestrify.geolocation.services.impl.GeolocateServiceImpl;
import com.tapestrify.geolocation.services.impl.Software77GeolocationServiceImpl;
import com.tapestrify.geolocation.services.marker.GeolocatorChain;

@SubModule({TapestrifyModule.class})
public class TapestrifyGeolocationModule {

	public static void bind(ServiceBinder binder) {

		binder.bind(Software77GeolocationDao.class, Software77GeolocationDaoImpl.class);

		binder.bind(Software77GeolocationService.class, Software77GeolocationServiceImpl.class);
		binder.bind(GeolocateService.class, GeolocateServiceImpl.class);

		//importer
		binder.bind(Importer.class, Software77Importer.class).withId("Software77Importer");
	}

	@Marker(GeolocatorChain.class)
	public static GeolocatorCommand buildGeolocatorChain(List<GeolocatorCommand> commands, ChainBuilder chainBuilder) {
		return chainBuilder.build(GeolocatorCommand.class, commands);
	}

	/*  ****** Contributions ******* */

	@Contribute(GeolocatorCommand.class)
	public static void contributeGeolocatorChain(OrderedConfiguration<GeolocatorCommand> configuration,
			@Local Software77GeolocationService software77GeolocationService) {

		configuration.add("Software77Geolocation", new Software77GeolocatorCommand(software77GeolocationService));
	}

	@Contribute(HibernateEntityPackageManager.class)
	public static void contributeHibernateEntityPackageManager(Configuration<String> configuration) {
		configuration.add("com.tapestrify.geolocation.dom");
	}
	
}
