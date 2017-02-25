
<!DOCTYPE html>
<%@page import="org.springframework.context.annotation.Import"%>
<html lang="zh-cn"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
// 	List<Note> list = (List)request.getAttribute("data");
%>
<base href="<%=basePath%>">
<head>
<link rel="SHORTCUT ICON" href="static/img/NRO.ico">
<link href="static/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="static/css/common.css" rel="stylesheet">
<link href="static/css/note.css" rel="stylesheet">
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="static/plugin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>note</title>
</head>
<body class="notebd">
	<div class="head">
		<jsp:include page="../../show/common/header.jsp"></jsp:include>
	</div>
	<div class="person_head">
		<div class="portrait">
			<img alt="头像" src="static/img/artoria.jpg">
		</div>
		<div class="portrait-right">
			<div class="nick">
				<br/>
				<span class="fl na">Artoria</span><br/>
				<span class="fl">一条咸鱼，</span>
			</div>
			<div class="tag">
				<a class="fl" href="note/0-${data.userId}-1"><img src="static/img/bq1.png" /></a>
				<a class="fl" href="note/0-${data.userId}-2"><img src="static/img/bq2.png" /></a>
				<a class="fl" href="note/0-${data.userId}-3"><img src="static/img/bq3.png" /></a>
			</div>
		</div>
	</div>
	<div class="dbody">
		<div class="note_person_body">
			<div class="text-center title">${data.noteName}</div>
			<div style="margin-left: 20px;margin-right: 20px;" >${data.noteValue}</div>
		</div>
		<div class="note_person_right">
			<div class="fenle text-center" >
				<label class="control-label titl">文章分类</label><br />
				<div  class="text-left">
					<c:forEach var="cls" items="${classification}">
						<a class="al" href="note/${cls.id}-${cls.userId}-0-1" >${cls.classificationName}(${cls.num})</a><br />
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="../../show/common/floor.jsp"></jsp:include>
</body>
</html>