package com.blog.web.show.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blog.web.show.service.interfaces.IaboutService;
import com.blog.web.show.service.interfaces.InoteService;

@Controller
@RequestMapping("/about")
public class aboutController {
	
	@Autowired
	private InoteService noteService;
	
	@Autowired
	private IaboutService aboutService;
	
	@RequestMapping(value={"","/"} , method=RequestMethod.GET )
	public ModelAndView findAll(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			int userId= 1;
			List<Map<String,Object>> data = noteService.findByUserId(userId);
			List<Map<String,Object>> about =aboutService.findByUserId(userId);
			
			mv.addObject("data",data);
			mv.addObject("about",about.get(0));
			mv.setViewName("show/about");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
}
