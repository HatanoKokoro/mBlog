package com.blog.web.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blog.web.admin.service.interfaces.IuserService;
import com.blog.web.entity.User;

@Controller
@RequestMapping("/admin")
public class adminUserController {
	
	
	@Autowired
	IuserService userService;
	
	@RequestMapping(value={"","/"} , method=RequestMethod.GET )
	public ModelAndView findAll(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("admin/login");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Map map = new HashMap();
			map.put("username", username);
			map.put("password", password);
			User user = (User)userService.Login(map);
			if(user!=null&&user.getUserId()>0){
				request.getSession().setAttribute("UserInfo", user);
				mv.setViewName("admin/index");
			}else{
				mv.addObject("col","账号或密码错误，请重新尝试");
				mv.setViewName("admin/login");
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return mv;
	}
	
	
}
