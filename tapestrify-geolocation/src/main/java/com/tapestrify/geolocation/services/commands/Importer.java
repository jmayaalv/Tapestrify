package com.tapestrify.geolocation.services.commands;

import java.io.IOException;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;



/**
 * Specifies databases to import. 
 * Every new database should provided a command with the import process
 * @author jmayaalv
 *
 */
public interface Importer<E> {
	
	@CommitAfter
	public void importUrl(E url, boolean removeTempFiles) throws IOException;

}
