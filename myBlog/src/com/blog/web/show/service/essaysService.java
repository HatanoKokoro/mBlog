	package com.blog.web.show.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.web.entity.Note;
import com.blog.web.show.dao.interfaces.IessaysDao;
import com.blog.web.show.service.interfaces.IessaysService;
@Service("essaysService")
public class essaysService implements IessaysService {
	
	@Autowired
	private IessaysDao essaysdao;
	
	@Override
	public List<Map<String,Object>> findByUserId(int userId) throws Exception {
		return essaysdao.findByUserId(userId);
	}

	@Override
	public List<Map<String, Object>> findPage(int userId, int pageSize) throws Exception {
		return essaysdao.findPage(userId, pageSize);
	}

	@Override
	public long findSize(int userId) throws Exception {
		return essaysdao.findSize(userId);
	}
	


}
