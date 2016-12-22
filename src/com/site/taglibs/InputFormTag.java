package com.site.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;

public class InputFormTag extends InputBaseTag {
	
	private String actionAttr = null;
	private String methodAttr = null;
	
	public void setActionAttr(String actionAttr) {
		this.actionAttr = actionAttr;
	}

	public void setMethodAttr(String methodAttr) {
		this.methodAttr = methodAttr;
	}

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer sb = addBaseAttr("form");
		concatAttr(sb, "action", actionAttr);
		methodAttr = methodAttr == null || methodAttr.isEmpty() ? "GET" : "POST";
		concatAttr(sb, "method", methodAttr);
		sb.append("/>");
		print(sb.toString());
	}
}
