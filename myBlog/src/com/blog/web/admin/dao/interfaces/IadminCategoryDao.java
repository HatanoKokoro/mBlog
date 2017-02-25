package com.blog.web.admin.dao.interfaces;

import java.util.List;
import java.util.Map;

public interface IadminCategoryDao {
	
	public List<Map<String,Object>> findByUserId(int userId) throws Exception;

}
