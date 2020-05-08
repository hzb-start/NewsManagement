<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
    <%--    静态包含css、jQuery文件--%>
    <%@ include file="pages/common/head.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word"></span>
<%--    <div>--%>
<%--        <span>欢迎<span class="um_span">黄朝博</span>光临新闻管理系统</span>--%>
<%--        <a href="index.jsp">注销</a>&nbsp;&nbsp;--%>
<%--        <a href="index.jsp">返回</a>--%>
<%--    </div>--%>
    <%@include file="pages/common/login_success_menu.jsp"%>
</div>

<div id="main">
    <h1>注册成功! <a href="index.jsp">转到主页</a></h1>
</div>
<%@ include file="pages/common/footer.jsp"%>
</body>
</html>