package com.blog.web.show.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.web.entity.Classification;
import com.blog.web.show.dao.interfaces.IclassificationDao;
import com.blog.web.show.service.interfaces.IclassificationServise;

@Service("classificationServise")
public class classificationServise implements IclassificationServise {
	
	@Autowired
	private IclassificationDao classificationDao;
	
	@Override
	public List<Map<String,Object>> findByUserId(int userId) {
		return classificationDao.findByUserId(userId);
	}

}
