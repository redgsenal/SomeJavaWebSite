package com.site.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

import com.site.global.Attribute;
import com.site.sys.X;

public class Utility {

	private static Properties props = null;

	private static String SiteAttr(HttpServlet sc, String attrName){
		if (props == null){
			props = new Properties();
			try {
				props.load(new FileInputStream(sc.getServletContext().getRealPath("/WEB-INF/properties/site.properties")));
				X.log("init props");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return props.getProperty(attrName);
	}
	
	public static String getSiteName(HttpServlet sc){
		return SiteAttr(sc, Attribute.ATTR_SITE_NAME);
	}
	
	public static String getSiteTitle(HttpServlet sc){
		return SiteAttr(sc, Attribute.ATTR_SITE_TITLE);
	}
	
	public static String getSiteDescription(HttpServlet sc){
		return SiteAttr(sc, Attribute.ATTR_SITE_DESCRIPTION);		
	}
	
	public static String getSiteShareImage(HttpServlet sc){
		return SiteAttr(sc, Attribute.ATTR_SITE_IMAGE);
	}
}
