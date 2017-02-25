package com.blog.web.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.web.admin.dao.interfaces.IadminClassificationDao;
import com.blog.web.admin.service.interfaces.IadminClassificationService;

@Service("adminClassificationService")
public class adminClassificationService implements IadminClassificationService {
	
	@Autowired
	private IadminClassificationDao adminClassificationDao;
	
	@Override
	public List<Map<String, Object>> findByUserId(int userId) throws Exception{
		return adminClassificationDao.findByUserId(userId);
	}

}
