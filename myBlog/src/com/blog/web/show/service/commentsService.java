package com.blog.web.show.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.web.show.dao.interfaces.IcommentsDao;
import com.blog.web.show.service.interfaces.IcommentsService;

public class commentsService implements IcommentsService {
	
	@Autowired
	private IcommentsDao commentsDao;
	
	@Override
	public int getComments(int noteId) {
		return commentsDao.getComments(noteId);
	}

}
