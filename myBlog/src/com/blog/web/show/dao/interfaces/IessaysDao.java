package com.blog.web.show.dao.interfaces;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.blog.web.entity.Note;

public interface IessaysDao {
	
	public List<Map<String,Object>> findByUserId(int userId)throws Exception;

	public List<Map<String,Object>> findPage(@Param("userId") int userId,@Param("pageSize")int pageSize)throws Exception;
	
	public long findSize(int userId)throws Exception;
}
