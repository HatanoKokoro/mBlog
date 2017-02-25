package com.blog.web.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.web.admin.dao.interfaces.IadminCategoryDao;
import com.blog.web.admin.service.interfaces.IadminCategoryService;

@Service("adminCategoryService")
public class adminCategoryService implements IadminCategoryService {
	
	@Autowired
	private IadminCategoryDao adminCategoryDao;
	
	@Override
	public List<Map<String, Object>> findByUserId(int userId) throws Exception{
		return adminCategoryDao.findByUserId(userId);
	}

}
