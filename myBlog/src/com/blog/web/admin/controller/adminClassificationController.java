package com.blog.web.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.web.admin.service.interfaces.IadminClassificationService;
import com.blog.web.entity.User;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("admin/classification")
public class adminClassificationController {
	
	@Autowired
	private IadminClassificationService adminClassificationService;
	
	@ResponseBody
	@RequestMapping(value={"/ajax"},method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String findByUserId(HttpServletRequest request,HttpServletResponse response){
		User user = (User)request.getSession().getAttribute("UserInfo");
		List<Map<String, Object>> data = null;
		try {
			data = adminClassificationService.findByUserId(user.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray json = JSONArray.fromObject(data);
		return json.toString();
	}
}
