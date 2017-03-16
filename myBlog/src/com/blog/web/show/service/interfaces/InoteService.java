package com.blog.web.show.service.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;

import com.blog.web.entity.Note;

public interface InoteService {
	
	public List<Map<String,Object>> findByUserId(int userId)throws Exception;
	
	public Note findById(int id)throws Exception;
	
	public List<Map<String,Object>> findPage(int userId,int classificationId ,int categoryId,String searchKey,int pageSize) throws Exception;
	
	public int modifyTraffic(int id)throws Exception;
	
	public long findSize(int userId)throws Exception;
}
