package com.blog.web.admin.dao.interfaces;

import java.util.Map;

import com.blog.web.entity.User;

public interface IadminUserDao {
	
	public abstract User Login(Map map)throws Exception;
}
