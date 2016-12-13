package com.site.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import com.site.utils.DBProperties;

public class Conn {
	public static Connection getCon(HttpServlet sc) {
		Connection con = null;
		try {
			Class.forName(DBProperties.getDriverName(sc));
			con = DriverManager.getConnection(DBProperties.getDBUrl(sc),DBProperties.getDBUserName(sc),DBProperties.getDBUserPassword(sc));			 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
