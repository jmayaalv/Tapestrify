package com.tapestrify.core.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

import com.tapestrify.core.services.ZipService;

public class ZipServiceImpl implements ZipService {

	@Override
	public File unzip(File inputFile, File destDir) throws IOException {
		ZipFile zipFile = new ZipFile(inputFile);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		ZipEntry zipEntry;
		while (entries.hasMoreElements()) {
			zipEntry = entries.nextElement();
			if (zipEntry.isDirectory()) {
				(new File(destDir, zipEntry.getName())).mkdirs(); // This is not robust
			} else {
				IOUtils.copy(zipFile.getInputStream(zipEntry), new FileOutputStream(new File(destDir, zipEntry.getName())));
			}
		}
		zipFile.close();
		return destDir;
	}

}
