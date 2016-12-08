package com.site.utils;

import javax.servlet.http.HttpServlet;

import com.site.global.Global;

public class Utility {
	
	public static String getSiteName(String name){
		if (name == null)
			return Global.SITE_NAME;
		return name.isEmpty() ? Global.SITE_NAME : name;
	}
	
	public static String getSiteDescription(String value){
		if (value == null)
			return Global.SITE_DESCRIPTION;
		return value.isEmpty() ? Global.SITE_DESCRIPTION : value;
	}
	
	public static String getSiteName(HttpServlet sc){
		return getSiteName((String) sc.getServletContext().getAttribute(Global.ATTR_SITE_NAME));
	}
	
	public static String getSiteDescription(HttpServlet sc){
		return getSiteDescription((String) sc.getServletContext().getAttribute(Global.ATTR_SITE_DESCRIPTION));		
	}
}
