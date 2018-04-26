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

<script type="text/javascript">
	function submitTest(){
        //判断用户是否登陆
        $.post("${pageContext.request.contextPath}/user",function(data){
        var result = JSON.parse(data);
        if(result.code != 1 ){
        alert("您还未登陆，请登陆！")
        return;
        }

        });

        }
	function search() {
		var searchVal = document.getElementById("search").value;
		window.location = "/wine_shop/searchPro?searchVal=" + searchVal;
	}

	//控制商品展览信息
	function introduction() {
		document.getElementById(1).className = "current";
		document.getElementById(2).className = "";
		document.getElementById(3).className = "";
		document.getElementById(4).className = "";

		document.getElementById(5).style.display = "";
		document.getElementById(6).style.display = "none";
		document.getElementById(7).style.display = "none";
		document.getElementById(8).style.display = "none";
	}

	function parameter() {
		document.getElementById(1).className = "";
		document.getElementById(2).className = "current";
		document.getElementById(3).className = "";
		document.getElementById(4).className = "";

		document.getElementById(5).style.display = "none";
		document.getElementById(6).style.display = "";
		document.getElementById(7).style.display = "none";
		document.getElementById(8).style.display = "none";
	}
	function Packing_list() {
		document.getElementById(1).className = "";
		document.getElementById(2).className = "";
		document.getElementById(3).className = "current";
		document.getElementById(4).className = "";

		document.getElementById(5).style.display = "none";
		document.getElementById(6).style.display = "none";
		document.getElementById(7).style.display = "";
		document.getElementById(8).style.display = "none";
	}
	function evaluation() {
		document.getElementById(1).className = "";
		document.getElementById(2).className = "";
		document.getElementById(3).className = "";
		document.getElementById(4).className = "current";

		document.getElementById(5).style.display = "none";
		document.getElementById(6).style.display = "none";
		document.getElementById(7).style.display = "none";
		document.getElementById(8).style.display = "";
	}
	//商品增減
	function add() {
		if (document.getElementById("changevalue").value <= 1000) {
			document.getElementById("changevalue").value++;
		} else {
			document.getElementById("changevalue").value = 1000;
		}
	}
	function sub() {
		if (document.getElementById("changevalue").value > 1) {
			document.getElementById("changevalue").value--;
		} else {
			document.getElementById("changevalue").value = 1;
		}
	}
	//商品版本信息
	function version(version, red, white1, white2) {
		document.getElementById("Paperback").style.backgroundColor = red;
		document.getElementById("Hardback").style.backgroundColor = white1;
		document.getElementById("Collection").style.backgroundColor = white2;
		document.getElementById("chooseVer").value = version;
	}
</script>

</head>
<body>
	<!--顶部-->
	<div class="top">
		<div class="top_center">
			<ul class="top_bars">
				<li><a href="/Book/removeUserServlet">退出</a>|</li>
				<li><a href="#">我的订单<span class="jt_down"></span> </a>|</li>
				<li><a href="#">关注杰普<span class="jt_down"></span> </a>|</li>
				<li><a href="#">网站导航<span class="jt_down"></span> </a></li>
			</ul>
		</div>
	</div>
	<!--头部-->
	<div class="header3">
		<a href="/Book/checkUserForEmaptyCartServlet"><img src="images/logo_main.png"> </a>
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
				<a href="/wine_shop/user_info">个人信息</a> <span class="sj_down"></span>
			</div>
			<div class="tsc">
				<a href="/wine_shop/shopCart">去购物车结算</a> <span class="sj_right"></span>
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

	<div class="container5">
		<div class="cn5_top">
			<div class="cn5_top_x center01">
				<a class="font20" href="/wine_shop/index">洋酒</a> >
				<a href="/wine_shop/product">${viewPro.getCategories().getName()}</a>
			</div>
			<form action="/wine_shop/addShopCart" method="post" onsubmit="return submitTest();">
				<div class="cn5_top_y center01">
					<div class="cn5topy_1">
						<div class="cn5topy_imgview">
							<img src="${viewPro.getProduct().getImages()}" />
							<ul class="cn5topy_imglist">
								<li><a href="#"><img src="${viewPro.getProduct().getImages()}">
								</a></li>
								<li class="current">
									<a href="#">
										<img src="${viewPro.getProduct().getImages()}">
									</a>
								</li>
								<li><a href="#"><img src="${viewPro.getProduct().getImages()}">
								</a></li>
								<li><a href="#"><img src="${viewPro.getProduct().getImages()}">
								</a></li>
								<li><a href="#"><img src="${viewPro.getProduct().getImages()}">
								</a></li>
							</ul>
						</div>
					</div>
					<div class="cn5topy_2">
						<h1 class="pro_title font15">${viewPro.getProduct().getName()}</h1>
						<div class="pro_price">
							<div class="pro_price_x">
								<p>
									价格：<b>${viewPro.getProduct().getPrice()}</b> <a href="#">(降价通知)</a>
								</p>
							</div>

						</div>
						<div class="pro_ship">
							<div>
								<div class="pro_key fl">服&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：</div>
								<ul class="pro_service f1">
									<li class="service_fq">${viewPro.getProduct().getServiceFg()}</li>
									<li class="service_myf">${viewPro.getProduct().getServiceMyf() }</li>
									<li class="service_zt">${viewPro.getProduct().getServiceZt() }</li>
									<li class="service_th">${viewPro.getProduct().getServiceTh() }</li>
								</ul>
							</div>
						</div>
						<div class="pro_selects">
							<div class="pro_select">
								<div class="pro_key pro_key_vertical fl">选择版本：</div>
								<input type="hidden" id="chooseVer" name="version" value="Ver">
								<ul class="pro_select_vals">
									<li id="Paperback"
										onclick="version('${version[2]}','red','white','white')">${version[2]}</li>
									<li id="Hardback"
										onclick="version('${version[1]}','white','red','white')">${version[1]}</li>
									<li id="Collection"
										onclick="version('${version[4]}','white','white','red')">${version[4]}</li>
								</ul>
							</div>
						</div>

						<div class="pro_buy">
							<div class="pro_buy_nums">
								<input id="changevalue" type="text" value="1" name="amount" />
								<dl>
									<dd onclick="add()">+</dd>
									<dd onclick="sub()">-</dd>
								</dl>
							</div>

							<input id="submit" type="submit" class="pro_addshop" value="加入购物车" />
						</div>
					</div>
				</div>
			</form>
		</div>

		<div class="c5_b2">
			<div class="c5_b2_right">
				<!--选项卡-->
				<ul class="c5_b2_tabs">
					<li id="1" onclick="introduction()">商品介绍</li>
					<li id="2" onclick="parameter()" class="current">规格参数</li>
					<li id="3" onclick="Packing_list()">包装清单</li>
					<li id="4" onclick="evaluation()">商品评价</li>
				</ul>
				<!--内容-->
				<!-- 商品介绍 -->
				<div class="c5_b2_right_1 box">
					<div id="5" class="introduce_item" style="display: none;">
						<ul>
							<li>商品名称：${viewPro.getProduct().getName()}</li>
							<li>厂址：${viewPro.getChateau().getName()}</li>
							<li>配料：配料表：水、小麦、大麦芽、杜松子、...</li>
							<li>储藏方法：常温避光</li>
							<li>保质期：9999999 天</li>
							<li>食品添加剂：见后标</li>
							<li>体积(ml): 750</li>
							<li>是否为有机食品: 否</li>
							<li>系列: 哥顿金酒</li>
							<li>酒精度数: 中度酒（38%≤A≤50%）</li>
							<li>包装方式: 包装</li>
							<li>包装种类: 瓶装</li>
							<li>度数：${viewPro.getProduct().getAlcoholContent()}</li>
							<li>年份：3年</li>

						</ul>
					</div>

					<!-- 规格参数 -->
					<div id="6" class="introduce_item">
						<ul>
							<li>商品名称：${viewPro.getProduct().getName()}</li>
							<li>商品编号：${viewPro.getProduct().getIdentifier()}</li>
						</ul>
					</div>
					<!-- 包装清单 -->
					<div id="7" class="introduce_item" style="display: none;">
						<ul>
							<li>包装清单：精美礼盒</li>
							<li>&nbsp;&nbsp;&nbsp;${viewPro.getProduct().getName()}x1</li>
						</ul>
					</div>
					<!-- 商品评价 -->
					<div id="8" class="introduce_item" style="display: none;">
						<ul>
							<li>商品评价：${viewPro.getProduct().getEvaluates()}</li>
							<li class="fr"><a class="color_link1" href="#">更多>></a>
							</li>
						</ul>
					</div>
				</div>
				<div class="intro_pics">
					<img class="intro_pic" src="${viewPro.getProduct().getFeatureImages()}">
				</div>
			</div>

			<div class="c5_b2_right">
				<div class="c5_b2_right_2">
					<h1>正品行货</h1>
					<p>briup网上商城向您保证所售商品均为正品，briup自营商品开具机打发票或电子发票。</p>

					<h1>全国联保</h1>
					<p>凭质保证书及briup网上商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。briup网上商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！</p>

					<h1>正品行货</h1>
					<p>briup网上商城向您保证所售商品均为正品，briup自营商品开具机打发票或电子发票。</p>

					<h1>全国联保</h1>
					<p>凭质保证书及briup网上商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。briup网上商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！</p>

				</div>
			</div>

			<!--左侧栏-->
			<div class="c5_b2_left_container">
				<div class="c5_b2_left box">
					<h1>服务时间 早9：00~凌晨1：00</h1>
					<p>
						<a href="#"> <img class="callmebyqq"
							src="images/icon_qq_03.png" /> </a>
					</p>
				</div>

				<div class="c5_b2_left box">
					<h1>其他种类</h1>
					<dl>
						<dd>文学类</dd>
						<dd>漫画类</dd>
						<dd>通书类</dd>
					</dl>
					<dl>
						<dd>文学类</dd>
						<dd>漫画类</dd>
						<dd>通书类</dd>
					</dl>
				</div>
			</div>
		</div>
	</div>
	<div class="c20"></div>
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
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li01">
					<h1>配送方式</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li01">
					<h1>支付方式</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li01">
					<h1>售后服务</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li01">
					<h1>服务保障</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li06">
					<h1>客服中心</h1> <img src="images/qrcode_jprj.jpg" width="80px"
					height="80px">
					<p>抢红包、疑问咨询、优惠活动</p>
				</li>
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
