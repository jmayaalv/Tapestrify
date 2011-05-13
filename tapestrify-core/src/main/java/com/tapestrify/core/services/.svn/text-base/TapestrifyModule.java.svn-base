package com.tapestrify.core.services;

import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;

import com.tapestrify.core.TapestrifyCoreConstants;
import com.tapestrify.core.services.impl.DownloadServiceImpl;
import com.tapestrify.core.services.impl.ZipServiceImpl;

public class TapestrifyModule {

	public static void bind(ServiceBinder binder) {
		binder.bind(DownloadService.class, DownloadServiceImpl.class);
		binder.bind(ZipService.class, ZipServiceImpl.class);
	}
	
	public static void contributeFactoryDefaults(MappedConfiguration<String, String> configuration) {
		configuration.add(TapestrifyCoreConstants.Symbols.DOWNLOAD_DIRECTORY, System.getProperty("java.io.tmpdir"));
	}

}
