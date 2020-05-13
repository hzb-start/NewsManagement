<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>新闻首页</title>
	<%@ include file="/pages/common/head_base.jsp"%>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">新闻资讯</span>
			<div>
				<a href="pages/user/login.jsp">登录</a> |
				<a href="pages/user/register.jsp">注册</a> &nbsp;&nbsp;
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="news">
			<div class="news_cond">
				<form action="" method="get">
					标题：<input id="min" type="text" name="min" value="">  - 2
						<input id="max" type="text" name="max" value=""> 1
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span>目前多少条新闻</span>
				<div>
					您刚刚观看了<span style="color: red">黄朝博</span>的这条新闻
				</div>
			</div>


			<c:forEach items="${requestScope.page.items}" var="news">
			<div class="news_list">
				<div class="img_div">
					<img class="news_img" alt="" src="" />
				</div>
				<div class="news_info">
<%--					<div class="news_name">--%>
<%--						<span class="sp1">id:</span>--%>
<%--						<span class="sp2">${news.id}</span>--%>
<%--					</div>--%>
					<div class="news_author">
						<span class="sp1">标题:</span>
						<span class="sp2">${news.title}</span>
					</div>
					<div class="news_price">
						<span class="sp1">作者:</span>
						<span class="sp2">${news.author}</span>
					</div>
					<div class="news_sales">
						<span class="sp1">时间:</span>
						<span class="sp2">${news.enterdate}</span>
					</div>
					<div class="news_amount">
						<span class="sp1">热度:</span>
						<span class="sp2">${news.hot}</span>
					</div>
					<div class="news_add">
						<button>查看详情</button>
					</div>
				</div>
			</div>
			</c:forEach>



		</div>


		<div id="page_nav">

			<c:if test="${requestScope.page.pageNo>1}">
				<a href="client/newsServlet?action=page&pageNo=1">首页</a>
				<a href="client/newsServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
			</c:if>

			<%--			页码输出的开始--%>
			<a href="client/newsServlet?action=page&pageNo=${requestScope.page.pageNo-1}">${requestScope.page.pageNo-1}</a>
			【${requestScope.page.pageNo}】
			<a href="client/newsServlet?action=page&pageNo=${requestScope.page.pageNo+1}">${requestScope.page.pageNo+1}</a>

			<c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
				<a href="client/newsServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
				<a href="client/newsServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
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
						location.href = "${pageScope.basePath}client/newsServlet?action=page&pageNo=" + pageNo;
					})
				})
			</script>
		</div>



	</div>

	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>