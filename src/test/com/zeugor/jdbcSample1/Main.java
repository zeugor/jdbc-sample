package com.zeugor.jdbcSample1;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class Main {
	static private Connection getConnection(String url, String dbName, String user, String password, String driver) {
		Connection conn = null;	
		try {
			Class.forName(driver).newInstance();
			conn = (Connection) DriverManager.getConnection(url + dbName, user, password);

			if (!conn.isClosed()) {
				System.out.println("Db connection working...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static void main(String... arg) {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "jdbcSamples";
		String user = "user";
		String password = "user";
		String driver = "com.mysql.jdbc.Driver";	


		Connection conn = getConnection(url, dbName, user, password, driver);
	}
}