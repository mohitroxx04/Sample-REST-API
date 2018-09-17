package com.mohit.library;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	
	private int id;
	private String name;
	private int location;
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	
}
