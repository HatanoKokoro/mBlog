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

import com.blog.web.admin.service.interfaces.IadminEssaysService;
import com.blog.web.common.TableData;
import com.blog.web.entity.Essays;
import com.blog.web.entity.User;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("admin/essays")
public class adminEssaysController {
	
	@Autowired
	private IadminEssaysService adminEssaysService;
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/essays/adminEssays_list");
		return mv;
	}
	
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
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
				mv.setViewName("admin/essays/adminEssays_add");
			else{
				mv.addObject("","");
				mv.setViewName("");
			}
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
			Map<String,Object> data = adminEssaysService.findById(id);
			mv.setViewName("admin/essays/adminEssays_edit");
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
			map.put("modifyTime", new Timestamp(System.currentTimeMillis()));
			map.put("essaysValue", request.getParameter("content"));
			map.put("id", request.getParameter("id"));
			a = adminEssaysService.modify(map);
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
			int a= adminEssaysService.del(id);
			mv.setViewName("redirect:/admin/essays");
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
			List<Map<String,Object>> data = adminEssaysService.pageList(user.getUserId(),pageIndex,pageSize);
			long totalCount = adminEssaysService.pageTotalCount(user.getUserId());
			
			table.setTotalCount(totalCount);
			table.addRows(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table.toString();
	}

}
