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
<title>购物车页面</title>
<link rel="stylesheet" href="css/fullCar.css" />
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<%
	int i = 0;
	int price = 1000;
	int singlePri = 10000;
	int box = 100;
%>
<script type="text/javascript">
	//商品增減

	function add(i,price,singlePri,box) {
		var box=document.getElementById(box);
		if (document.getElementById(i).value <= 1000) {
			document.getElementById(i).value++;
			var chSinglePri = document.getElementById(singlePri);
			var price = document.getElementById(price).innerHTML;
			var amount = document.getElementById(i).value;
			var chSinglePri = amount * price;
			document.getElementById(singlePri).innerHTML = chSinglePri;

			var sum=document.getElementById("Sum").innerText;
			sum=sum*1+price*1;
		} else {
			var price = document.getElementById(price).innerHTML;
			var amount = document.getElementById(i).value;
			document.getElementById(i).value = 1000;
			chSinglePri = chSinglePri * 1 + price * (1000 - amount * 1);
			document.getElementById(singlePri).innerHTML = chSinglePri;

			var sum=document.getElementById("Sum").innerText;
			sum=sum*1+chSinglePri*1;
		}
		if(box.checked==true){
		document.getElementById("Sum").innerText=sum;
		}
	}
	
	function sub(i,price,singlePri,box) {
		var box=document.getElementById(box);
		if (document.getElementById(i).value > 1) {
			document.getElementById(i).value--;
			var price = document.getElementById(price).innerHTML;
			var amount = document.getElementById(i).value;
			chSinglePri = amount * price;
			document.getElementById(singlePri).innerHTML = chSinglePri;

			var sum=document.getElementById("Sum").innerText;
			sum=sum*1-price*1;
		} else {
			document.getElementById(i).value = 1;
			var price = document.getElementById(price).innerHTML;
			chSinglePri = price;
			document.getElementById(singlePri).innerHTML = chSinglePri;

			var sum=document.getElementById("Sum").innerText;
			sum=sum*1;
			}
		if(box.checked==true){
		document.getElementById("Sum").innerHTML=sum;
		}	
	}
	
	
	//商品选中结算
	function checkbox(box,i,price){
	var box=document.getElementById(box);
	var all=document.getElementById("All").innerText;
	var sum=document.getElementById("Sum").innerText;
	var Price = document.getElementById(price).innerHTML;
	var Amount = document.getElementById(i).value;
	var chSinglePri = Amount * Price;
	if(	box.checked==true){
		all++;
		document.getElementById("All").innerText=all;
		sum=sum*1+chSinglePri*1;
		document.getElementById("Sum").innerHTML=sum;		
	}else{
		all--;
		document.getElementById("All").innerText=all;
	
		sum=sum*1-Price*Amount;
		document.getElementById("Sum").innerText=sum;
		}
	}
	
	//全选
	function CheckAll(){
	var check=document.getElementsByName("check");
	var checkAll=document.getElementById("checkAll");
	var singlePri=document.getElementsByClassName("rig");
	if(checkAll.checked==true){
		for(var j=0;j<check.length;j++){
			check[j].checked=true;
			var sum=document.getElementById("Sum").innerText;
			var all=document.getElementById("All").innerText;
			sum = sum*1+singlePri[j].innerHTML*1;
			all++;
			document.getElementById("All").innerText=all;
			document.getElementById("Sum").innerText=sum;
		}		
	}else{
		for(var j=0;j<check.length;j++){
			check[j].checked=false;
			var sum=document.getElementById("Sum").innerText;
			var all=document.getElementById("All").innerText;
			sum=0;
			all=0;
			document.getElementById("Sum").innerText=sum;
			document.getElementById("All").innerText=all;
			}
		}
	}
	
//删除选中的商品
	function deletePro(OrdId){
		var s="/Book/delCartProServlet?OrdId="+OrdId;
		window.location=s;
	}
</script>
</head>
<body>
	<!--顶部-->
	<div class="top">
		<div class="top_center">
			<ul class="top_bars">
				<li><a href="/wine_shop/loginOut">退出</a>|</li>
				<li><a href="#">我的订单<span class="jt_down"></span> </a>|</li>
				<li><a href="#">关注杰普<span class="jt_down"></span> </a>|</li>
				<li><a href="#">网站导航<span class="jt_down"></span> </a></li>
			</ul>
		</div>
	</div>
	<!--头部-->
	<div class="header3">
		<a href="/wine_shop/checkUserForEmaptyCart"><img
			src="images/logo_main.png" class="oneImg"> </a>
		<div class="h3_right">
			<img src="images/play_01.png" alt="">
		</div>

	</div>
	<!--中间部分div-->
	<div class="empty">
		<form action="/wine_shop/updateOrderLine" method="post">
			<div class="peisong">
				<pre>全部商品  </pre>
			</div>
			<div class="mainCenter">
				<div class="allCheck">
					<input type="checkbox" id="checkAll" onclick="CheckAll()"/>
					<p>全选</p>
					<p class="leftM">商品</p>
					<p class="rightM">单价(元)</p>
					<p class="leftM">数量</p>
					<p class="leftM">小计(元)</p>
					<p class="leftM">操作</p>
				</div>
				<div class="mainPro">
					<div class="aa">
						<input type="checkbox"><span id="but">自营</span>
					</div>
					<c:forEach items="${OrdLine}" var="OrdLine">
						<div class="bb">
							<input type="checkbox" id="<%=box%>" onclick="checkbox('<%=box%>','<%=i%>','<%=price%>')" name="check" value="${OrdLine.getId()}" /> 
							<img src="${OrdLine.getProduct().getImages()}"> 
							<span>${OrdLine.getProduct().getName()}<br></span>
							<div class="mm">
								<span id="<%=price%>">${OrdLine.getProduct().getPrice()}</span>
							</div>

							<div class="pro_buy_nums" style="margin-top:30px;margin-right: 50px">
								<input id="<%=i%>" type="text" value="${OrdLine.getAmount()}" name="amount" style="margin-top: 0.1px" />
								<dl>
									<dd onclick="add('<%=i%>','<%=price%>','<%=singlePri%>','<%=box%>')">+</dd>
									<dd onclick="sub('<%=i%>','<%=price%>','<%=singlePri%>','<%=box%>')">-</dd>
								</dl>
							</div>

							<div class="ri">
								<div class="rig" id="<%=singlePri%>">${OrdLine.getTotalPrice()}</div>
							</div>
							<div class="righ">
								<div onclick="deletePro(${OrdLine.getId()})"
									style="cursor:pointer;">删除</div>
							</div>
							<%
								i += 1;
									price += 1;
									singlePri += 1;
									box += 1;
							%>
						</div>
					</c:forEach>
				</div>
				<div class="allButtom">
					<p class="caozuo">
						<input
							style="border: medium; border-image: none; font-size: 18px; margin-top: 20px; margin-left: 20px; background-color: red;cursor: pointer;"
							type="submit" value="去结算">
					</p>
					<span>已选择<font id="All">0</font>件商品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总价(不含运费)：<font
						id="Sum">0</font> </span>
				</div>
			</div>
		</form>
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
			<p>沪ICP备14033591号-8 杰普软件briup.com版权所有 杰普软件科技有限公司</p>
			<img src="images/police.png">
		</div>
	</div>
</body>
</html>
