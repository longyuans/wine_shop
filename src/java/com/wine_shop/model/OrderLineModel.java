package com.wine_shop.model;

import com.wine_shop.bean.Product;
import com.wine_shop.bean.User;

import java.math.BigDecimal;

/**
 * orderLine的模型类
 * 一个用户在db中所有的orderId 为空的orderLine即是其购物车
 */
public class OrderLineModel{
    private Integer id;
    private User user;
    private Product product;
    private String version;
    private Integer amount;
    private BigDecimal totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
