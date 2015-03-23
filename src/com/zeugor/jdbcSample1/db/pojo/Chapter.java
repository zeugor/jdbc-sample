package com.zeugor.jdbcSample1.db.pojo;

public class Chapter {
	private int index;
	private String title;

	public int getIndex() {
		return index;
	}

	public String getTitle() {
		return title;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return ">> chapter[index: " + index + ", title: " + title + "]";
	}
}
