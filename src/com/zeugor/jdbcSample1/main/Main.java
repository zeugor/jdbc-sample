package com.zeugor.jdbcSample1.main;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.zeugor.jdbcSample1.db.manager.BookManager;

public class Main {

	static private Connection getConnection(String url, String dbName, String user, String password, String driver) throws SQLException {
		Connection conn = null;

		try {
			Class.forName(driver).newInstance();
			conn = (Connection) DriverManager.getConnection(url + dbName, user, password);

			if (!conn.isClosed()) {
				System.out.println("Db connection working...");
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void main(String... arg) {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "jdbcSamples";
		String user = "user";
		String password = "user";
		String driver = "com.mysql.jdbc.Driver";

		Connection conn = null;
		try {
			conn = getConnection(url, dbName, user, password, driver);

			if (!conn.isClosed()) {
				// Publisher publisher = PublisherManager.getPublisher(0, conn);
				// System.out.println(publisher);
				// Book book = BookManager.getBook(0, conn);
				// System.out.println(book);
				// BookManager.updateBook(Integer.toString(0), "tituloAle2", conn);
				// BookManager.insertBook(Integer.toString(9), "titleZZZ", Integer.toString(0), conn);
				BookManager.deleteBook(9, conn);
			}

			conn.close();
		} catch (SQLException e) {
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
	}
}