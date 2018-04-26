<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-首页</title>
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />

</head>
<body>
	<div class="c4_b5_content">
		<ul class="c4_b5_c_boxes">
			<c:forEach items="${Book}" var="Book">
				<li class="c4_b5_c_box">
					<!--图片-->
					<div class="c4_b5_c_box_pic">
						<div class="c4b5_pic_view">
							<a
								href="/Book/viewBookServlet?ProName=${Book.getName()}&ProId=${Book.getId()}"><img
								src="${Book.getImages()}"> </a>
						</div>
					</div> <!--价钱-->
					<div class="c4_b5_c_box_txt">
						<h1>${Book.getPrice()}</h1>
						<h2>
							<a
								href="/Book/viewBookServlet?ProName=${Book.getName()}&ProId=${Book.getId()}">${Book.getName()}</a>
						</h2>
					</div> <!--购买等操作-->
					<div class="c4b5_el">
						<div class="c4b5_el_x">
							<span class="wjx01"></span>
						</div>
					</div>
					<ul class="c4b5_option">
						<li class="shopcar_box"><span class="shopcar01"></span><a
							href="/Book/viewBookServlet?ProId=${Book.getId()}">加入购物车 </a>
						</li>
					</ul>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
