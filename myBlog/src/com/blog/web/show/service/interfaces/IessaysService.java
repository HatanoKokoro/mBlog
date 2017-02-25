package com.blog.web.show.service.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;

import com.blog.web.entity.Note;

public interface IessaysService {
	
	public List<Map<String,Object>> findByUserId(int userId)throws Exception;
	
	public Note findById(int id)throws Exception;
	
}
