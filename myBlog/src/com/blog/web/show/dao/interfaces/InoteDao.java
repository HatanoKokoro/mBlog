package com.blog.web.show.dao.interfaces;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.blog.web.entity.Note;

public interface InoteDao {
	
	public List<Map<String,Object>> findByUserId(int userId)throws Exception;

	public Note findById(int id)throws Exception;
	
	public List<Map<String,Object>> findPage(@Param("userId")int userId,@Param("classificationId")int classificationId ,@Param("categoryId")int categoryId,@Param("searchKey")String searchKey,@Param("pageSize")int pageSize) throws Exception;
}
