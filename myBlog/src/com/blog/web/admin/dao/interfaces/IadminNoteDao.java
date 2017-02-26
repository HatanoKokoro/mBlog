package com.blog.web.admin.dao.interfaces;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.blog.web.entity.Note;

public interface IadminNoteDao {
	
	public List<Map<String,Object>> AllNote() throws Exception;
	
	public int AddNote(Note note) throws Exception;
	
	public List<Map<String,Object>> findPage(@Param("userId")int userId,@Param("classificationId")int classificationId ,@Param("categoryId")int categoryId,@Param("searchKey")String searchKey,@Param("pageSize")int pageSize) throws Exception;
	
	public int del(int id) throws Exception;
	
	public List<Map<String,Object>> pageList(int UserId,int pageSize,int pageIndex) throws Exception;
	
	public long pageTotalCount(int UserId) throws Exception;
}
