package com.wine_shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wine_shop.bean.OrderLine;
import com.wine_shop.bean.Product;
import com.wine_shop.bean.User;
import com.wine_shop.model.OrderLineModel;
import com.wine_shop.wineService.IOderLineService;
import com.wine_shop.wineService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 购物车操作
 */
@Controller("shopCartAction")
@Scope("prototype")
public class ShopCartAction extends ActionSupport{
    @Autowired
    private IProductService productService;
    @Autowired
    private IOderLineService orderLineService;

    public void setOrderLineService(IOderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    @Resource
    protected HttpServletRequest request;
    protected Map<String,Object> session = ActionContext.getContext().getSession();
    private Map<String,Object> application = ActionContext.getContext().getApplication();

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * 加入购物车操作
     * @return
     */
    public String addShopCart() {
        try {
            // 获取用户信息
            if("".equals(application.get("user"))){
                this.addActionError("请登陆！");
            }else {
                User user= (User) application.get("user");

                // 获取加入购物车的商品数量
                int amount = Integer.parseInt(request.getParameter("amount"));
                // 获取商品信息
                int id = (int) request.getSession().getAttribute("ProductId");
                Product product = productService.queryProById(id);
                BigDecimal totalPrice = new BigDecimal(amount).multiply(product.getPrice());
                OrderLine orderLine = new OrderLine();
                orderLine.setAmount(amount);
                orderLine.setCreateTime(new Date());
                orderLine.setProductId(product.getId());
                orderLine.setUserId(user.getId());
                orderLine.setTotalPrice(totalPrice);
                orderLineService.insertOrderLine(orderLine);
                return "success";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "error";
    }
    //查看购物车
    public String shopCart() {
        try{

            if ("".equals(application.get("user"))){

            }else{
                User user= (User) application.get("user");
                int id=user.getId();
                List<OrderLine> orderLines = orderLineService.selectAllOrdLineByUserId(id);
                List<OrderLineModel> orderLineModels = new ArrayList<OrderLineModel>();
                if (!CollectionUtils.isEmpty(orderLines)) {
                    for (OrderLine orderLine:orderLines) {
                        OrderLineModel orderLineModel = new OrderLineModel();
                        Product product=productService.queryProById(orderLine.getProductId());
                        orderLineModel.setId(orderLine.getId());
                        orderLineModel.setUser(user);
                        orderLineModel.setProduct(product);
                        orderLineModel.setAmount(orderLine.getAmount());
                        orderLineModel.setTotalPrice(orderLine.getTotalPrice());
                        orderLineModels.add(orderLineModel);
                    }
                    session.put("OrdLine", orderLineModels);
                    return "success";
                } else {
                    return "empty";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }
}
