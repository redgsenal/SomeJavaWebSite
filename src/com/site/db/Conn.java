package com.site.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import com.site.utils.DBProperties;

public class Conn {
	public static Connection getCon(HttpServlet sc) {
		Connection con = null;
		DBProperties props = new DBProperties();
		try {
			Class.forName(props.getDriverName(sc));
			con = DriverManager.getConnection(props.getDBUrl(sc),props.getDBUserName(sc),props.getDBUserPassword(sc));			 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
