package com.site.utils;

import javax.servlet.http.HttpServlet;

public class DBProperties extends UtilityProperties {

	protected static String propertyFilePath = "/WEB-INF/properties/site.properties";
	
	public static String getDriverName(HttpServlet sc){
		return readProperty(sc, "db_driver", propertyFilePath);
	}
	
	public static String getDBUrl(HttpServlet sc){
		return readProperty(sc, "db_url", propertyFilePath);
	}
	
	public static String getDBUserName(HttpServlet sc){
		return readProperty(sc, "db_username", propertyFilePath);
	}
	
	public static String getDBUserPassword(HttpServlet sc){
		return readProperty(sc, "db_password", propertyFilePath);
	}
}
