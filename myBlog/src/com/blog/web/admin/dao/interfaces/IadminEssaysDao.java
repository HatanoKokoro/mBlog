package com.blog.web.admin.dao.interfaces;

import java.util.List;
import java.util.Map;

import com.blog.web.entity.Essays;

public interface IadminEssaysDao {
	
	public List<Map<String,Object>> AllEssays() throws Exception;
	
	public int AddEssays(Essays essays) throws Exception;
}
