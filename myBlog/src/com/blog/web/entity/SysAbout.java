package com.blog.web.entity;

import java.sql.Timestamp;

public class SysAbout {
	
	private int id;
	private String content;
	private String title;
	private int status;
	private int userId;
	private Timestamp createTime;
	private Timestamp modifyTime;
	
	public SysAbout() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public SysAbout(int id, String content, String title, int status, int userId, Timestamp createTime,
			Timestamp modifyTime) {
		super();
		this.id = id;
		this.content = content;
		this.title = title;
		this.status = status;
		this.userId = userId;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	@Override
	public String toString() {
		return "SysAbout [id=" + id + ", content=" + content + ", title=" + title + ", status=" + status + ", userId="
				+ userId + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
	}



	
}
