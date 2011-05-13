/**
 * 
 */
package com.tapestrify.core.services.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.tapestrify.core.services.DownloadService;

/**
 * @author jmayaalv
 * 
 */
public class DownloadServiceImpl implements DownloadService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tapestrify.core.services.DownloadService#download(java.net.URL,
	 * java.io.File)
	 */
	@Override
	public File download(URL url, File destDir) throws IOException {
		File destFile = new File(destDir, url.getPath());
		if(destFile.exists()){
			FileUtils.deleteQuietly(destFile);
		}
		
		URLConnection urlc = url.openConnection();
		InputStream is = new BufferedInputStream(urlc.getInputStream());
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destFile));
		IOUtils.copy(is, os);
		is.close();
		os.close();
		return destFile;

	}

}
