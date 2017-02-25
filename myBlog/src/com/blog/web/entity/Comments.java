package com.blog.web.entity;

import java.sql.Timestamp;

public class Comments {
	
	private int commentsId;
	private String commentsValue;
	private int commentsUser;
	private int noteId;
	private Timestamp createTime;
	private Timestamp modifyTime;
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comments(int commentsId, String commentsValue, int commentsUser, int noteId, Timestamp createTime,
			Timestamp modifyTime) {
		super();
		this.commentsId = commentsId;
		this.commentsValue = commentsValue;
		this.commentsUser = commentsUser;
		this.noteId = noteId;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}
	public int getCommentsId() {
		return commentsId;
	}
	public void setCommentsId(int commentsId) {
		this.commentsId = commentsId;
	}
	public String getCommentsValue() {
		return commentsValue;
	}
	public void setCommentsValue(String commentsValue) {
		this.commentsValue = commentsValue;
	}
	public int getCommentsUser() {
		return commentsUser;
	}
	public void setCommentsUser(int commentsUser) {
		this.commentsUser = commentsUser;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
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
	@Override
	public String toString() {
		return "Comments [commentsId=" + commentsId + ", commentsValue=" + commentsValue + ", commentsUser="
				+ commentsUser + ", noteId=" + noteId + ", createTime=" + createTime + ", modifyTime=" + modifyTime
				+ "]";
	}
	
	

}
