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
import org.springframework.web.servlet.ModelAndView;

import com.blog.web.common.util.baseUtil;
import com.blog.web.entity.Classification;
import com.blog.web.entity.Note;
import com.blog.web.show.service.interfaces.IclassificationServise;
import com.blog.web.show.service.interfaces.IcommentsService;
import com.blog.web.show.service.interfaces.InoteService;

@Controller
@RequestMapping("/note")
public class noteController extends baseUtil{
	
	
	@Autowired
	InoteService noteService;
	
	@Autowired
	IclassificationServise classificationServise;
	
	
	@RequestMapping(value={"/{userId:[\\d]*}"} , method=RequestMethod.GET )
	public ModelAndView findAll(@PathVariable int userId, HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("show/note/note_list");
			List<Map<String,Object>> list = noteService.findByUserId(userId);
			mv.addObject("data",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value={"/view/{id:[\\d]*}/{userId:[\\d]*}"},method=RequestMethod.GET)
	public ModelAndView view(@PathVariable int id,@PathVariable int userId,
			HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		try {
			Note note = (Note)noteService.findById(id);
			List<Map<String,Object>> classification = classificationServise.findByUserId(userId);
			noteService.modifyTraffic(id);
			if(note.getId()>0){
				mv.setViewName("show/note/note_view");
				mv.addObject("data",note);
				mv.addObject("classification",classification);
			}else
				mv.setViewName("redirect:error/");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value="/{classificationId:[\\d]+}-{userId:[\\d]+}-{categoryId:[\\d]+}-{pageSize:[\\d]+}",method=RequestMethod.GET)
	public ModelAndView findByClassification(HttpServletRequest request,HttpServletResponse response,
		@PathVariable int classificationId ,@PathVariable int userId ,@PathVariable int categoryId ,@PathVariable int pageSize){
 		ModelAndView mv = new ModelAndView();
		try {
//		classificationId =  assignmentId(classificationId);
		userId = assignmentUserId(userId);
		long total = noteService.findSize(userId);
		mv.addObject("total",Math.ceil(total/8.0));
		if(pageSize>Math.ceil(total/8.0))
			pageSize=1;
		mv.addObject("currentPage",pageSize);
		String searchKey = request.getParameter("searchKey");
			List<Map<String,Object>> data = noteService.findPage(userId, classificationId, categoryId,searchKey,(pageSize-1)*8);
			List<Map<String,Object>> classification = classificationServise.findByUserId(userId);
			
			mv.addObject("data",data);
			mv.addObject("classification",classification);
			int col=0;
			if(classificationId>0){
				col=classificationId;
			}
			mv.addObject("col",col);
			mv.setViewName("show/note/note_list");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
}
