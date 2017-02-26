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
			
<!-- 				<form  class="form-horizontal" id="formMenu"> -->
<!-- 					<div class="row"> -->
<!-- 						<br /> -->
<%-- 						<c:forEach var="lis" items="${data}" > --%>
<%-- 							<a class="nla" href="note/view/${lis.id}/${lis.userId}" >${lis.noteName}</a><br /> --%>
<%-- 							<span class="sdes">${lis.description}</span><br/> --%>
<%-- 							<span class="sp">${fn:substring(lis.createTime, 0,10)} &nbsp;阅读(${lis.traffic}) &nbsp;评论(${lis.num}) --%>
<%-- 							&nbsp;<a href="note/modify/${lis.id}">编辑</a> --%>
<%-- 							&nbsp;<a  onclick="confirm('确定要删除吗?')?location.href='admin/note/del/${lis.id}':''" href="javascript:;">删除</a> --%>
<!-- 							</span> -->
<!-- 							<br/><br/> -->
<%-- 						</c:forEach> --%>

							
<!-- 					</div> -->
<!-- 				</form> -->
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
		    url: "admin/note/list",
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
							field: 'id',
							title: '序号',
							class: 'text-center'
						},
					     {
					        field: 'noteName',
					        title: '标题'
					     }, 
					     {
					        title: '操作',
					        class: 'text-center',
					        formatter: function(value, row, index) {
					        	if(row.id!=''){
					        		return  '<a href=""  title="编辑"><i class="glyphicon glyphicon-edit"></i></a>' + '&nbsp;&nbsp;&nbsp;' + 
									'<a href="javaScript:void();"   title="删除"><i class="glyphicon glyphicon-remove"></i></a>'+'&nbsp;&nbsp;&nbsp;';
					        	}
					        }
					    }
		    		   ]
		});
 })

</script>
</body>
</html>