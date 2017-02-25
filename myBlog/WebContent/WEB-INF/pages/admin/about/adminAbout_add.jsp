<!DOCTYPE html>
<html lang="zh-cn"><head>
<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
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
		<jsp:include page="../common/left.jsp"></jsp:include>
		<div class="container">
			<div class="adminright">
				<form  class="form-horizontal" id="formMenu" action="admin/about/add" method="post">
					<div class="row">
						<br />
						
						<div class="form-group">
							<label class="col-sm-2 control-label" >标题</label>
							<div class="col-sm-4">
								<input class="form-control col-sm-3" type="text" name="title" id="title">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label" >介绍内容</label>
							<div class="col-sm-8">
								<script id="container" name="content" type="text/plain" style="height:400px;" ></script>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-5"></div>
							<div class="col-sm-5" >
								<input class="btn btn-primary" type="submit" id="save" value="提交" >
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="baidu/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="baidu/ueditor/ueditor.all.js"></script>
 <script type="text/javascript">
	var ue = UE.getEditor('container');
	
</script>
</body>
</html>