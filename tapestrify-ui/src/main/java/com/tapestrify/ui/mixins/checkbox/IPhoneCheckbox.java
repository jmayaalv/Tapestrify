package com.tapestrify.ui.mixins.checkbox;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.corelib.components.Checkbox;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.internal.util.InternalUtils;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import(library = "IPhoneCheckbox.js", stylesheet = "IPhoneCheckbox.css")
public class IPhoneCheckbox {

	@Parameter(required = false, allowNull = false, defaultPrefix = BindingConstants.MESSAGE)
	private String checkedLabel;

	@Parameter(required = false, allowNull = false, defaultPrefix = BindingConstants.MESSAGE)
	private String uncheckedLabel;

	@Inject
	private ComponentResources componentResources;

	@Inject
	private JavaScriptSupport javaScriptSupport;

	void afterRender() {
		Checkbox container = (Checkbox) this.componentResources.getContainer();
		JSONObject params = getParametersJSON();
		this.javaScriptSupport.addScript("new iPhoneStyle($('%s'), %s);", container.getClientId(), params != null ? params.toCompactString() : "null");
	}

	private JSONObject getParametersJSON() {
		JSONObject params = null;
		if (InternalUtils.isBlank(this.checkedLabel) && InternalUtils.isBlank(this.uncheckedLabel)) {
			return params;
		}

		params = new JSONObject();
		if (InternalUtils.isNonBlank(this.checkedLabel)) {
			params.put("checkedLabel", this.checkedLabel);
		}

		if (InternalUtils.isNonBlank(this.uncheckedLabel)) {
			params.put("uncheckedLabel", this.uncheckedLabel);
		}
		return params;
	}

}
