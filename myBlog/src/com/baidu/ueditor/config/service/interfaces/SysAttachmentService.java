package com.baidu.ueditor.config.service.interfaces;

import com.baidu.ueditor.config.entity.SysAttachment;

public interface SysAttachmentService {
	/**
	 * 获取图片
	 */
	public SysAttachment findById(String date,String id,String type);
}
