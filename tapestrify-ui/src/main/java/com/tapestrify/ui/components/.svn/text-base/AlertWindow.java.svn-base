package com.tapestrify.ui.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.internal.util.InternalUtils;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import(library = { "q.window.js" })
public class AlertWindow {

	@Parameter(required = true, allowNull = false, defaultPrefix = BindingConstants.MESSAGE)
	private String message;

	@Parameter(required = false, allowNull = false, value = "", defaultPrefix = BindingConstants.MESSAGE)
	private String title;

	@Parameter(required = true, allowNull = false, defaultPrefix = BindingConstants.LITERAL)
	private String element;

	@Parameter(required = true, allowNull = false, defaultPrefix = BindingConstants.LITERAL)
	private String event;

	@Environmental
	private JavaScriptSupport javaScriptSupport;

	public void afterRender() {
		this.javaScriptSupport.addScript("$('%s').observe('%s', function(e){new Q.Alert('%s', '%s')});", this.element, this.event, this.title, this.message);
	}

}
