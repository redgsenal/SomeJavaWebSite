package com.site.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

import com.site.sys.X;

public class UtilityProperties {

	protected static String propertyFilePath = "/WEB-INF/properties/site.properties";
	protected static Properties props = null;
	private static Properties loadPropertyFile(HttpServlet sc, String propertyFilePath){
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(sc.getServletContext().getRealPath(propertyFilePath)));
			X.log("init props - ".concat(propertyFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

	protected static String readProperty(HttpServlet sc, String attrName, String propertyFilePath){
		if (props == null){
			props = loadPropertyFile(sc, propertyFilePath);
		}
		if (props != null){
			return props.getProperty(attrName);
		}
		return "";
	}
}
