
<!DOCTYPE html>
<html lang="zh-cn"><head>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<meta charset="UTF-8">
<title>Artoria's Home</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="SHORTCUT ICON" href="static/img/NRO.ico">
<link href="static/css/common.css" rel="stylesheet">
<link href="static/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
<style type="text/css">
.floor{
    margin-top: 180px;
}
</style>
</head>
<body class="indexbd">
	<div class="willerce">
		<img class="avatar"
			src="static/img/artoria.jpg" alt=""
			width="128" height="128">
		<h1>Artoria's Home</h1>
		<p>只是一个普通咸鱼的日常罢了(*/ω＼*)</p>
		<p style="height: 24px; line-height: 24px; margin: 30px 0;">
			<img style="vertical-align: bottom; margin-right: 10px;"
				src="static/img/address.png">
			ChangChun · China
		</p>
		<p class="nav">
			<a href="about">关于我</a> 
			<a href="essays">个人随笔</a> 
			<a href="note/0-1-0-1">学无止境</a>
			<a href="share">资源分享</a> 
<!-- 			<a href="http://www.artoria.wang/myBlog/links"></a>  -->
<!-- 			<a href="http://www.artoria.wang/myBlog/tags">Tags</a>  -->
			<a href="message">留言板</a> 
<!-- 			<a href="http://www.artoria.wang/myBlog/service">Service</a> -->

		</p>
	</div>
		<jsp:include page="../show/common/floor.jsp"></jsp:include>
</body>
</html>