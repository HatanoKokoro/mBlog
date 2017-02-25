
<!DOCTYPE html>
<%@page import="org.springframework.context.annotation.Import"%>
<html lang="zh-cn"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	
%>
<base href="<%=basePath%>">
<head>
<link rel="SHORTCUT ICON" href="static/img/NRO.ico">
<link href="static/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="static/css/common.css" rel="stylesheet">
<link href="static/css/about.css" rel="stylesheet">
<link href="static/css/note.css" rel="stylesheet">
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
		<div class="abperson_body">
			<div class="main_detail">
<!-- 				<span>&nbsp;&nbsp;一个正在努力的程序猿，java开发，从业一年，做过OA、电商，写过接口，研究过freemarker、redis、ueditor等， -->
<!-- 				进京路上~ -->
<!-- 				</span><br/> -->
<!-- 				<span> -->
<!-- 				&nbsp;&nbsp;暴雪粉丝，电脑里永远有暴雪所有游戏，老年dota、lol玩家  &nbsp; (*/ω＼*)前边那些都已不玩 最近只玩FGO -->
<!-- 				</span><br/> -->
<!-- 				<span> -->
<!-- 				&nbsp;&nbsp;喜欢看动漫、漫画、小说，听音乐（拒绝唱歌） -->
<!-- 				</span> -->
			${about.content}
			</div>
			<div class="mod_resource">
				<p class="text-center font-weight">最近的文章</p>
				<c:forEach var="lis" items="${data}" >
					<a class="nla" href="note/view/${lis.id}/${lis.userId}" >${lis.noteName}</a><br />
					<span class="sdes">${lis.description}</span><br/>
					<span class="sp">${fn:substring(lis.createTime, 0,10)} &nbsp;阅读(${lis.traffic}) </span>
					<br/><br/>
				</c:forEach>
			</div>
			<div class="knowledge">
				<p class="text-center">最近的下载</p>
				
			</div>
		</div>
		<div class="person_right">

			</div>
	</div>
	
	<jsp:include page="../show/common/floor.jsp"></jsp:include>
</body>
</html>