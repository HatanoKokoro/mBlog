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
<link href="static/plugin/select2/css/select2.min.css" rel="stylesheet" />

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
						<div class="form-group">
							<label class="col-sm-2 control-label" >文章标题</label>
							<div class="col-sm-4">
								<input class="form-control col-sm-3" type="text" name="noteName" id="noteName" value="${data.noteName}">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label" >文章内容</label>
							<div class="col-sm-8">
								<script id="container" name="content" type="text/plain"  >${data.noteValue}</script>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label" >文章主类</label>
							<div class="col-sm-4" >
								<select id="category" name="category" style="width:200px;"></select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label" >文章类别</label>
							<div class="col-sm-4" >
								<select id="classification" name="classification" style="width:200px;"></select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label" >文章摘要</label>
							<div class="col-sm-4">
								<input class="form-control col-sm-3" type="text" name="description" id="description" value="${data.description}">
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-5"></div>
							<div class="col-sm-5" >
								<input class="btn btn-primary" type="button" id="save" value="提交" >
							</div>
						</div>
						<input class="form-control col-sm-3" type="hidden" name="id" id="id" value="${data.id}">
					</div>
				</form>
			</div>
		</div>
	</div>
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="baidu/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="baidu/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="static/plugin/select2/js/select2.min.js"></script>
 <script type="text/javascript">
// 	var ue = UE.getEditor('container');

	var ue = UE.getEditor('container',{
	initialFrameWidth :600,//设置编辑器宽度
	initialFrameHeight:400,//设置编辑器高度
	scaleEnabled:true
	});
	
	$(function(){
		
		var categoryId =${data.categoryId};
		var classificationId =${data.classificationId};
		
		$("#save").click(function(){
			 var dataJson= $("#formMenu").serializeArray();
			 dataJson.push({"name":"description_default","value":ue.getContentTxt()});
// 			 alert(JSON.stringify(dataJson));
			$.ajax({
				url:"admin/note/modify",
				type:"post",
				data:dataJson,
				dataType: "json",
				success:function(data){
					if(data.msg="success")
						alert("修改成功");
					window.location="admin/note";
				}
			
			})
		})
		
		
		
		$.ajax({
			url:"admin/category/ajax",
			type:"post",
			dataType: "json",
			success:function(data){
				var list = new Array();
				for(var i=0;i<data.length;i++){
					list.push(" { id : '"+data[i].id+"',"+"text:'"+data[i].categoryName+"'}");
				}
				var datalist ="["+list+"]";
				var res = eval('(' + datalist + ')');
				$("#category").select2({
					data:res
				});
				$('#category').val(categoryId).trigger('change');
			}
		})
		
		$.ajax({
			url:"admin/classification/ajax",
			type:"post",
			dataType: "json",
			success:function(data){
				var list = new Array();
				for(var i=0;i<data.length;i++){
					list.push(" { id : '"+data[i].id+"',"+"text:'"+data[i].classificationName+"'}");
				}
				var datalist ="["+list+"]";
				var res = eval('(' + datalist + ')');

				$("#classification").select2({
					data:res
				});
				$('#classification').val(classificationId).trigger('change');
			}
		})
		
		
	})
	
</script>
</body>
</html>