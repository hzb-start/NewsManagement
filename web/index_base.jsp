<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>新闻首页</title>
	<%@ include file="pages/common/head.jsp"%>
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
		<div id="book">
			<div class="book_cond">
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
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="static/img/xiaobai.jpg" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">id:</span>
						<span class="sp2">新闻标题</span>
					</div>
					<div class="book_author">
						<span class="sp1">待定:</span>
						<span class="sp2">作者</span>
					</div>
					<div class="book_price">
						<span class="sp1">待定:</span>
						<span class="sp2">XXX</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">230</span>
					</div>
					<div class="book_amount">
						<span class="sp1">热度:</span>
						<span class="sp2">1000</span>
					</div>
					<div class="book_add">
						<button>查看详情</button>
					</div>
				</div>
			</div>
			
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="static/img/xiaobai.jpg" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">id:</span>
						<span class="sp2">新闻标题</span>
					</div>
					<div class="book_author">
						<span class="sp1">待定:</span>
						<span class="sp2">作者</span>
					</div>
					<div class="book_price">
						<span class="sp1">待定:</span>
						<span class="sp2">XXX</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">230</span>
					</div>
					<div class="book_amount">
						<span class="sp1">热度:</span>
						<span class="sp2">1000</span>
					</div>
					<div class="book_add">
						<button>查看详情</button>
					</div>
				</div>
			</div>
			
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="static/img/xiaobai.jpg" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">id:</span>
						<span class="sp2">新闻标题</span>
					</div>
					<div class="book_author">
						<span class="sp1">待定:</span>
						<span class="sp2">作者</span>
					</div>
					<div class="book_price">
						<span class="sp1">待定:</span>
						<span class="sp2">XXX</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">230</span>
					</div>
					<div class="book_amount">
						<span class="sp1">热度:</span>
						<span class="sp2">1000</span>
					</div>
					<div class="book_add">
						<button>查看详情</button>
					</div>
				</div>
			</div>
			
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="static/img/xiaobai.jpg" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">id:</span>
						<span class="sp2">新闻标题</span>
					</div>
					<div class="book_author">
						<span class="sp1">待定:</span>
						<span class="sp2">作者</span>
					</div>
					<div class="book_price">
						<span class="sp1">待定:</span>
						<span class="sp2">XXX</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">230</span>
					</div>
					<div class="book_amount">
						<span class="sp1">热度:</span>
						<span class="sp2">1000</span>
					</div>
					<div class="book_add">
						<button>查看详情</button>
					</div>
				</div>
			</div>
		</div>
		
		<div id="page_nav">
		<a href="#">首页</a>
		<a href="#">上一页</a>
		<a href="#">3</a>
		【4】
		<a href="#">5</a>
		<a href="#">下一页</a>
		<a href="#">末页</a>
		共10页，30条记录 到第<input value="4" name="pn" id="pn_input"/>页
		<input type="button" value="确定">
		</div>
	
	</div>
	
	<%@ include file="pages/common/footer.jsp"%>
</body>
</html>