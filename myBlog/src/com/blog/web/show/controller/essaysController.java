																																																																																					package com.blog.web.show.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.web.show.service.interfaces.IclassificationServise;
import com.blog.web.show.service.interfaces.IessaysService;

@Controller
@RequestMapping("/essays")
public class essaysController {
	
	@Autowired
	IclassificationServise classificationServise;
	
	@Autowired
	private IessaysService essaysService;
	
	
	@RequestMapping(value={"/",""} , method=RequestMethod.GET )
	public ModelAndView findAll(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			int userId=1;
			String userstr= request.getParameter("userId");
			if(userstr!=null && "".equals(userstr))
				userId=Integer.parseInt(userstr);
			List<Map<String,Object>> data = essaysService.findByUserId(userId);
			List<Map<String,Object>> classification = classificationServise.findByUserId(userId);
			mv.addObject("data",data);
			mv.addObject("classification",classification);
			mv.setViewName("show/essays/essays_list");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value={"/{userId:[\\d]+}-{index:[\\d]+}"} , method=RequestMethod.GET )
	public ModelAndView findPage(@PathVariable int userId,@PathVariable int index,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			long total = essaysService.findSize(userId);
			if(index>Math.ceil(total/5.0))
				index=1;
			List<Map<String,Object>> data = essaysService.findPage(userId, (index-1)*5);
			List<Map<String,Object>> classification = classificationServise.findByUserId(userId);
			mv.addObject("data",data);
			mv.addObject("currentPage",index);
			mv.addObject("total",Math.ceil(total/5.0));
			mv.addObject("classification",classification);
			mv.setViewName("show/essays/essays_list");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
}
