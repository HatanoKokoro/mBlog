package com.blog.web.entity;

import java.sql.Timestamp;

public class Essays {
	
	private int essaysId;
	private String essaysValue;
	private int userId;
	private Timestamp createTime;
	private Timestamp modifyTime;
	public Essays() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Essays(int essaysId, String essaysValue, int userId, Timestamp createTime, Timestamp modifyTime) {
		super();
		this.essaysId = essaysId;
		this.essaysValue = essaysValue;
		this.userId = userId;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}
	public int getEssaysId() {
		return essaysId;
	}
	public void setEssaysId(int essaysId) {
		this.essaysId = essaysId;
	}
	public String getEssaysValue() {
		return essaysValue;
	}
	public void setEssaysValue(String essaysValue) {
		this.essaysValue = essaysValue;
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
	@Override
	public String toString() {
		return "Essays [essaysId=" + essaysId + ", essaysValue=" + essaysValue + ", userId=" + userId + ", createTime="
				+ createTime + ", modifyTime=" + modifyTime + "]";
	}
	
	
	
}
