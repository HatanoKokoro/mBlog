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

import com.blog.web.admin.service.interfaces.IadminNoteService;
import com.blog.web.common.TableData;
import com.blog.web.common.util.baseUtil;
import com.blog.web.entity.Note;
import com.blog.web.entity.User;

import net.sf.json.JSONObject;


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
	public String Add(HttpServletRequest request ,HttpServletResponse response){
		JSONObject msg = new JSONObject();
		try {
			Note note = new Note();
			String description = request.getParameter("description");
			if(description==null || "".equals(description)){
				description =  request.getParameter("description_default");
			}
			User user = (User)request.getSession().getAttribute("UserInfo");
			note.setNoteName(request.getParameter("noteName"));
			note.setCreateTime(new Timestamp(System.currentTimeMillis()));
			note.setModifyTime(new Timestamp(System.currentTimeMillis()));
			note.setDescription(description.substring(0, 10)+"...");
			note.setNoteValue(request.getParameter("content"));
			note.setCategoryId(Integer.parseInt(request.getParameter("category")));
			note.setClassificationId(Integer.parseInt(request.getParameter("classification")));
			note.setUserId(user.getUserId());
			int a = adminNoteService.AddNote(note);
			msg.put("msg", "success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg.toString();
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

	
	@RequestMapping(value="/modify/{id:[\\d]+}",method=RequestMethod.GET)
	public ModelAndView modify(HttpServletRequest request,HttpServletResponse response,
			@PathVariable int id){
		ModelAndView mv = new ModelAndView();
		try {
			Map<String,Object> data = adminNoteService.findById(id);
			mv.setViewName("admin/note/adminNote_edit");
			mv.addObject("data",data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value={"/modify"},method=RequestMethod.POST)
	public String toModify(HttpServletRequest request ,HttpServletResponse response){
		JSONObject json = new JSONObject();
		int a=0;
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			String description = request.getParameter("description");
			if(description==null || "".equals(description)){
				description =  request.getParameter("description_default").substring(0, 10)+"...";
			}
			map.put("noteName", request.getParameter("noteName"));
			map.put("modifyTime", new Timestamp(System.currentTimeMillis()));
			map.put("description", description);
			map.put("noteValue", request.getParameter("content"));
			map.put("categoryId", request.getParameter("category"));
			map.put("classificationId", request.getParameter("classification"));
			map.put("id", request.getParameter("id"));
			a = adminNoteService.modify(map);
			json.put("msg", "success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json.toString();
	}
	
	@RequestMapping(value="/del/{id:[\\d]+}" ,method=RequestMethod.GET)
	public ModelAndView del(HttpServletRequest request,HttpServletResponse response,
			@PathVariable int id){
		ModelAndView mv = new ModelAndView();
		try{
			int a= adminNoteService.del(id);
			mv.setViewName("redirect:/admin/note");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/list" ,method=RequestMethod.GET,produces = "application/json; charset=utf-8")
	public String PageList(HttpServletRequest request,HttpServletResponse response){
		TableData table = new TableData();
		try {
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			User user = (User)request.getSession().getAttribute("UserInfo");
			List<Map<String,Object>> data = adminNoteService.pageList(user.getUserId(),pageIndex,pageSize);
			long totalCount = adminNoteService.pageTotalCount(user.getUserId());
			
			table.setTotalCount(totalCount);
			table.addRows(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table.toString();
	}
	
	
}
