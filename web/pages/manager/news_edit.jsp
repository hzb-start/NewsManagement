<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑新闻</title>
    <%--    静态包含css、jQuery文件--%>
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

<div id="main">
    <form action="newsServlet?action=addNews" >
        <table>
            <tr>
                <td>title</td>
                <td>author</td>
                <td>hot</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="title" type="text" value="title"/></td>
                <td><input name="author" type="text" value="author"/></td>
                <td><input name="content" type="text" value="content"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
        <textarea name="content" cols="55" rows="15">content</textarea>
    </form>


</div>

<%@ include file="pages/common/footer.jsp"%>
</body>
</html>