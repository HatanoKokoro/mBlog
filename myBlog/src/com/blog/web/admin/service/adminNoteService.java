package com.blog.web.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.web.admin.dao.interfaces.IadminNoteDao;
import com.blog.web.admin.service.interfaces.IadminNoteService;
import com.blog.web.entity.Note;
@Service("adminNoteService")
public class adminNoteService implements IadminNoteService{
	
	@Autowired
	private IadminNoteDao adminNoteDao;
	
	public int AddNote(Note note) throws Exception{
		return adminNoteDao.AddNote(note);
	}
	
	@Override
	public List<Map<String,Object>> findPage(int userId, int classificationId, int categoryId,String searchKey,int pageSize) throws Exception {
		return adminNoteDao.findPage(userId, classificationId, categoryId,searchKey,pageSize);
	}

	@Override
	public int del(int id) throws Exception{
		return adminNoteDao.del(id);
	}

	@Override
	public List<Map<String, Object>> pageList(int UserId,int pageIndex,int pageSize) throws Exception{
		return adminNoteDao.pageList(UserId,pageIndex,pageSize);
	}

	@Override
	public long pageTotalCount(int UserId) throws Exception{
		return adminNoteDao.pageTotalCount(UserId);
	}

	@Override
	public Map<String, Object> findById(int id) throws Exception{
		return adminNoteDao.findById(id);
	}

	@Override
	public int modify(Map<String, Object> map) throws Exception {
		return adminNoteDao.modify(map);
	}
	
	
	
}
