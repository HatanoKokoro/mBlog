package com.baidu.ueditor.config.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baidu.ueditor.config.entity.SysAttachment;
import com.baidu.ueditor.config.service.interfaces.SysAttachmentService;
@Controller
public class ImageController {
	 @Autowired  
	    private SysAttachmentService sysAttachmentService;  
	    /** 
	     * 从磁盘获取图片 
	     */  
	    @RequestMapping(value = "/{date}/{id}/{type}/image", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)  
	    public void image(@PathVariable("date") String date,@PathVariable("id") String id,@PathVariable("type") String type,HttpServletRequest request, HttpServletResponse response)  
	            throws IOException {  
	        SysAttachment sysAttachment = sysAttachmentService.findById(date,id,type);  
	        response.setContentType("image/x-png");  
	        response.setCharacterEncoding("UTF-8");  
	        File file = new File(sysAttachment.getPath());  
	        BufferedImage image = ImageIO.read(file);  
	        ImageIO.write(image, sysAttachment.getType(), response.getOutputStream());  
	    }  
}
