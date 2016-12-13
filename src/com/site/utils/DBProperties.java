package com.site.utils;

import java.util.Properties;

import javax.servlet.http.HttpServlet;

public class DBProperties extends UtilityProperties {

	private Properties props = null;
	private final String propertyFilePath = "/WEB-INF/properties/database.properties";

	public String getDriverName(HttpServlet sc) {
		return getPropertyValue(sc, "db_driver", propertyFilePath);
	}

	public String getDBUrl(HttpServlet sc) {
		return getPropertyValue(sc, "db_url", propertyFilePath);
	}

	public String getDBUserName(HttpServlet sc) {
		return getPropertyValue(sc, "db_username", propertyFilePath);
	}

	public String getDBUserPassword(HttpServlet sc) {
		return getPropertyValue(sc, "db_password", propertyFilePath);
	}
	
	@Override
	protected Properties initProperties(HttpServlet sc) {
		if (props == null)
			props = loadPropertyFile(sc, propertyFilePath);
		return props;
	}		
}
