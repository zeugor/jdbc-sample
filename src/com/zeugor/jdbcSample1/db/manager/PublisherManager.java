package com.zeugor.jdbcSample1.db.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zeugor.jdbcSample1.db.pojo.Publisher;

public class PublisherManager {

	public void insertPublisher(Publisher publisher) {

	}

	public static Publisher getPublisher(int idPublisher, Connection conn) throws SQLException {
		Publisher publisher = null;

		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM publisher WHERE code = ?");
		stmt.setString(1, Integer.toString(idPublisher));

		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String name = rs.getString("name");
			publisher = new Publisher();
			publisher.setCode(Integer.toString(idPublisher));
			publisher.setName(name);
		}
		rs.close();
		stmt.close();

		return publisher;
	}

	public void updatePublisher(Publisher publisher) {

	}

	public void deletePublisher(int idPublisher) {

	}
}
