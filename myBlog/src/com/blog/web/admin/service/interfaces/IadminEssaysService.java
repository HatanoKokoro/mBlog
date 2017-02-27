package com.blog.web.admin.service.interfaces;

import java.util.List;
import java.util.Map;

import com.blog.web.entity.Essays;
import com.blog.web.entity.Note;

public interface IadminEssaysService {
	
	public int AddEssays(Essays essays) throws Exception;
	
	public int del(int id) throws Exception;
	
	public List<Map<String,Object>> pageList(int UserId,int pageSize,int pageIndex) throws Exception;
	
	public long pageTotalCount(int UserId) throws Exception;
	
	public Map<String,Object> findById(int id) throws Exception;
	
	public int modify(Map<String,Object> map) throws Exception;
}
