package com.blog.web.admin.service.interfaces;

import java.util.List;
import java.util.Map;

public interface IadminCategoryService {
	
	public List<Map<String,Object>> findByUserId(int userId)throws Exception;	
}
