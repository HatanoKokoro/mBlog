<!DOCTYPE html>
<html lang="zh-cn"><head>
<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<link href="static/css/note.css" rel="stylesheet">
<link href="static/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />

</head>
<body class="bd">
	<div class="adminbody">
		<div class="adminheader"></div>
		<jsp:include page="../common/left.jsp"></jsp:include>
		<div class="container">
			<div class="adminright">
				<form  class="form-horizontal" id="formMenu">
					<div class="row">
						<br />
						<c:forEach var="lis" items="${data}" >
							<a class="nla" href="admin/about/view/${lis.id}" >${lis.title}</a><br />
							<span class="sp">
							<a href="admin/about/modify/${lis.id}">编辑</a>
							&nbsp;<a  onclick="confirm('确定要删除吗?')?location.href='admin/about/del/${lis.id}':''" href="javascript:;">删除</a>
							</span>
							<br/><br/>
						</c:forEach>
					</div>
				</form>
			</div>
		</div>
	</div>
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
 <script type="text/javascript">
	
</script>
</body>
</html>