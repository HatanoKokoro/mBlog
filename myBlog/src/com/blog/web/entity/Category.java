package com.blog.web.entity;

public class Category {
	
	private int id;
	private String categoryName;
	private int userId;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Category(int id, String categoryName, int userId) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.userId = userId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", userId=" + userId + "]";
	}
	
	

}
