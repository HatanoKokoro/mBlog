package com.baidu.ueditor.config.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;

@Controller
public class InitController {
	
	@RequestMapping(value="/ueditor/init")
	public void initUeditor(HttpServletRequest request ,HttpServletResponse response){
		
		response.setContentType("application/json");
		
		String rootPath = request.getSession().getServletContext().getRealPath("/baidu");
		
		PrintWriter writer = null;
		try{
			String exec = new ActionEnter(request, rootPath).exec();
			writer = response.getWriter();
			writer.write(exec);
			writer.flush();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(writer!=null)
				writer.close();
		}
	}
	
	
}
