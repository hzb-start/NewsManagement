<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑新闻</title>
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

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">编辑新闻</span>
    <%@ include file="pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <form action="new_manager.jsp">
        <table>
            <tr>
                <td>名称</td>
                <td>待定</td>
                <td>待定</td>
                <td>销量</td>
                <td>热度</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="book_name" type="text" value="新闻标题"/></td>
                <td><input name="book_price" type="text" value="30.00"/></td>
                <td><input name="book_author" type="text" value="作者"/></td>
                <td><input name="book_sales" type="text" value="200"/></td>
                <td><input name="book_stock" type="text" value="300"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<%@ include file="pages/common/footer.jsp"%>
</body>
</html>