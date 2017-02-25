package com.blog.web.admin.service.interfaces;

import java.util.List;
import java.util.Map;

import com.blog.web.entity.Essays;
import com.blog.web.entity.Note;

public interface IadminAboutService {
	
	public List<Map<String,Object>> findByUserId(int userId) throws Exception;
	
	public Map<String,Object> findById(int id) throws Exception;
	
	public int AddAbout(Map map) throws Exception;
	
	public int ModifyAbout(Map map) throws Exception;
	
	public int del(int id) throws Exception;
}
