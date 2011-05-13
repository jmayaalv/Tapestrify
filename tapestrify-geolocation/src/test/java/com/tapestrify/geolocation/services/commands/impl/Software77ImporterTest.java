/**
 * 
 */
package com.tapestrify.geolocation.services.commands.impl;

import java.io.File;
import java.io.FileNotFoundException;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tapestrify.core.services.DownloadService;
import com.tapestrify.core.services.ZipService;
import com.tapestrify.geolocation.services.Software77GeolocationService;

/**
 * @author jmayaalv
 * 
 */
public class Software77ImporterTest {
	
	private static final String TEST_CSV = "IpToCountry.csv";
	
	private Software77Importer software77Importer;
	private DownloadService mockedDownloadService;
	private ZipService mockedZipService;
	private Software77GeolocationService mockedSoftware77GeolocationService;

	@BeforeMethod
	public void setup() {
		this.mockedDownloadService = Mockito.mock(DownloadService.class);
		this.mockedZipService = Mockito.mock(ZipService.class);
		this.mockedSoftware77GeolocationService = Mockito.mock(Software77GeolocationService.class);
		this.software77Importer = new Software77Importer(mockedDownloadService, mockedZipService, mockedSoftware77GeolocationService, System
				.getProperty("java.io.tmpdir"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void importFileTest() throws FileNotFoundException {
		File inputFile = new File(getClass().getResource(TEST_CSV).getFile());
		this.software77Importer.importCSVFile(inputFile);
		Mockito.verify(this.mockedSoftware77GeolocationService).update(Mockito.anyList());
	}

}
