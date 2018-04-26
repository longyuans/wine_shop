package com.wine_shop.action;

import com.wine_shop.bean.OrderLine;
import com.wine_shop.bean.Product;
import com.wine_shop.bean.User;
import com.wine_shop.model.OrderLineModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller("orderLineAction")
@Scope("prototype")
public class OrderLineAction extends BaseAction<OrderLine> {

    public String updateOrderLine(){
        try{
            // 获取从购物车选中的商品列表
            User user = (User) application.get("user");
            String[] OrdId = request.getParameterValues("check");
            String[] Amount = request.getParameterValues("amount");
            List<OrderLine> orderLines = new ArrayList<OrderLine>();
            List<OrderLineModel> orderLineModels = new ArrayList<OrderLineModel>();
            BigDecimal sum = null;

            // 更新选中的商品的数量及价格
            for (int i = 0; i < OrdId.length; i++) {
                OrderLineModel orderLineModel = new OrderLineModel();
                OrderLine orderLine = oderLineService.selectOrdLineById( Integer.parseInt(OrdId[i]));
                Product product = productService.queryProById(orderLine.getProductId());
                BigDecimal singlePrice = product.getPrice();
                sum =new BigDecimal(Long.parseLong(Amount[i])).multiply(singlePrice);
                if (Long.parseLong(Amount[i]) == orderLine.getAmount()) {
                    orderLines.add(orderLine);
                } else {
                    orderLine.setAmount(Integer.parseInt(Amount[i]));
                    orderLine.setTotalPrice(singlePrice);
                    orderLines.add(orderLine);
                    oderLineService.updateOrdLine(orderLine);//更新orderLine中的数据，便于查询订单显示商品信息
                }
                orderLineModel.setId(orderLine.getId());
                orderLineModel.setUser(user);
                orderLineModel.setProduct(product);
                orderLineModel.setAmount(orderLine.getAmount());
                orderLineModel.setTotalPrice(orderLine.getTotalPrice());
                orderLineModels.add(orderLineModel);
            }
            session.put("confirmAllNum", orderLines.size());//总件数
            session.put("confirmSumPrice", sum);//总金额
            session.put("OrdPro", orderLineModels);//商品信息
            return "success";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }
}
