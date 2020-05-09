<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>新闻管理</title>
	<%@ include file="/pages/common/head_base.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">新闻管理系统</span>
		<%@ include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>id</td>
				<td>title</td>
				<td>author</td>
				<td>enterdate</td>
				<td>hot</td>
				<td colspan="2">操作</td>
			</tr>

			<c:forEach items="${requestScope.newsList}" var="news">
				<tr>
					<td>${news.id}</td>
					<td>${news.title}</td>
					<td>${news.author}</td>
					<td>${news.enterdate}</td>
					<td>${news.hot}</td>
					<td><a href="#">修改</a></td>
					<td><a href="#">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/news_edit.jsp">添加新闻</a></td>
			</tr>	
		</table>
	</div>

	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>