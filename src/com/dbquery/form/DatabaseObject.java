package com.dbquery.form;

public class DatabaseObject {
	
	private int id;
	private String name;
	private String email;
	
	
	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public DatabaseObject(int id,String name,String email) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.email = email;
		this.name = name;
	}
	public DatabaseObject(String name,String email) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.name = name;
	}
}
