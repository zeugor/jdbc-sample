package com.zeugor.jdbcSample1.db.pojo;

public class Publisher {
	private String code;
	private String name;

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return ">> publisher[code: " + code + ", name: " + name + "]";
	}
}
