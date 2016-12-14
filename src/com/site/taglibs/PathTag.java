package com.site.taglibs;

public class PathTag extends HttpServletTag {
	public String getBaseUrl() {
		if (req != null) {
			String url = req.getRequestURL().toString();
			String uri = req.getRequestURI().toString();
			return url.substring(0, (url.length() - uri.length())).concat(req.getContextPath());
		}
		return "";
	}
}
