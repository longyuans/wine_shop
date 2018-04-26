<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

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

<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	function addShopCart(productListname) {
		alert(productListname + "  加入购物车成功!");
	}

	function search() {
		var searchVal = document.getElementById("search").value;
		window.location = "/productList/searchProServlet?searchVal=" + searchVal;
	}

	//根据价格区间排序
	window.onload = function() {
		//找到这个id的元素下的所有a标签
		var choose_prices = $("#choose_price > a");
		var choose_publish = $("#choose_publish > a");
		for ( var i = 0; i < choose_prices.length; i++) {
			var click = choose_prices[i];
			click.onclick = function() {
				var showTag = $("#showTag");
				$(showTag)
						.html(
								"<li><span class='search_key'>价格：</span> <span class='search_val'>"
										+ this.innerHTML
										+ "</span> <span onclick='deleteShowTag()' class='search_del'></span></li>");
				console.log(this.innerHTML);
				var ajax = null;
				var url = "/productList/listServlet?priceRank=" + this.innerHTML
						+ "&&publishRank=" + this.innerHTML;
				//创建ajax对象
				if (window.ActiveXObject) {
					ajax = new ActiveXObject("Microsoft.XMLHTTP");
				}
				if (window.XMLHttpRequest) {
					ajax = new XMLHttpRequest();
				}
				//准备请求
				ajax.open("get", url, true);
				//准备响应
				ajax.onreadystatechange = function() {
					if (ajax.readyState == 4 && ajax.status == 200) {
						var data = ajax.responseText;
						var div = $("#changeDiv");
						div.html(data);
					}
				};
				ajax.send();
			};
		}
	};

	
	$(function() {
		var choose_publish = $("#choose_publish > a");
		console.log(choose_publish);
		for ( var j = 0; j < choose_publish.length; j++) {
			var choose = choose_publish[j];
			choose.onclick = function() {
				var showTag = $("#showTag");
				$(showTag)
						.html(
								"<li><span class='search_key'>出版社：</span> <span class='search_val'>"
										+ this.innerHTML
										+ "</span> <span onclick='deleteShowTag()' class='search_del'></span></li>");
				var ajax = null;
				var url = "/productList/listServlet?publishRank=" + this.innerHTML;
				console.log();
				//创建ajax对象
				if (window.ActiveXObject) {
					ajax = new ActiveXObject("Microsoft.XMLHTTP");
				}
				if (window.XMLHttpRequest) {
					ajax = new XMLHttpRequest();
				}
				//准备请求
				ajax.open("get", url, true);
				//准备响应
				ajax.onreadystatechange = function() {
					if (ajax.readyState == 4 && ajax.status == 200) {
						var data = ajax.responseText;
						var div = $("#changeDiv");
						div.html(data);
					}
				};
				ajax.send();
			};
		}
	});

	//删除选择的区间
	function deleteShowTag() {
		$.get("/productList/listServlet", {
			priceRank : ""
		}, function(data) {
			console.log(data);
			var div = $("#changeDiv");
			div.html(data);
		});
		var showTag = $("#showTag ");
		$(showTag).html("");
	}

	//根据销量、价格、默认排序
	$(function() {
		var OrderDiv = $("#orderBy > li");
		for ( var i = 0; i < OrderDiv.length; i++) {
			var click = OrderDiv[i];
			click.onclick = function() {
				var name = $(this).text();
				$(OrderDiv).css("background-color", "white");
				$(this).css("background-color", "#e4393c");
				var CheckId = null;
				if (name == "销量") {
					CheckId = 1;
				} else if (name == "价格") {
					CheckId = 2;
				} else if (name == "默认") {
					CheckId = 0;
				} else {
					CheckId = 3;
				}
				var ajax = null;
				var url = "/productList/listServlet?CheckId=" + CheckId;
				//创建ajax对象
				if (window.ActiveXObject) {
					ajax = new ActiveXObject("Microsoft.XMLHTTP");
				}
				if (window.XMLHttpRequest) {
					ajax = new XMLHttpRequest();
				}
				//准备请求
				ajax.open("get", url, true);
				//准备响应
				ajax.onreadystatechange = function() {
					if (ajax.readyState == 4 && ajax.status == 200) {
						var data = ajax.responseText;
						var div = $("#changeDiv");
						div.html(data);
					}
				};
				ajax.send();
			};
		}
	});
</script>
</head>
<body>
	<!--顶部-->
	<div class="top">
		<div class="top_center">
			<ul class="top_bars">
				<li><a href="/wine_shop/loginout">退出</a>|</li>
				<li><a href="#">我的订单<span class="jt_down"></span> </a>|</li>
				<li><a href="#">关注杰普<span class="jt_down"></span> </a>|</li>
				<li><a href="#">网站导航<span class="jt_down"></span> </a>
				</li>
			</ul>
		</div>
	</div>
	<!--头部-->
	<div class="header3">
		<a href="/wine_shop/index">
			<img src="images/logo_main.png"> </a>
		<div class="h3_center">
			<div class="search_box">
				<input type="text" id="search" value="" /> <span onclick="search()"
					style="cursor: pointer;">搜索</span>
			</div>
			<p>
				<c:forEach items="${list }" var="list">
					<a
						href="/wine_shop/product?CateName=${list.name}&CateId=${list.id}">${list.name}</a>|
			</c:forEach>
			</p>
		</div>
		<div class="h3_right">
			<div class="myyy">
				<a href="/product/checkuserServlet">个人信息</a> <span class="sj_down"></span>
			</div>
			<div class="tsc">
				<a href="/product/checkCartServlet">去购物车结算</a> <span class="sj_right"></span>
			</div>
		</div>
	</div>
	<!--头部导航-->
	<div class="nav_top">
		<div class="nav_top_center">
			<div>全部图书分类</div>
			<ul>
				<c:forEach items="${list }" var="list">
					<li><a
						href="/wine_shop/product?CateName=${list.name}&CateId=${list.id}">${list.name}</a>|
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<!--内容-->
	<div class="container4">
		<!--热卖-->
		<div class="c4_b1">
			<ul class="c4_b1_boxes">
				<c:forEach items="${product}" var="product" begin="0" end="3">
					<li><img src="${product.images}">
						<div class="c4_b1_box_txt">
							<p>${product.name}</p>
							<h1>
								活动价：<b>${product.getPrice()}</b>
							</h1>
							<h2>
								<a href="/wine_shop/productView?ProId=${product.getId()}">立即抢购</a>
							</h2>
						</div></li>
				</c:forEach>
			</ul>
		</div>
		<div class="c4_b2">
			<h1 class="c4_b2_x">
				<a>${ListName}&nbsp;&nbsp;></a> <span><a>${ListName}</a> </span>
			</h1>

			<ul id="showTag" class="c4_b2_y">
				<!-- <li><span class="search_key">出版社：</span> <span
					class="search _val">清华出版社</span> <span class="search_del"></span>
				</li> -->
			</ul>
		</div>
		<div class="c4_b3">
			<h1></h1>
			<div>
				<ul class="c4_b3_search">
					<li class="c4_b3_name">价格：</li>
					<li id="choose_price" class="c4_b3_vals" style="cursor: pointer;">
						<c:forEach items="priceRanks" var="priceRanks">
							<a>priceRanks.getMinPrice()</a>-
							<a>priceRanks.getMaxPrice()</a>
						</c:forEach>
						<%--<a>0-29</a><a>30-59</a>
						<a>60-99</a> <a>100-159</a> <a>160-219</a> <a>220-249</a> <a>250-299</a>
						<a>300-359</a> <a>360-419</a>--%>
					</li>
				</ul>
				<ul class="c4_b3_search">
					<li class="c4_b3_name">出版社：</li>
					<li class="c4_b3_vals" id="choose_publish" style="cursor: pointer;">
						<c:forEach items="chateaus" var="chateaus">
							<a>chateaus.getName()</a>
						</c:forEach>
						<%--<a>人民出版社</a>
						<a>清华大学出版社</a> <a>电子工业出版社</a> <a>中华书局</a> <a>中信出版社</a> <a>上海译文出版社</a><a>北京大学出版社</a><a>机械工业出版社</a>--%>
					</li>
				</ul>
			</div>
		</div>
		<div class="c4_b4">
			<div class="c4_b4_x">
				<ul id="orderBy" class="c4_b4_nav" style="cursor: pointer;">
					<li class="current"><a>默认</a>
					</li>
					<li><a>销量</a>
					</li>
					<li><a>价格</a>
					</li>
					<li><a>新品</a>
					</li>
				</ul>
				<div class="c4_b4_search">
					<input type="text" /><span>确认</span>
				</div>
				<div class="c4_b4_pages"></div>
				<div class="clear"></div>
			</div>
			<div class="c4_b4_y">
				<ul>
					<li><input type="checkbox"> 仅显示有货</li>
				</ul>
			</div>
		</div>
		<!--商品列表-->
		<div class="c4_b5">
			<div id="changeDiv" class="c4_b5_content">
				<ul class="c4_b5_c_boxes">
					<c:forEach items="${productList}" var="productList">
						<li class="c4_b5_c_box">
							<!--图片-->
							<div class="c4_b5_c_box_pic">
								<div class="c4b5_pic_view">
									<a
										href="/wine_shop/productView?ProName=${productList.getName()}&ProId=${productList.getId()}"><img
										src="${productList.getImages()}"> </a>
								</div>
							</div> <!--价钱-->
							<div class="c4_b5_c_box_txt">
								<h1>${productList.getPrice()}</h1>
								<h3>
									<a
										href="/wine_shop/productView?ProName=${productList.getName()}&ProId=${productList.getId()}">${productList.getName()}</a>
								</h3>
							</div> <!--购买等操作-->
							<div class="c4b5_el">
								<div class="c4b5_el_x">
									<span class="wjx01"></span>
								</div>
							</div>
							<ul class="c4b5_option">
								<li class="shopcar_box"><span class="shopcar01"></span><a
									href="/wine_shop/productView?ProId=${productList.getId()}">加入购物车 </a></li>
							</ul></li>
					</c:forEach>
				</ul>
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
			<p>沪ICP备14033591号-8 杰普briup.com版权所有 杰普软件科技有限公司</p>
			<img src="images/police.png">
		</div>
	</div>

</body>
</html>