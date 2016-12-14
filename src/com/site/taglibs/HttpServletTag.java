package com.site.taglibs;

import javax.servlet.http.HttpServletRequest;

public class HttpServletTag extends SimpleTag {
	protected HttpServletRequest req;

	public void setReq(HttpServletRequest req) {
		this.req = req;		
	}	
}
