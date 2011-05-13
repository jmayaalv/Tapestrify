package com.tapestrify.ui.services;

import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.services.LibraryMapping;

public class TapestrifyUIModule {

	/**
	 * Specifies where can the module components be found
	 * 
	 * @param configuration
	 * @author jmayaalv
	 */
	public static void contributeComponentClassResolver(Configuration<LibraryMapping> configuration) {
		configuration.add(new LibraryMapping("tapestrify", "com.tapestrify.ui"));
	}

}
