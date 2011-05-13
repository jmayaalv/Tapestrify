package com.tapestrify.core.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public final class FileUtils {

	public static File removeLinesStartingWith(File inputFile, String token) throws IOException {
		if (!inputFile.isFile()) {
			throw new FileNotFoundException("Parameter is not an existing file");
		}

		//Construct the new file that will later be renamed to the original filename. 
		File newFile = new File(inputFile.getParent(), inputFile.getName().replace(".","-temp."));

		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		PrintWriter pw = new PrintWriter(new FileWriter(newFile));

		String line = null;

		//Read from the original file and write to the new 
		//unless content matches data to be removed.
		while ((line = br.readLine()) != null) {

			if (!line.trim().startsWith(token)) {
				pw.println(line);
				pw.flush();
			}
		}
		pw.close();
		br.close();

		//Delete the original file

		org.apache.commons.io.FileUtils.deleteQuietly(inputFile);

		//Rename the new file to the filename the original file had.
		if (!newFile.renameTo(inputFile))
			throw new IOException("Could not rename file");
		
		return inputFile;

	}

}
