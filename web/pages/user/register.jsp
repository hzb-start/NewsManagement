<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <%@ include file="/pages/common/head_base.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("#sub_btn").click(function () {
                var id = $("#id").val();
                var regExp = /^\w{5,12}$/;
                if (!regExp.test(id)) {
                    $("span.errorMsg").text("登录账号不合法！");
                    return false;
                }
                var password = $("#password").val();
                if (!regExp.test(password)) {
                    $("span.errorMsg").text("登录密码不合法！");
                    return false;
                }
                var re_password = $("#re_password").val();
                if (re_password != password) {
                    $("span.errorMsg").text("两次密码不一致！");
                    return false;
                }
                var sex = $("#sex").val();
                if (!(sex == "男" || sex == "女")) {
                    $("span.errorMsg").text("性别只能为男或女！");
                    return false;
                }
                var email = $("#email").val();
                // 邮箱的正则表达式不是特别准确
                var email_regExp = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!email_regExp.test(email)) {
                    $("span.errorMsg").text("邮箱格式不合法！");
                    return false;
                }
                $("span.errorMsg").text("");
            });
        });
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }
    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
</div>

<div class="login_banner">
    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册</h1>
                    <span class="errorMsg">
                        <%=request.getAttribute("message")==null?"":request.getAttribute("message")%>
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="register">
                        <label>登录账号：</label>
                        <input class="input_class" type="text" placeholder="请输入登录账号"
                               autocomplete="off" tabindex="1" name="id" id="id"/>
                        <br/>
                        <br/>
                        <label>用户姓名：</label>
                        <input class="input_class" type="text" placeholder="请输入用户姓名"
                               value="<%=request.getAttribute("name")==null?"":request.getAttribute("name")%>"
                               autocomplete="off" tabindex="1" name="name" id="name"/>
                        <br/>
                        <br/>
                        <label>登录密码：</label>
                        <input class="input_class" type="password" placeholder="请输入登录密码"
                               autocomplete="off" tabindex="1" name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="input_class" type="password" placeholder="请再次确认密码"
                               autocomplete="off" tabindex="1" name="re_password" id="re_password"/>
                        <br/>
                        <br/>
                        <label>用户性别：</label>
                        <input class="input_class" type="text" placeholder="请输入用户性别"
                               value="<%=request.getAttribute("sex")==null?"":request.getAttribute("sex")%>"
                               autocomplete="off" tabindex="1" name="sex" id="sex"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="input_class" type="text" placeholder="请输入邮箱地址"
                               value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"
                               autocomplete="off" tabindex="1" name="email" id="email"/>
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>