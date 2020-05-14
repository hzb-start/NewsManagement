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
				<c:if test="${empty sessionScope.user}">
					<a href="pages/user/login.jsp">登录</a> |
					<a href="pages/user/register.jsp">注册</a> &nbsp;&nbsp;
				</c:if>

				<c:if test="${not empty sessionScope.user}">
					<span>欢迎<span class="um_span">${sessionScope.user.name}</span>新闻管理系统</span>
					<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
				</c:if>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="news">
			<div class="news_cond">
				<form action="client/newsServlet" method="get">
					<input type="hidden" name="action" value="pageByTitle" />
					标题：<input id="title" type="text" name="title" value="${param.title}" />
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span>目前共<span style = "color: #FF0000">${requestScope.page.pageTotalCount}</span>条新闻</span>
				<div>
					<span style = "color: #0008ff">欢迎关注公众号：二九幂加八</span>
				</div>
			</div>


			<c:forEach items="${requestScope.page.items}" var="news">
			<div class="news_list">
				<div class="img_div">
					<img class="news_img" alt="图片待上传" src="${news.img_path}" />
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


<%--&lt;%&ndash;		分页条的开始&ndash;%&gt;--%>
<%--		<div id="page_nav">--%>

<%--			<c:if test="${requestScope.page.pageNo>1}">--%>
<%--				<a href="${requestScope.page.url}&pageNo=1">首页</a>--%>
<%--				<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>--%>
<%--			</c:if>--%>

<%--			&lt;%&ndash;			页码输出的开始&ndash;%&gt;--%>
<%--			<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">${requestScope.page.pageNo-1}</a>--%>
<%--			【${requestScope.page.pageNo}】--%>
<%--			<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">${requestScope.page.pageNo+1}</a>--%>

<%--			<c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">--%>
<%--				<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>--%>
<%--				<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>--%>
<%--			</c:if>--%>

<%--			共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录--%>
<%--			到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页--%>
<%--			<input id="queryPageButton" type="button" value="确定">--%>


<%--			<script type="text/javascript">--%>
<%--				// 指定页码--%>
<%--				$(function () {--%>
<%--					$("#queryPageButton").click(function () {--%>
<%--						var pageNo = $("#pn_input").val();--%>
<%--						location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;--%>
<%--					})--%>
<%--				})--%>
<%--			</script>--%>
<%--		</div>--%>
<%--&lt;%&ndash;		分页条的结束&ndash;%&gt;--%>
		<%@include file="/pages/common/page_nav.jsp"%>
	</div>

	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>