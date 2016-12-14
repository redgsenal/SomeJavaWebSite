package com.site.utils;

import java.util.Properties;

import javax.servlet.http.HttpServlet;
import com.site.global.Attribute;

public class SiteProperties extends UtilityProperties {
	
	private Properties props = null;
	private static final String propertyFilePath = "/WEB-INF/properties/site.properties";
	
	public String getSiteName(HttpServlet sc){
		return getPropertyValue(sc, Attribute.ATTR_SITE_NAME, propertyFilePath);
	}
	
	public String getSiteTitle(HttpServlet sc){
		return getPropertyValue(sc, Attribute.ATTR_SITE_TITLE, propertyFilePath);
	}
	
	public String getSiteDescription(HttpServlet sc){
		return getPropertyValue(sc, Attribute.ATTR_SITE_DESCRIPTION, propertyFilePath);
	}
	
	public String getSiteShareImage(HttpServlet sc){
		return getPropertyValue(sc, Attribute.ATTR_SITE_IMAGE, propertyFilePath);
	}
	
	@Override
	protected Properties initProperties(HttpServlet sc) {
		if (props == null)
			props = loadPropertyFile(sc, propertyFilePath);
		return props;
	}
	
}
