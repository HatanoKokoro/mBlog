package com.blog.web.admin.service.interfaces;

import java.util.List;
import java.util.Map;

public interface IadminClassificationService {
	
	public List<Map<String,Object>> findByUserId(int userId) throws Exception;	
}
