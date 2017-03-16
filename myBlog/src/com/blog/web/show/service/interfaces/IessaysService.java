package com.blog.web.show.service.interfaces;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.blog.web.entity.Note;

public interface IessaysService {
	
	public List<Map<String,Object>> findByUserId(int userId)throws Exception;
	
	public List<Map<String,Object>> findPage(int userId,int pageSize)throws Exception;
	
	public long findSize(int userId)throws Exception;
	
}
