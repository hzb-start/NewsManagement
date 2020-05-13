<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>新闻管理</title>
	<%@ include file="/pages/common/head_base.jsp"%>

<%--	确实是否删除--%>
	<script type="text/javascript">
		$(function () {
			$("a.deleteClass").click(function () {
				/**
				 * confirm("提示信息")是一个确认提示按钮
				 * 参数是提示信息
				 * 有两个按钮：确认和取消
				 * 返回true表示确认，返回false表示取消
				 */
				return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
			})
		})
	</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
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

<%--			<c:forEach items="${requestScope.newsList}" var="news">--%>
			<c:forEach items="${requestScope.page.items}" var="news">
				<tr>
					<td>${news.id}</td>
					<td>${news.title}</td>
					<td>${news.author}</td>
					<td>${news.enterdate}</td>
					<td>${news.hot}</td>
					<td><a href="manager/newsServlet?action=queryNews&id=${news.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
					<td><a class="deleteClass" href="manager/newsServlet?action=deleteNews&id=${news.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/news_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加新闻</a></td>
			</tr>

		</table>

<%--		分页条的开始--%>
		<div id="page_nav">

			<c:if test="${requestScope.page.pageNo>1}">
				<a href="manager/newsServlet?action=page&pageNo=1">首页</a>
				<a href="manager/newsServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
			</c:if>

<%--			页码输出的开始--%>
			<a href="manager/newsServlet?action=page&pageNo=${requestScope.page.pageNo-1}">${requestScope.page.pageNo-1}</a>
			【${requestScope.page.pageNo}】
			<a href="manager/newsServlet?action=page&pageNo=${requestScope.page.pageNo+1}">${requestScope.page.pageNo+1}</a>

			<c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
				<a href="manager/newsServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
				<a href="manager/newsServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
			</c:if>

			共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
			到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
			<input id="queryPageButton" type="button" value="确定">


			<script type="text/javascript">
				// 指定页码
				$(function () {
					$("#queryPageButton").click(function () {
						var pageNo = $("#pn_input").val();

						<%--var pageTotal = ${requestScope.page.pageTotal};--%>
						<%--alert(pageTotal);--%>
						location.href = "${pageScope.basePath}manager/newsServlet?action=page&pageNo=" + pageNo;
					})
				})
			</script>
		</div>
<%--		分页条的结束--%>

	</div>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>