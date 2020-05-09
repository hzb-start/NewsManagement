<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <%@ include file="/pages/common/head_base.jsp"%>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>登录</h1>
                    <a href="pages/user/register.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
                        <%=request.getAttribute("message")==null?"请输入用户名或密码":request.getAttribute("message")%>
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="login">
                        <label>登录账号：</label>
                        <input class="input_class" type="text" placeholder="请输入登录账号"
                               autocomplete="off" tabindex="1" name="id"/>
                        <br/>
                        <br/>
                        <label>登录密码：</label>
                        <input class="input_class" type="password" placeholder="请输入登录密码"
                               autocomplete="off" tabindex="1" name="password"/>
                        <br/>
                        <br/>
                        <input type="submit" value="登录" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>