package com.site.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;

public class InputEntryTag extends InputBaseTag {

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer sb = addBaseAttr("input");
		sb.append("/>");
		print(sb.toString());
	}
}
