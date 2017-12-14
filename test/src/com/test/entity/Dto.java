package com.test.entity;

import java.io.Serializable;

public class Dto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2388260890925954771L;
	
	private String name;
	private String id;
	private String age;
	public Dto(String name, String id, String age){
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public Dto(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	
}
