package com.blog.web.admin.controller;

import java.sql.Timestamp;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blog.web.admin.service.interfaces.IadminNoteService;
import com.blog.web.common.util.baseUtil;
import com.blog.web.entity.Note;
import com.blog.web.entity.User;


@Controller
@RequestMapping("admin/note")
public class adminNoteController extends baseUtil{
	
	@Autowired
	private IadminNoteService adminNoteService;
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/note/adminNote_list");
		return mv;
	}
	
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public ModelAndView toAdd(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/note/adminNote_add");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value={"/add"},method=RequestMethod.POST)
	public ModelAndView Add(HttpServletRequest request ,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			Note note = new Note();
			User user = (User)request.getSession().getAttribute("UserInfo");
			note.setNoteName(request.getParameter("noteName"));
			note.setCreateTime(new Timestamp(System.currentTimeMillis()));
			note.setModifyTime(new Timestamp(System.currentTimeMillis()));
			String description = request.getParameter("description");
			note.setDescription(description.substring(0, 10)+"...");
			note.setNoteValue(request.getParameter("content"));
			note.setCategoryId(Integer.parseInt(request.getParameter("category")));
			note.setClassificationId(Integer.parseInt(request.getParameter("classification")));
			note.setUserId(user.getUserId());
			int a;
		
			a = adminNoteService.AddNote(note);
		
			if(a>0)
				mv.setViewName("admin/note/adminNote_list");
			else{
				mv.addObject("","");
				mv.setViewName("");
			}
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
		pageSize=(pageSize-1)*8;
		String searchKey = request.getParameter("searchKey");
			List<Map<String,Object>> data = adminNoteService.findPage(userId, classificationId, categoryId,searchKey,pageSize);
			mv.addObject("data",data);
			int col=0;
			if(classificationId>0){
				col=classificationId;
			}
			mv.addObject("col",col);
			mv.setViewName("admin/note/adminNote_list");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
		
	}

	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public ModelAndView modify(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/note/adminNote_edit");
		return mv;
	}
	
	@RequestMapping(value="/del/{id:[\\d]+}" ,method=RequestMethod.GET)
	public ModelAndView del(HttpServletRequest request,HttpServletResponse response,
			@PathVariable int id){
		ModelAndView mv = new ModelAndView();
		try{
			int a= adminNoteService.del(id);
			mv.setViewName("redirect:/admin/note/0-1-0-1");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mv;
	}
}
