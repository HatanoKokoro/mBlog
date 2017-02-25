package com.blog.web.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.web.admin.dao.interfaces.IadminAboutDao;
import com.blog.web.admin.service.interfaces.IadminAboutService;
@Service("adminAboutService")
public class adminAboutService implements IadminAboutService {
	
	@Autowired
	private IadminAboutDao adminAboutDao;
	
	@Override
	public int AddAbout(Map map) throws Exception{
		return adminAboutDao.AddAbout(map);
	}

	@Override
	public List<Map<String, Object>> findByUserId(int userId) throws Exception {
		return adminAboutDao.findByUserId(userId);
	}

	@Override
	public Map<String, Object> findById(int id) throws Exception {
		return adminAboutDao.findById(id);
	}

	@Override
	public int ModifyAbout(Map map) throws Exception {
		return adminAboutDao.ModifyAbout(map);
	}

	@Override
	public int del(int id) throws Exception {
		return adminAboutDao.del(id);
	}
	

}
