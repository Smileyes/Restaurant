<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"
	import="com.Smileyes.entity.FoodTable,com.Smileyes.entity.Orders"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
<script type="text/javascript">
	setInterval(function() {
		window.location.href = "#";
	}, 1000 * 50);
</script>
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.servletContext.contextPath}/sys/style/images/title_arrow.gif" />
				餐厅订单列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0"
			cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>订单编号</td>
					<td>餐桌名</td>
					<td>下单日期</td>
					<td>总金额</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:forEach items="${orderList}" var="order" varStatus="varSta">
					<tr height="60" align="center">
						<td>${varSta.count }</td>
						<c:forEach items="${tableList}" var="table">
							<c:if test="${table.id == order.tableId }">
								<td>${table.tableName}</td>
							</c:if>
						</c:forEach>
						<td>${order.orderDate}</td>
						<td>${order.orderPrice}</td>
						<c:choose>
							<c:when test="${order.orderStatus==0 }">
								<td>未结账</td>
								<td style="width: 180"><a style="margin-left: 25"
									href="${pageContext.servletContext.contextPath}/order?method=detail&id=${order.id}"
									class="FunctionButton">详细</a> <a
									href="${pageContext.servletContext.contextPath}/order?method=check&id=${order.id}"
									class="FunctionButton">结账</a> <a
									href="${pageContext.servletContext.contextPath}/order?method=delete&id=${order.id}"
									class="FunctionButton">删除</a></td>
							</c:when>
							<c:otherwise>
								<td>已结账</td>
								<td style="width: 180"><a style="margin-left: 73"
									href="${pageContext.servletContext.contextPath}/order?method=detail&id=${order.id}"
									class="FunctionButton">详细</a>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center"></div>
	</div>
</body>
</html>
