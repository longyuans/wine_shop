<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>我的订单页面</title>
<link rel="stylesheet" href="css/fullCar.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
</head>
<body>
	<!--顶部-->
	<div class="top">
		<div class="top_center">
			<ul class="top_bars">
				<li><a href="/Book/removeUserServlet">退出</a>|</li>
				<li><a href="#">关注杰普<span class="jt_down"></span> </a>|</li>
				<li><a href="#">网站导航<span class="jt_down"></span> </a>
				</li>
			</ul>
		</div>
	</div>
	<div class="header3">
		<a href="/Book/checkUserForEmaptyCartServlet"><img
			src="images/logo.png" class="oneImg"> </a>
	</div>
	<!--中间部分-->
	<div class="empty">
		<div class="mainCenter">
			<div class="allCheck">
				<input type="checkbox" id="checkAll" onclick="CheckAll()" />
				<p>全选</p>
				<p class="leftM">商品</p>
				<p class="rightM">单价(元)</p>
				<p class="leftM">数量</p>
				<p class="leftM">小计(元)</p>
				<p class="leftM">操作</p>
			</div>
			<div class="mainPro">
				<div class="aa">
					<input type="checkbox">
				</div>
				<div class="right">
					<c:forEach items="${OrdLine}" var="OrdLine">

						<div class="bb" style="width: 900px;float: left;">
							<input type="checkbox" name="check" value="${OrdLine.getId()}" />
							<img src="${OrdLine.getProduct().getImages()}"> <span>${OrdLine.getProduct().getName()}<br>
							</span>
							<div class="mm">
								<span>${OrdLine.getProduct().getPrice()}</span>
							</div>
							<div class="mm" style="margin-left: 30px">
								<span>${OrdLine.getAmount()}</span>
							</div>
							<div class="ri" style="margin-left: 10px">
								<div class="rig">${OrdLine.getSingle_price()}</div>
							</div>
						</div>
					</c:forEach>
					<div class="delete"
						style="width:177px; height:140px; float: right;background-color: #FFFDF0">
						<div style="text-align: center;color: red;font-size: 16px;margin-top: 60px">删除</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--脚部-->
	<div class="footer3">
		<div class="f3_top">
			<div class="f3_center">
				<div class="ts1">品目繁多 愉悦购物</div>
				<div class="ts2">正品保障 天天低价</div>
				<div class="ts3">极速物流 特色定制</div>
				<div class="ts4">优质服务 以客为尊</div>
			</div>
		</div>
		<div class="f3_middle">
			<ul class="f3_center">
				<li class="f3_mi_li01">
					<h1>购物指南</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p></li>
				<li class="f3_mi_li01">
					<h1>配送方式</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p></li>
				<li class="f3_mi_li01">
					<h1>支付方式</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p></li>
				<li class="f3_mi_li01">
					<h1>售后服务</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p></li>
				<li class="f3_mi_li01">
					<h1>服务保障</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p></li>
				<li class="f3_mi_li06">
					<h1>客服中心</h1> <img src="images/qrcode_jprj.jpg" width="80px"
					height="80px">
					<p>抢红包、疑问咨询、优惠活动</p></li>
			</ul>
		</div>
		<div class="f3_bottom">
			<p class="f3_links">
				<a href="#">关于我们</a>| <a href="#">联系我们</a>| <a href="#">友情链接</a>| <a
					href="#">供货商入驻</a>
			</p>
			<p>沪ICP备14033591号-8 杰普软件briup.com版权所有 杰普软件科技有限公司</p>
			<img src="images/police.png">
		</div>
	</div>
</body>
</html>