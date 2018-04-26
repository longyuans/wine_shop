<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>付款页面</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<link rel="stylesheet" href="css/orderSure.css" />
<link rel="stylesheet" href="css/fullCar.css" />

</head>
<body>
	<!--顶部-->
	<div class="top">
    	<div class="top_center">
            <ul class="top_bars">
            	<li><a href="/Book/removeUserServlet">退出</a>|</li>
                <li><a href="ShopCart.jsp">我的订单<span class="jt_down"></span></a>|</li>
                <li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
                <li><a href="#">网站导航<span class="jt_down"></span></a></li>
            </ul>
        </div>
    </div>
    <!--头部-->
    <div class="header3">
    	<a href="indexSuccess.jsp"><img src="images/logo.png"  class="oneImg"></a>
        <div class="h3_right">
        	<img src="images/play_03.png" alt="">
        </div>
    </div>
	<!-- 付款部分 -->
<form action="/Book/orderServlet" method="get">
	<div style="width: 81%;margin-left:9.5%;height: 500px;background-color: #fffdf0;">
		<c:forEach items="${payway}" var="payway">
		<div style="float:left; height:150px;width:99.7%;border:1px solid #f4f4f4">
			<div style="float: left;margin-top: 50px;margin-left: 18px"><input style="margin-top: 10px;"  type="radio" name="radio" value="${payway.getId()}"></div> 
			<img style="float: left;margin-top: 30px;margin-left: 40px" src="${payway.getImages()}"> 
			<div style="float:left;margin-left:60px;margin-top: 58px"><p>${payway.getPay_style()} </p></div>
		</div>
		</c:forEach>
		<!-- <div style="float:left; height:150px;width:99.7%;border:1px solid #f4f4f4">
			<div style="float: left;margin-top: 50px;margin-left: 18px"><input style="margin-top: 10px;" type="radio" name="radio" value="微信"></div> 
			<img style="float: left;margin-top: 30px;margin-left: 40px" src="images/wechat.png"> 
			<div style="float:left;margin-left:60px;margin-top: 58px"><p>微信</p></div>
		</div>		
		
		<div style="float:left; height:150px;width:99.7%;border:1px solid #f4f4f4">
			<div style="float: left;margin-top: 50px;margin-left: 18px"><input style="margin-top: 10px;" type="radio" name="radio" value="银行卡支付"></div> 
			<img style="float: left;margin-top: 30px;margin-left: 40px" src="images/yinlian.png"> 
			<div style="float:left;margin-left:50px;margin-top: 58px"><p>银行卡支付</p></div>
		</div>	 -->			
	</div>
		<div class="submit">
    			<span style="margin-right: 11%">应付金额：<font>¥${confirmSumPrice}</font><input style="float: right;width: 100px;height: 40px;background-color: red;font-size: 20px;color: #fff;margin-top:5px;margin-right: 10%;"
	 				type="submit" value="确认付款"/></span>
    	</div>
    	
</form>	 	
    	
    	
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
                	<h1>客服中心</h1>
                    <img src="images/qrcode_jprj.jpg" width="80px" height="80px">
                    <p>抢红包、疑问咨询、优惠活动</p>
                </li>
            </ul>
        </div>
         <div class="f3_bottom">
        	<p class="f3_links">
                <a href="#">关于我们</a>|
                <a href="#">联系我们</a>|
                <a href="#">友情链接</a>|
                <a href="#">供货商入驻</a> 
           	</p>
            <p>沪ICP备14033591号-8 杰普软件briup.com版权所有 杰普软件科技有限公司 </p>
          	<img src="images/police.png">
        </div>
    </div>
</body>
</html>
