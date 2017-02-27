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
<link href="static/plugin/bootstrap-table/bootstrap-table.min.css" rel="stylesheet" />

</head>
<body class="bd">
	<div class="adminbody">
		<div class="adminheader"></div>
		<jsp:include page="../common/left.jsp"></jsp:include>
		<div class="container">
			<div class="adminright">
					<table id="table"></table>
			</div>
		</div>
	</div>
<script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="static/plugin/bootstrap-table/bootstrap-table.min.js"></script>
 <script type="text/javascript">
 $(function(){
	  $('#table').bootstrapTable('destroy');  
	 $('#table').bootstrapTable({
		 	method: "get",
		    url: "admin/essays/list",
			pagination: true,
			pageNumber: 1,
			pageSize: 10,
			sidePagination: 'server',
			queryParamsType: 'limit',
			queryParams: 
				function(params){ 
				var temp = {
					pageSize: params.limit,
					pageIndex: params.offset,
					total: this.totalRows,
//	 				name_key:$('#searchContent').val() 
				};
				return temp;
			},
			dataType: "json",
			clickToSelect: true,
		    onLoadSuccess: function(data) {
			},
		    columns: [
						{
							field: 'Number',
							title: '序号',
							class: 'text-center',
							formatter: function (value, row, index) {
								if (row.essaysId!=''){
									return index+1;
								}else{
									return "";
								}
							}
						},
					     {
					        field: 'essaysValue',
					        title: '内容'
					     }, 
					     {
					        title: '操作',
					        class: 'text-center',
					        formatter: function(value, row, index) {
					        	if(row.essaysId!=''){
					        		return  '<a href="admin/essays/modify/'+row.essaysId+'"  title="编辑"><i class="glyphicon glyphicon-edit"></i></a>' + '&nbsp;&nbsp;&nbsp;' + 
					        		'<a href="javascript:onDel(\''+row.essaysId+'\');" title="删除"><i class="glyphicon glyphicon-remove"></i></a>'
					        	}
					        }
					    }
		    		   ]
		});
 })
 
function onDel(id){
	 var i = window.confirm("确定要删除吗?");
	 if(i==true){
		 window.location="admin/essays/del/"+id;
		 }else{ return false;
		 }
 }
 
 

</script>
</body>
</html>