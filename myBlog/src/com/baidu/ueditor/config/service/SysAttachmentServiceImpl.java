package com.baidu.ueditor.config.service;

import java.io.File;

import org.springframework.stereotype.Service;

import com.baidu.ueditor.config.ConfigTool;
import com.baidu.ueditor.config.entity.SysAttachment;
import com.baidu.ueditor.config.service.interfaces.SysAttachmentService;

@Service
public class SysAttachmentServiceImpl implements SysAttachmentService {
	@Override
	public SysAttachment findById(String date,String id,String type) {
		SysAttachment sysAttachment = new SysAttachment();
		sysAttachment.setType(type);
		sysAttachment.setPath(ConfigTool.getImageSavePath()+File.separator+date+File.separator+id+"."+type);
		return sysAttachment;
	}
}
