package com.zeugor.jdbcSample1.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zeugor.jdbcSample1.db.manager.BookManager;
import com.zeugor.jdbcSample1.db.pojo.Book;

public class Main {
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String dbName = "jdbcSamples";
	private static String user = "user";
	private static String password = "user";

	static private Connection getConnection(String url, String dbName, String user, String password) throws SQLException {
		/*
		 * In previous versions of JDBC, to obtain a connection, you first had to load your JDBC driver by calling the method Class.forName.
		 * Any JDBC 4.0 drivers that are found in your class path are automatically loaded.
		 */
		Connection conn = DriverManager.getConnection(url + dbName, user, password);
		if (!conn.isClosed()) {
			System.out.println("Db connection working...");
		}
		return conn;
	}

	public static void main(String... arg) {
		Connection conn = null;
		try {
			conn = getConnection(url, dbName, user, password);

			if (!conn.isClosed()) {
				/* testing examples */

				// Publisher publisher = PublisherManager.getPublisher(0, conn);
				// System.out.println(publisher);
				Book book = BookManager.getBook(0, conn);
				System.out.println(book);
				// BookManager.updateBook(Integer.toString(0), "tituloAle2", conn);
				// BookManager.insertBook(Integer.toString(9), "titleZZZ", Integer.toString(0), conn);
				// BookManager.deleteBook(9, conn);
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