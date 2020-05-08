<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
<%--    <!--写base标签，固定相对路径的跳转结果-->--%>
<%--<!--    <base href="http://localhost:8080/NewsManagement/">-->--%>
<%--    <link type="text/css" rel="stylesheet" href="static/css/style.css">--%>
<%--    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>--%>
<%--    静态包含css、jQuery文件--%>
    <%@ include file="pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            // 给注册绑定单击事件
            // 验证id：必须由字母，数字下划线组成，并且长度为5到12位
            // 验证password：必须由字母，数字下划线组成，并且长度为5到12位
            // 验证两次密码是否一致
            // 1 获取XXX输入框里的内容
            // 2 创建正则表达式对象
            // 3 使用test方法验证
            // 4 提示用户结果
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
                // 验证码：现在只需要验证用户已输入。服务器生成，后续加
                // var codeText = $("#code").val();
                // 去掉验证码前后空格
                // alert("去空格前：["+codeText+"]")
                // codeText = $.trim(codeText);
                // alert("去空格后：["+codeText+"]")
                // if (codeText == null || codeText == "") {
                // 	$("span.errorMsg").text("验证码不能为空！");
                // 	return false;
                // }
                // 去掉错误信息
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
    <img class="logo_img" alt="" src="static/img/logo.gif">
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
<%@ include file="pages/common/footer.jsp"%>
</body>
</html>