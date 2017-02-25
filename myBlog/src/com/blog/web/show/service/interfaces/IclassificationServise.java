package com.blog.web.show.service.interfaces;

import java.util.List;
import java.util.Map;

import com.blog.web.entity.Classification;

public interface IclassificationServise {
	
	public List<Map<String,Object>> findByUserId(int userId);
	
}
