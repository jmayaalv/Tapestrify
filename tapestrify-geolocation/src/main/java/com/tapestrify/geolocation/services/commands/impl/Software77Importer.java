package com.tapestrify.geolocation.services.commands.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.tapestrify.core.TapestrifyCoreConstants;
import com.tapestrify.core.services.DownloadService;
import com.tapestrify.core.services.ZipService;
import com.tapestrify.core.utils.FileUtils;
import com.tapestrify.geolocation.dom.Software77Geolocation;
import com.tapestrify.geolocation.services.Software77GeolocationService;
import com.tapestrify.geolocation.services.commands.Importer;

public class Software77Importer implements Importer<URL> {

	private static final String COMMENT_TOKEN = "#";
	private static final String DEST_FILE_NAME = "IpToCountry.csv";
	private final DownloadService downloadService;
	private final ZipService zipService;
	private final Software77GeolocationService software77GeolocationService;
	private final String donwloadFolder;

	/**
	 * @param downloadService
	 * @param zipService
	 * @author jmayaalv
	 */
	public Software77Importer(DownloadService downloadService, ZipService zipService, Software77GeolocationService software77GeolocationService,
			@Inject @Symbol(TapestrifyCoreConstants.Symbols.DOWNLOAD_DIRECTORY) String downloadFolder) {
		super();
		this.downloadService = downloadService;
		this.zipService = zipService;
		this.software77GeolocationService = software77GeolocationService;
		this.donwloadFolder = downloadFolder;
	}

	@Override
	public void importUrl(URL url, boolean removeTempFiles) throws IOException {

		File destDir = new File(this.donwloadFolder);
		File destFile = new File(destDir, DEST_FILE_NAME);

		if (!destFile.exists()) {
			//only downlaod the file if it's not on disc to avoid being blocked by the remote server
			File downloadFile = this.downloadService.download(url, destDir); //download file
			this.zipService.unzip(downloadFile, destDir); //unzip file
		}

		importCSVFile(FileUtils.removeLinesStartingWith(destFile, COMMENT_TOKEN));
		if(removeTempFiles){
			org.apache.commons.io.FileUtils.deleteQuietly(destFile);
		}
	}

	void importCSVFile(File sourceFile) throws FileNotFoundException {
		ColumnPositionMappingStrategy<Software77Geolocation> strat = new ColumnPositionMappingStrategy<Software77Geolocation>();
		strat.setType(Software77Geolocation.class);
		String[] columns = new String[] { "ipFrom", "ipTo", "registry", "assigned", "country", "countryCode", "region" }; // the fields to bind do in your JavaBean
		strat.setColumnMapping(columns);

		CsvToBean<Software77Geolocation> csvToBean = new CsvToBean<Software77Geolocation>();
		CSVReader reader = new CSVReader(new FileReader(sourceFile), ',', '"', 0);

		List<Software77Geolocation> geolocations = csvToBean.parse(strat, reader); //load csv

		//delete existent values 
		this.software77GeolocationService.update(geolocations);
	}

}
