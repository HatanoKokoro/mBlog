package com.blog.web.entity;

public class Classification {
	
	private int id;
	private String classificationName;
	private int userId;
	public Classification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classification(int id, String classificationName, int userId) {
		super();
		this.id = id;
		this.classificationName = classificationName;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassificationName() {
		return classificationName;
	}
	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Classification [id=" + id + ", classificationName=" + classificationName + ", userId=" + userId + "]";
	}
	
	
	
}
