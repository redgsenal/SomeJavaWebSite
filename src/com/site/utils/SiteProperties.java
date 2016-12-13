package com.site.utils;

import javax.servlet.http.HttpServlet;
import com.site.global.Attribute;

public class SiteProperties extends UtilityProperties {
	protected static String propertyFilePath = "/WEB-INF/properties/site.properties";
	public static String getSiteName(HttpServlet sc){
		return readProperty(sc, Attribute.ATTR_SITE_NAME, propertyFilePath);
	}
	
	public static String getSiteTitle(HttpServlet sc){
		return readProperty(sc, Attribute.ATTR_SITE_TITLE, propertyFilePath);
	}
	
	public static String getSiteDescription(HttpServlet sc){
		return readProperty(sc, Attribute.ATTR_SITE_DESCRIPTION, propertyFilePath);
	}
	
	public static String getSiteShareImage(HttpServlet sc){
		return readProperty(sc, Attribute.ATTR_SITE_IMAGE, propertyFilePath);
	}
}
