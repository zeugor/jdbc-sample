package com.zeugor.jdbcSample1.db.pojo;

import java.util.List;

public class Book {
	private String isbn;
	private String name;
	private Publisher publisher;
	private List<Chapter> chapters;

	public String getIsbn() {
		return isbn;
	}

	public String getName() {
		return name;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	@Override
	public String toString() {
		String res = ">> book[isbn: " + isbn + ", name: " + name;

		if (publisher != null) {
			res += ", publisher: " + publisher;
		}

		if (chapters != null) {
			res += ", list<chapter>: ";

			for (Chapter chapter : chapters) {
				res += chapter;
			}
		}
		return res;
	}
}
