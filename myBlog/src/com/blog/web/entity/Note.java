package com.blog.web.entity;

import java.sql.Timestamp;

public class Note {
	
	private int id;
	private String noteName;
	private String noteValue;
	private int classificationId;
	private int categoryId;
	private int userId;
	private long traffic;
	private String description;
	private Timestamp createTime;
	private Timestamp modifyTime;
	public Note() {
		super();
	}


	public Note(int id, String noteName, String noteValue, int classificationId, int categoryId, int userId,
			long traffic, String description, Timestamp createTime, Timestamp modifyTime) {
		super();
		this.id = id;
		this.noteName = noteName;
		this.noteValue = noteValue;
		this.classificationId = classificationId;
		this.categoryId = categoryId;
		this.userId = userId;
		this.traffic = traffic;
		this.description = description;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public String getNoteValue() {
		return noteValue;
	}
	public void setNoteValue(String noteValue) {
		this.noteValue = noteValue;
	}
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getClassificationId() {
		return classificationId;
	}


	public void setClassificationId(int classificationId) {
		this.classificationId = classificationId;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public long getTraffic() {
		return traffic;
	}


	public void setTraffic(long traffic) {
		this.traffic = traffic;
	}


	@Override
	public String toString() {
		return "Note [id=" + id + ", noteName=" + noteName + ", noteValue=" + noteValue + ", classificationId="
				+ classificationId + ", categoryId=" + categoryId + ", userId=" + userId + ", traffic=" + traffic
				+ ", description=" + description + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
	}



	
}
