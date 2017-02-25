
<!DOCTYPE html>
<%@page import="org.springframework.context.annotation.Import"%>
<html lang="zh-cn"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<meta charset="UTF-8">
<title>Artoria's Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<%@ page isErrorPage="true"%>
<%-- <%@ include file="pager.jsp"%> --%>
<%@page import="java.util.List" %>
<%@page import="com.blog.web.entity.Note" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	
	List<Note> list = (List)request.getAttribute("data");
%>
<base href="<%=basePath%>">
<head>
<link rel="SHORTCUT ICON" href="static/img/NRO.ico">
<link href="static/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="static/css/common.css" rel="stylesheet">
<!-- <link href="static/css/style.css" rel="stylesheet"> -->
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="static/plugin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>note</title>
</head>
<body class="bd">
	<div class="head">
		<jsp:include page="../show/common/header.jsp"></jsp:include>
	</div>
	<div class="person_head">
		<jsp:include page="../show/common/main_header.jsp"></jsp:include>
	</div>
	<div class="dbody">
		<div class="person_body">


				<div class="">
					<h1><a href="#" rel="bookmark" title="Permanent Link to Poster man">Poster man</a></h1>
				</div>
				<div class="">
				aaaaaaaaaaaaaaaaaaaaaaaaaa
				</div>
				<div class="">
				</div>
				<div class="">
				</div>
				
				
		</div>
		<div class="person_right">、

<!-- 				<div class="usual"> -->
				       
<!-- 			        <ul class="idTabs"> -->
<!-- 			          <li><a class="selected" href="#RECENT">RECENT</a></li> -->
			
<!-- 			          <li><a class="" href="#ARCHIVE">ARCHIVE</a></li> -->
<!-- 					  <li><a class="" href="#TOPICS">TOPICS</a></li> -->
<!-- 					  <li><a class="" href="#TAGS">TAGS</a></li> -->
<!-- 			        </ul> -->
				        
<!-- 				START widget_box div -->
<!-- 				<div class="widget_box"> -->
<!-- 				   <div style="display: block;" id="RECENT"> -->
<!-- 					   <ul>	 -->
<!-- 					    <li><a href="http://localhost/wordpress/?p=16" title="Awsome stuff">Awsome stuff</a></li> -->
<!-- 						<li><a href="#" title="Poster man">Poster man</a></li> -->
<!-- 						<li><a href="#" title="Sensation">Sensation</a></li> -->
<!-- 						<li><a href="#" title="Fantastic">Fantastic</a></li> -->
<!-- 						<li><a href="#" title="Big news">Big news</a></li> -->
<!-- 						<li><a href="#" title="Heading">Heading</a></li> -->
<!-- 						<li><a href="#" title="Another post">Another post</a></li> -->
<!-- 						<li><a href="#" title="Hello world!">Hello world!</a></li> -->
<!-- 					  </ul> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
			</div>
	</div>
	
	<jsp:include page="../show/common/floor.jsp"></jsp:include>
</body>
</html>