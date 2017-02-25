
<!DOCTYPE html>
<html lang="zh-cn"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<meta charset="UTF-8">
<title>Artoria's Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<%@ page isErrorPage="true"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<base href="<%=basePath%>">
<head>

<link href="static/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="static/css/common.css" rel="stylesheet">
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="static/plugin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>404 error</title>
</head>
<body class="indexbd">
	<div class="container-fluid">
		<div class="row">
			<br />
			<br />
			<br />
			<h1 align="center"><font>抱歉，正在施工中</font></h1>
			<div class="col-bg-12">
				<img style="display:block; margin:0 auto;" src="static/img/404.png"/>
			</div>
			<br />
			<br />
			<br />
			<div style="text-align:center">
				请您<a href="index" class="btn">返回首页</a>
			</div>
		</div>
	</div>
	
	<jsp:include page="../show/common/floor.jsp"></jsp:include>
</body>
</html>