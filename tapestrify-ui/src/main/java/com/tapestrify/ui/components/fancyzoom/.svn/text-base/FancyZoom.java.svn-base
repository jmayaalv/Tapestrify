package com.tapestrify.ui.components.fancyzoom;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import(library = { "FancyZoom.js", "${tapestry.scriptaculous}/effects.js", "${tapestry.scriptaculous}/prototype.js" }, stylesheet = "FancyZoom.css")
public class FancyZoom {

	@Parameter(allowNull = false, required = true, defaultPrefix = BindingConstants.LITERAL)
	private String element;

	@Environmental
	public JavaScriptSupport javaScriptSupport;

	public void afterRender(MarkupWriter writer) {
		this.javaScriptSupport.addScript("FancyZoomBox.directory = '.';");
		this.javaScriptSupport.addScript("new FancyZoom($('%s', {images:'.'}));", this.element);
	}
}
