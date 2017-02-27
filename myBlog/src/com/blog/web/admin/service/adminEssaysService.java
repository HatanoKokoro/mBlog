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
	public int AddEssays(Essays essays) throws Exception{
		return adminEssaysDao.AddEssays(essays) ;
	}
	
	@Override
	public int del(int id) throws Exception {
		return adminEssaysDao.del(id);
	}

	@Override
	public List<Map<String, Object>> pageList(int UserId, int pageSize, int pageIndex) throws Exception {
		return adminEssaysDao.pageList(UserId, pageSize, pageIndex);
	}

	@Override
	public long pageTotalCount(int UserId) throws Exception {
		return adminEssaysDao.pageTotalCount(UserId);
	}

	@Override
	public Map<String, Object> findById(int id) throws Exception {
		return adminEssaysDao.findById(id);
	}

	@Override
	public int modify(Map<String, Object> map) throws Exception {
		return adminEssaysDao.modify(map);
	}


}
