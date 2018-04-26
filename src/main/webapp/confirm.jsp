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
<title>结算页面</title>
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<link rel="stylesheet" href="css/orderSure.css" />
<%
	int i = 0;
	int Newname = 1000;
	int Newaddress = 10000;
	int Newphone = 1000000;
%>
<script type="text/javascript">
	function a(i,Newname,Newaddress,Newphone){
			var check=document.getElementById(i);
			console.log(check);
			Newname = document.getElementById(Newname).innerHTML;
			console.log(Newname);
			document.getElementsByName("name")[0].value = Newname;
		  
			Newaddress = document.getElementById(Newaddress).innerHTML;
			document.getElementsByName("address")[0].value = Newaddress;
			
			Newphone = document.getElementById(Newphone).innerHTML;
			document.getElementsByName("phone")[0].value = Newphone;					
	}
	
	function deleteReceiver(ReceiverId){
	var s="/Book/deleteReceiverServlet?ReceiverId="+ReceiverId;
		window.location=s;
	}
</script>
</head>
<body>
	<!--顶部-->
	<div class="top">
		<div class="top_center">
			<ul class="top_bars">
				<li><a href="index.html">退出</a>|</li>
				<li><a href="#">我的订单<span class="jt_down"></span> </a>|</li>
				<li><a href="#">关注杰普<span class="jt_down"></span> </a>|</li>
				<li><a href="#">网站导航<span class="jt_down"></span> </a></li>
			</ul>
		</div>
	</div>
	<!--头部-->
	<div class="header3">
		<a href="/Book/checkUserForEmaptyCartServlet"><img
			src="images/logo.png" class="oneImg"> </a>


		<div class="h3_right">
			<img src="images/play_02.png" alt="">
		</div>

	</div>
	<p class="orderButtom">填写并核对订单信息</p>
	<!--中间复杂部分-->
	<form action="/Book/receiverServlet" method="get">
		<div class="content">
			<div class="contentCenter">
				<div class="centerTop">
					<p style="font-size:15px;" class="p">
						<b style="font-size:20px;">收货人信息</b><br /> <br /> 收件人姓名：<input
							type="text" name="name" value=""><br /> <br /> 收件人地址：<input
							type="text" name="address" value=""><br /> <br />
						收件人电话：<input type="text" name="phone" value=""><br /> <br />
						<!-- <input type="submit" value="添加收货人信息"
							style="border: none;background-color: red;width: 150px;height: 30px;margin-left: 150px"> -->
					</p>
					<div class="right">
						<c:forEach items="${receiver}" var="receiver">
							<div class="bb" id="<%=i%>"
								onclick="a(<%=i%>,<%=Newname%>,<%=Newaddress%>,<%=Newphone%>)"
								style="cursor: pointer;">
								<div class="name" style="margin-left: 50px;">
									<div style="font-size: 18px;" id="<%=Newname%>">${receiver.getName()}</div>
								</div>
								<div class="address" style="margin-left: 50px;">
									<div style="font-size: 18px;" id="<%=Newaddress%>">${receiver.getAddress()}</div>
								</div>
								<div class="phone" style="margin-left: 50px;">
									<div style="font-size: 18px;" id="<%=Newphone%>">${receiver.getPhone()}</div>
								</div>
								<%
									i += 1;
										Newname += 1;
										Newaddress += 1;
										Newphone += 1;
								%>
							</div>
							<div class="delete" id="delete"
								onclick="deleteReceiver('${receiver.getId()}')">删除</div>
						</c:forEach>
					</div>
				</div>

				<p class="singleP">
					<b>送货清单</b><span><a href="shopCart.jsp">返回修改购物车</a> </span>
				</p>
				<div class="bigDiv">
					<div class="twoDiv">
						<b>商家：briup自营</b>
						<ul class="oneUL">
							<c:forEach items="${OrdPro}" var="OrdPro">
								<li><img src="${OrdPro.getProduct().getImages()}"
									class="pic">
									<p>${OrdPro.getProduct().getCate_detail().getCategory().getName()}&nbsp;&nbsp;${OrdPro.getProduct().getCate_detail().getName()}&nbsp;&nbsp;${OrdPro.getProduct().getName()}&nbsp;&nbsp;</p>
									<p>
										<font>¥ ${OrdPro.getProduct().getPrice()}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;×${OrdPro.getAmount()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有货
									</p>
									<p>
										<img src="images/sureLogo_14.png" alt=""><span>${OrdPro.getProduct().getService_th()}七天无理由退换货</span>
									</p></li>
								<li><br /> <pre>【赠品】  高级定制干花书签  随机  ×1</pre>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<div class="money">
					<span><font>${confirmAllNum}</font>件商品，总商品金额：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥
						${confirmSumPrice}</span> <span><img src="images/sureLogo_18.png"
						alt="">运费：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.00</span>

					<span>应付总额：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥
						${confirmSumPrice}</span>
				</div>
				<div class="submit">
					<span>应付金额：<font>¥ ${confirmSumPrice}</font> <input
						type="submit" value="提交订单"
						style="width: 120px;height: 40px;border: none;background-color: red;margin-left: 80px;" />
					</span>
				</div>
			</div>
		</div>
	</form>
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
