
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
	
// 	List<Note> list = (List)request.getAttribute("data");
%>
<base href="<%=basePath%>">
<head>
<link rel="SHORTCUT ICON" href="static/img/NRO.ico">
<link href="static/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="static/css/common.css" rel="stylesheet">
<link href="static/css/note.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>note</title>
</head>
<body class="bd">
	<div class="head">
		<jsp:include page="../../show/common/header.jsp"></jsp:include>
	</div>
	<div class="person_head">
		<jsp:include page="../../show/common/main_header.jsp"></jsp:include>
	</div>
	<div class="dbody">
		<div class="person_body">
			<div class="container-fluid">
				<div class="row">
					<div class="col-bg-2">
		<%-- 				<jsp:include page="left"></jsp:include> --%>
					</div>
					<div class="col-bg-8">
						<form action="note/findAll">
						<br/>
							<c:forEach var="lis" items="${data}" >
								<a class="nla" href="note/view/${lis.id}/${lis.userId}" >${lis.noteName}</a><br />
								<span class="sdes">${lis.description}</span><br/>
								<span class="sp">${fn:substring(lis.createTime, 0,10)} &nbsp;阅读(${lis.traffic}) &nbsp;评论(${lis.num})</span>
								<br/><br/>
							</c:forEach>
						</form>
					</div>
					<div class="col-bg-2"></div>
				</div>
				<ul id="pageIndex" class="text-center">
				</ul>
			</div>
		</div>
		<div class="person_right">
			<div class="text-center fenle" >
				<label class="control-label titl">文章分类</label><br />
				<div  class="text-left">
					<c:forEach var="cls" items="${classification}">
						<a class="al" href="note/${cls.id}-${cls.userId}-0-1" >${cls.classificationName}(${cls.num})</a><br />
					</c:forEach>
				</div>
			</div>
			<div class="text-center sosu" >
				<label class="control-label titl">文章搜索</label><br />
				<div  class="text-left">
					<form id="searchForm" action="note/0-1-0-1" method="get">
						<div class="input-group">
							<input type="text" class="form-control input-lg" id="searchKey" name="searchKey" /><span class="input-group-addon btn btn-primary" id="search">搜索</span>
						</div>
					</form>
				</div>
			</div>
		</div>
		<input type="hidden" id="currentPage" value="${currentPage} ">
		<input type="hidden" id="total" value="${total} ">
	</div>
	
	<jsp:include page="../../show/common/floor.jsp"></jsp:include>
	
	
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="static/plugin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/plugin/bootstrap-paginator/bootstrap-paginator.js"></script>
<script type="text/javascript" src="static/js/commons.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#search").click(function(){
				$("#searchForm").submit();
			
		})
		var currentPage = $("#currentPage").val();
		var total = $("#total").val();
		
		 var container = $('#pageIndex');
	        var options  = {
	        			alignment:"center"
	        			,currentPage:currentPage
	                    , totalPages:total
	                    ,  pageUrl: function(type, page, current){
	                    	$("#currentPage").val(page);
	                        if (page==current) {
	                            return "javascript:void(0)";
	                        } else {
	                            return "note/0-1-0-"+page;
	                        }
	                    }
	                    , onPageClicked:null
	                    , onPageChanged:null


	                };

	                container.bootstrapPaginator(options);
		
		
	})
	

       

</script>

</body>
</html>