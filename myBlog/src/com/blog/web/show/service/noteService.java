	package com.blog.web.show.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.web.entity.Note;
import com.blog.web.show.dao.interfaces.InoteDao;
import com.blog.web.show.service.interfaces.InoteService;
@Service("noteService")
public class noteService implements InoteService {
	
	@Autowired
	private InoteDao notedao;
	
	@Override
	public List<Map<String,Object>> findByUserId(int userId) throws Exception {
		return notedao.findByUserId(userId);
	}
	
	@Override
	public Note findById(int id)throws Exception{
		return notedao.findById(id);
	}

	@Override
	public List<Map<String,Object>> findPage(int userId, int classificationId, int categoryId,String searchKey,int pageSize) throws Exception {
		return notedao.findPage(userId, classificationId, categoryId,searchKey,pageSize);
	}

	@Override
	public int modifyTraffic(int id) throws Exception {
		return notedao.modifyTraffic(id);
	}

	@Override
	public long findSize(int userId) throws Exception {
		return notedao.findSize(userId);
	}
	

}
