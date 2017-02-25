package com.blog.web.other.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("error")
public class error {
	
	@RequestMapping(value="/404",method=RequestMethod.GET)
	public ModelAndView error(){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/other/error404");
		return mv;
	}
}
