package com.wine_shop.action;

import com.wine_shop.bean.*;
import com.wine_shop.model.OrderLineModel;
import com.wine_shop.wineService.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller("orderAction")
@Scope("prototype")
public class OrderAction  extends BaseAction<Order>{
    @Autowired
    private IOrderService orderService;

    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }

    public String addOrder(){
        try{
            // 此时的订单状态显示“未付款”
            // 获取收件人
            Receiver receiver = (Receiver) session.get("receiver");
            System.out.println("当前的收货认的信息："+receiver);
            // 获取当前用户
            User user = (User) application.get("user");
            //生成订单
            Order order = new Order();
            order.setUserId(user.getId());
            // 获取订单项
            List<OrderLine> orderLines = (List<OrderLine>) session.get("OrdPro");
            for (OrderLine o : orderLines) {
                order.setProductId(o.getProductId());
            }
            BigDecimal sum_price= (BigDecimal) session.get("confirmSumPrice");
            //long num=(long) Math.random()*10000000;
            order.setMoney(sum_price);//总金额
            order.setNum(orderLines.size());
            order.setCreateTime(new Date());
            order.setPayWay("未付款");
            order.setReceiverId(receiver.getId());
            orderService.insertOrder(order);
            session.put("orderNum", order.getId());
            System.out.println("订单进入付款选择，目前状态：未付款.订单编号："+order.getId());
            response.sendRedirect("Payfor.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }

    //支付订单
    public String payForOrder(){
        try{

    }catch (Exception e){
        e.printStackTrace();
    }
    return "";
    }
}
