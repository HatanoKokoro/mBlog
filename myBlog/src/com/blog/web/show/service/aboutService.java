	package com.blog.web.show.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.web.entity.Note;
import com.blog.web.show.dao.interfaces.IaboutDao;
import com.blog.web.show.service.interfaces.IaboutService;
@Service("aboutService")
public class aboutService implements IaboutService {
	
	@Autowired
	private IaboutDao aboutDao;
	
	@Override
	public List<Map<String,Object>> findByUserId(int userId) throws Exception {
		return aboutDao.findByUserId(userId);
	}
	
	@Override
	public Note findById(int id)throws Exception{
		return aboutDao.findById(id);
	}


}
