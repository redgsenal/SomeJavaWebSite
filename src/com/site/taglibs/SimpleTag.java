package com.site.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
	}
	
	protected void print(String s) throws IOException{
		getJspContext().getOut().println(s);
	}
	
	protected String concatAttr(StringBuffer sb, String attributeName, String v) throws IOException{
		if (v == null || v.isEmpty())
			return "";
		return sb.append(attributeName).append("=\"").append(v).append("\" ").toString();
	}
}
