package com.blog.web.admin.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.web.admin.dao.interfaces.IadminUserDao;
import com.blog.web.admin.service.interfaces.IuserService;
import com.blog.web.entity.User;

@Service("userService")
public class adminUserService implements IuserService{
	
	@Autowired
	private IadminUserDao userdao;
	
	public User Login(Map map)throws Exception{
		return userdao.Login(map);
	}
}
