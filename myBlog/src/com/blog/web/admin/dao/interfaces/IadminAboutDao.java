package com.blog.web.admin.dao.interfaces;

import java.util.List;
import java.util.Map;

import org.apache.catalina.util.MD5Encoder;

import com.blog.web.entity.Essays;

public interface IadminAboutDao {
	
	public int AddAbout(Map map) throws Exception;
	
	public List<Map<String, Object>> findByUserId(int userId) throws Exception;

	public Map<String, Object> findById(int id) throws Exception;
	
	public int ModifyAbout(Map map) throws Exception;

	public int del(int id) throws Exception;
	
}
