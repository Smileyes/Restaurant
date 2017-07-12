<!-- 删除菜品时出现错误 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/sys/style/js/refresh.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>错误</title>
</head>
<body>
	<font color="RED">${foodName}</font>已加入订单，无法删除。
	<br>
	<span id="refresh" value="">10</span>秒后跳转回前一页面，
	<a href="#" onClick="javascript:history.back(-1);">现在跳转</a>
</body>
</html>