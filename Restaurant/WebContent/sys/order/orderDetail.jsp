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
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.servletContext.contextPath}/sys/style/images/title_arrow.gif" />
				订单菜品列表
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
					<td align="center">菜名</td>
					<td align="center">单价</td>
					<td align="center">数量</td>
					<td align="center">总价</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:forEach items="${detailList}" var="detail">
					<tr height="60">
						<c:forEach items="${foodList}" var="food">
							<c:if test="${food.id==detail.foodId}">
								<td align="center">${food.foodName}</td>
							</c:if>
						</c:forEach>
						<td align="center">&yen;${detail.price}</td>
						<td align="center">${detail.foodNum}</td>
						<td align="center">&yen;${detail.price * detail.foodNum}</td>
					</tr>
				</c:forEach>
				<tr align="center">
					<td />
					<td />
					<td />
					<td style="font-size: 20">&yen;${order.orderPrice}</td>
				</tr>
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="right">
			<a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
		</div>
	</div>
</body>
</html>
