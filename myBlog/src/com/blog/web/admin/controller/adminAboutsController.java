package com.blog.web.admin.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blog.web.admin.service.interfaces.IadminAboutService;
import com.blog.web.entity.User;


@Controller
@RequestMapping("admin/about")
public class adminAboutsController {
	
	@Autowired
	private IadminAboutService adminAboutService;
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public ModelAndView toList(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		
		int userId=1;
		List<Map<String ,Object>> data=null;
		try {
			data =adminAboutService.findByUserId(userId);
			mv.addObject("data",data);
			mv.setViewName("admin/about/adminAbout_list");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public ModelAndView toAdd(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/about/adminAbout_add");
		return mv;
	}
	
	@RequestMapping(value={"/add"},method=RequestMethod.POST)
	public ModelAndView Add(HttpServletRequest request ,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			User user = (User)request.getSession().getAttribute("UserInfo");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("createTime",new Timestamp(System.currentTimeMillis()));
			map.put("modifyTime",new Timestamp(System.currentTimeMillis()));
			map.put("content",request.getParameter("content"));
			map.put("title",request.getParameter("title"));
			map.put("status",0);
			map.put("userId",user.getUserId());
			int a;
			
				a = adminAboutService.AddAbout(map);
			
			if(a>0)
				mv.setViewName("redirect:/admin/about");
			else{
				mv.addObject("","");
				mv.setViewName("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value={"/modify/{id:[\\d]+}"},method=RequestMethod.GET)
	public ModelAndView toModify(HttpServletRequest request,HttpServletResponse response,
			@PathVariable int id){
		ModelAndView mv = new ModelAndView();
		try {
			Map<String,Object> data = adminAboutService.findById(id);
			mv.setViewName("admin/about/adminAbout_edit");
			mv.addObject("data",data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value={"/modify"},method=RequestMethod.POST)
	public ModelAndView Modify(HttpServletRequest request ,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			User user = (User)request.getSession().getAttribute("UserInfo");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("modifyTime",new Timestamp(System.currentTimeMillis()));
			map.put("content",request.getParameter("content"));
			map.put("title",request.getParameter("title"));
			map.put("id",request.getParameter("id"));
			int a;
			
				a = adminAboutService.ModifyAbout(map);
			
			if(a>0)
				mv.setViewName("redirect:/admin/about");
			else{
				mv.addObject("","");
				mv.setViewName("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	
	@RequestMapping(value={"/del/{id:[\\d]+}"},method=RequestMethod.GET)
	public ModelAndView del(HttpServletRequest request,HttpServletResponse response,
			@PathVariable int id){
		ModelAndView mv = new ModelAndView();
		try {
			int a = adminAboutService.del(id);
			mv.setViewName("redirect:/admin/about");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

}
