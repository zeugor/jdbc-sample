package com.zeugor.jdbcSample1.db.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zeugor.jdbcSample1.db.pojo.Book;
import com.zeugor.jdbcSample1.db.pojo.Chapter;
import com.zeugor.jdbcSample1.db.pojo.Publisher;

public class BookManager {

	public static void insertBook(String isbn, String bookName, String publisherCode, Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO BOOK (ISBN, NAME, PUBLISHER_CODE) VALUE (?, ?, ?)");
		stmt.setString(1, isbn);
		stmt.setString(2, bookName);
		stmt.setString(3, publisherCode);

		// Returns the numbers of rows affected by the execution of the SQL statement. Use this method to execute SQL statements
		// for which you expect to get a number of rows affected - for example, an INSERT, UPDATE, or DELETE statement.
		int count = stmt.executeUpdate();

		System.out.println(">> Inserted count: " + count);

		stmt.close();
	}

	public static Book getBook(int id, Connection conn) throws SQLException {
		Book book = null;

		// PreparedStatement interface extends the Statement interface
		PreparedStatement stmt = conn.prepareStatement(
				"SELECT book.isbn, book.name as bookName, publisher.code as publisherCode, publisher.name publisherName " +
						"FROM book, publisher " + "" +
						"WHERE isbn = ? AND book.publisher_code like publisher.code;");
		stmt.setString(1, Integer.toString(id));

		// Returns a ResultSet object. Use this method when you expect to get a result set, as you would with a SELECT statement.
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Publisher publisher = new Publisher();
			publisher.setCode(rs.getString("publisherCode"));
			publisher.setName(rs.getString("publisherName"));

			book = new Book();
			book.setIsbn(Integer.toString(id));
			book.setName(rs.getString("bookName"));
			book.setPublisher(publisher);
		}
		rs.close();
		stmt.close();

		List<Chapter> chapters = new ArrayList<Chapter>();

		stmt = conn.prepareStatement("SELECT * FROM CHAPTER WHERE BOOK_ISBN = ?");
		stmt.setString(1, Integer.toString(id));

		rs = stmt.executeQuery();
		while(rs.next()) {
			Chapter chapter = new Chapter();
			chapter.setIndex(rs.getInt("index"));
			chapter.setTitle(rs.getString("title"));
			chapters.add(chapter);
		}
		rs.close();

		book.setChapters(chapters);

		return book;
	}

	public static void updateBook(String isbn, String bookName, Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE BOOK SET NAME = ? WHERE ISBN = ?");
		stmt.setString(1, bookName);
		stmt.setString(2, isbn);

		int count = stmt.executeUpdate();

		System.out.println(">> updated count: " + count);

		stmt.close();
	}

	public static void deleteBook(int id, Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM BOOK WHERE ISBN = ?");
		stmt.setString(1, Integer.toString(id));

		int count = stmt.executeUpdate();

		System.out.println(">> deleted count: " + count);

		stmt.close();
	}
}
