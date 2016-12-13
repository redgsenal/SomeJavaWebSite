package com.site.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

import com.site.sys.X;

public class UtilityProperties {

	protected static Properties props = null;
	protected static final String propertyFilePath = null;
	
	protected static Properties loadPropertyFile(HttpServlet sc, String propertyFilePath){
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(sc.getServletContext().getRealPath(propertyFilePath)));
			X.log("init props - ".concat(propertyFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

	protected static String readProperty(Properties props, HttpServlet sc, String attrName, String propertyFilePath){
		X.log("read property ".concat(propertyFilePath));
		if (props == null){
			props = loadPropertyFile(sc, propertyFilePath);
		}
		if (props != null){
			return props.getProperty(attrName);
		}
		return "";
	}
	
	protected String getPropertyValue(HttpServlet sc, String attrName, String propertyFilePath){
		return readProperty(initProperties(sc), sc, attrName, propertyFilePath);
	}
	
	protected Properties initProperties(HttpServlet sc){
		// implements somewhere
		return null;
	}
}
