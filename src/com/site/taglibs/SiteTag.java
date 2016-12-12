package com.site.taglibs;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.*;
import java.io.*;

public class SiteTag extends SimpleTagSupport {
	protected HttpServletRequest req;

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public String getBaseUrl() {
		if (req != null) {
			String url = req.getRequestURL().toString();
			String uri = req.getRequestURI().toString();
			return url.substring(0, (url.length() - uri.length())).concat(req.getContextPath());
		}
		return "";
	}

	public void doTag() throws JspException, IOException {
		getJspContext().getOut().println("empty");
	}
	
	public void print(String s) throws IOException{
		getJspContext().getOut().println(s);
	}
}
