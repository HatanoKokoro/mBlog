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

</head>
<body class="bd">
	<div class="adminbody">
		<div class="adminheader"></div>
		<div>
			<jsp:include page="common/left.jsp"></jsp:include>
			
		</div>
		
	</div>
<script type="text/javascript" src="baidu/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="baidu/ueditor/ueditor.all.js"></script>
 <script type="text/javascript">
	var ue = UE.getEditor('container');
	
	
</script>
</body>
</html>