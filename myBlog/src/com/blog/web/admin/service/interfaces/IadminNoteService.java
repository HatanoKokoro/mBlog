package com.blog.web.admin.service.interfaces;

import java.util.List;
import java.util.Map;

import com.blog.web.entity.Note;

public interface IadminNoteService {
	
	public int AddNote(Note note) throws Exception;
	
	public List<Map<String,Object>> findPage(int userId,int classificationId ,int categoryId,String searchKey,int pageSize) throws Exception;
	
	public int del(int id) throws Exception;
	
	public List<Map<String,Object>> pageList(int UserId,int pageIndex,int pageSize) throws Exception;
	
	public long pageTotalCount(int UserId) throws Exception;
	
	public Map<String,Object> findById(int id) throws Exception;
	
	public int modify(Map<String,Object> map) throws Exception;
}
