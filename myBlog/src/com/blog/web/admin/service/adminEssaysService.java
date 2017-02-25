package com.blog.web.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.web.admin.dao.interfaces.IadminEssaysDao;
import com.blog.web.admin.service.interfaces.IadminEssaysService;
import com.blog.web.entity.Essays;
@Service("adminEssaysService")
public class adminEssaysService implements IadminEssaysService {
	
	@Autowired
	private IadminEssaysDao adminEssaysDao;
	
	@Override
	public List<Map<String, Object>> AllEssays() {
		return null;
	}

	@Override
	public int AddEssays(Essays essays) throws Exception{
		return adminEssaysDao.AddEssays(essays) ;
	}

}
