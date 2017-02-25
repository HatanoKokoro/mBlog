package com.blog.web.show.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/share")
public class shareController {
	
	
	@RequestMapping(value={"","/"} , method=RequestMethod.GET )
	public ModelAndView findAll(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("show/share");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
}
