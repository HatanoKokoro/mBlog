package com.blog.web.admin.service.interfaces;

import java.util.Map;

import com.blog.web.entity.User;

public interface IuserService {
	
	public abstract User Login(Map map)throws Exception;
}
	