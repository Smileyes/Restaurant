<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"
	import="com.Smileyes.entity.FoodTable"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- 包含公共的JSP代码片段 -->

<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/sys/style/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/sys/style/js/page_common.js"></script>
<link
	href="${pageContext.servletContext.contextPath}/sys/style/css/common_style_blue.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/sys/style/css/index_1.css" />
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.servletContext.contextPath}/sys/style/images/title_arrow.gif" />
				餐桌列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>


	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="${pageContext.servletContext.contextPath}/sys/table"
			method="get">
			<input type="hidden" name="method" value="find"> <input
				type="text" name="tableName" title="请输入餐桌名称" value="${search}">
			<input type="submit" value="搜索">
		</form>
	</div>


	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>编号</td>
					<td>桌名</td>
					<td>状态</td>
					<td>预定时间</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:forEach items="${tableList}" var="ft" varStatus="varSta">
					<tr class="TableDetail1">
						<td align="center">${varSta.count}&nbsp;</td>
						<td align="center">${ft.tableName}&nbsp;</td>
						<c:choose>
							<c:when test="${ft.tableStatus ==0}">
								<td align="center">未预定</td>
								<td align="center">&nbsp;</td>
								<td width="220"><a style="margin-left: 60px"
									href="${pageContext.servletContext.contextPath}/table?method=update&id=${ft.id}&tableStatus=0"
									class="FunctionButton">预定</a> <a
									href="${pageContext.servletContext.contextPath}/sys/table?method=delete&id=${ft.id}"
									onClick="return delConfirm();" class="FunctionButton">删除</a></td>
							</c:when>
							<c:otherwise>
								<td align="center">已预定</td>
								<td align="center">${ft.orderTime}</td>
								<td><a style="margin-left: 60px"
									href="${pageContext.servletContext.contextPath}/sys/table?method=update&id=${ft.id}&tableStatus=1"
									class="FunctionButton">退桌</a> <a
									href="${pageContext.servletContext.contextPath}/sys/table?method=delete&id=${ft.id}"
									onClick="return delConfirm();" class="FunctionButton">删除</a></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a
					href="${pageContext.servletContext.contextPath}/sys/table/saveTable.jsp">添加</a>
			</div>
		</div>
	</div>
</body>
</html>
