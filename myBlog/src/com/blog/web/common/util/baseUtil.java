package com.blog.web.common.util;

public class baseUtil {
	
	public int  assignmentId(int id){
		if(id==0 || "".equals(id) || "null".equals(id))
			return 1;
		else
			return id;
	}

	public int  assignmentUserId(int userId){
		if(userId==0 || "".equals(userId) || "null".equals(userId))
			return 1;
		else
			return userId;
	}
}
