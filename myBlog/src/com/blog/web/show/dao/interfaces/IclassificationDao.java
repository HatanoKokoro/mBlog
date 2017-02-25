package com.blog.web.show.dao.interfaces;

import java.util.List;
import java.util.Map;

import com.blog.web.entity.Classification;

public interface IclassificationDao {
	
	public List<Map<String,Object>> findByUserId(int userId);
	
}
