package com.blog.web.admin.service.interfaces;

import java.util.List;
import java.util.Map;

import com.blog.web.entity.Essays;
import com.blog.web.entity.Note;

public interface IadminEssaysService {
	
	public List<Map<String,Object>> AllEssays() throws Exception;
	
	public int AddEssays(Essays essays) throws Exception;
}
