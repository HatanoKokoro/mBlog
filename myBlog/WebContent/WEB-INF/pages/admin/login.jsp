
<!DOCTYPE html>
<html lang="zh-cn"><head>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<meta charset="UTF-8">
<title>后台登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	
	String col = String.valueOf(request.getAttribute("col"))==null?null:String.valueOf(request.getAttribute("col"));
%>
<base href="<%=basePath%>">
<link rel="SHORTCUT ICON" href="static/img/NRO.ico">
<link href="static/css/common.css" rel="stylesheet">
<link href="static/css/login.css" rel="stylesheet">
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
<link href="static/plugin/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />

</head>
<body class="indexbd">
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4" style="top:200px;">
				<form action="admin/login" method="post">
					<div class="form-group">
						<input class="form-control" id="username" name="username" type="text"><br />
						<input class="form-control" id="password" name="password" type="password"><br />
						<input type="submit" class="btn btn-primary" value="登陆">
						<input type="button" class="btn btn-info" id="back" value="找回密码">
					</div>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
<script type="text/javascript">
	$(function(){
		var col = "<%=col%>";
		if(col!=null&&col!="null")
			alert(col);
	})
</script>
</body>
</html>