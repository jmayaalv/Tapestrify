package com.tapestrify.core.services.impl;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

//TODO: Add more complex zip files
public class ZipServiceImplTest {

	private static final String SIMPlE_ZIP_FILE = "unzipTest.zip";

	@Test
	public void unzipTest() throws IOException {
		File inputFile = new File(getClass().getResource(SIMPlE_ZIP_FILE).getFile());
		File tempDir = new File(System.getProperty("java.io.tmpdir")); 
		File dir = new ZipServiceImpl().unzip(inputFile, tempDir);
		File result = new File(dir, "test.txt");
		Assert.assertTrue(result.exists());
		FileUtils.deleteQuietly(result);
	}

}
