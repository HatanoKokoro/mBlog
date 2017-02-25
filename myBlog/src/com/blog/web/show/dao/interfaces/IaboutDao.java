package com.blog.web.show.dao.interfaces;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.blog.web.entity.Note;

public interface IaboutDao {
	
	public List<Map<String,Object>> findByUserId(int userId)throws Exception;

	public Note findById(int id)throws Exception;
	
}
