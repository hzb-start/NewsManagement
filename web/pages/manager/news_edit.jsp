<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑新闻</title>
    <%@ include file="/pages/common/head_base.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">编辑新闻</span>
    <%@ include file="/pages/common/manager_menu.jsp"%>
</div>

<div align="center">
    ${empty param.id?"addNews":"updateNews"}
</div>

<div id="main">
    <form action="manager/newsServlet" method="post">
        <input type="hidden" name="pageNo" value="${param.pageNo}">
        <input type="hidden" name="action" value="${empty param.id?"addNews":"updateNews"}"/>
        <table>
            <tr>
                <td>title</td>
                <td>author</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <input  name="id" type="hidden" value="${requestScope.news.id}"/>
<%--                <input  name="enterdate" type="hidden" value="${requestScope.news.enterdate.toString()}"/>--%>
<%--                <input  name="hot" type="hidden" value="${requestScope.news.hot.toString()}"/>--%>
<%--                <input  name="enterdate" type="hidden" value="${requestScope.news.enterdate}"/>--%>
<%--                <input  name="hot" type="hidden" value="${requestScope.news.hot}"/>--%>
                <td><input name="title" type="text" value="${requestScope.news.title}"/></td>
                <td><input name="author" type="text" value="${requestScope.news.author}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>

        <div align="center">
            <textarea name="content" cols="70" rows="12">${requestScope.news.content}</textarea>
        </div>

    </form>


</div>

<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>