/**
 * 
 */
package com.tapestrify.core.services.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.tapestrify.core.services.DownloadService;

/**
 * @author jmayaalv
 * 
 */
public class DownloadServiceImplTest {

	
	/**
	 * Might be better to have a local address not to depend of internet to run the tests
	 */
	private static final String DOWNLOAD_URL = "http://www.google.pl/index.html";

	@Test
	public void downloadTest() throws IOException {
		URL url = new URL(DOWNLOAD_URL);
		DownloadService downloadService = new DownloadServiceImpl();
		File tempDir = new File(System.getProperty("java.io.tmpdir"));
		File file = downloadService.download(url, tempDir);

		Assert.assertTrue(file.exists());
		FileUtils.deleteQuietly(file);
	}

}
