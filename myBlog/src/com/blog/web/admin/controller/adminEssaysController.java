package com.blog.web.admin.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blog.web.admin.service.interfaces.IadminEssaysService;
import com.blog.web.entity.Essays;
import com.blog.web.entity.User;


@Controller
@RequestMapping("admin/essays")
public class adminEssaysController {
	
	@Autowired
	private IadminEssaysService adminEssaysService;
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public ModelAndView toAdd(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/essays/adminEssays_add");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value={"/add"},method=RequestMethod.POST)
	public ModelAndView Add(HttpServletRequest request ,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			Essays essays = new Essays();
			User user = (User)request.getSession().getAttribute("UserInfo");
			essays.setCreateTime(new Timestamp(System.currentTimeMillis()));
			essays.setModifyTime(new Timestamp(System.currentTimeMillis()));
			essays.setEssaysValue(request.getParameter("content"));
			essays.setUserId(user.getUserId());
			int a;
		
			a = adminEssaysService.AddEssays(essays);
		
			if(a>0)
				mv.setViewName("admin/note/adminEssays_add");
			else{
				mv.addObject("","");
				mv.setViewName("");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

}
