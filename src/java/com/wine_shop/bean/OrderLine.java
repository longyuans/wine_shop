package com.wine_shop.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "order_line", schema = "wine_shop", catalog = "")
public class OrderLine {
    private int id;
    private int userId;
    private Integer orderId;
    private int productId;
    private String version;
    private int amount;
    private BigDecimal totalPrice;
    private Date createTime;


    public OrderLine(int id, int productId, int amount, BigDecimal totalPrice, Date createTime) {
        this.id=id;
        this.amount=amount;
        this.productId = productId;
        this.amount=amount;
        this.totalPrice=totalPrice;
        this.createTime = createTime;
    }

    public OrderLine() {
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "order_id")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "total_price")
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderLine orderLine = (OrderLine) o;

        if (id != orderLine.id) return false;
        if (userId != orderLine.userId) return false;
        if (productId != orderLine.productId) return false;
        if (amount != orderLine.amount) return false;
        if (orderId != null ? !orderId.equals(orderLine.orderId) : orderLine.orderId != null) return false;
        if (version != null ? !version.equals(orderLine.version) : orderLine.version != null) return false;
        if (totalPrice != null ? !totalPrice.equals(orderLine.totalPrice) : orderLine.totalPrice != null) return false;
        if (createTime != null ? !createTime.equals(orderLine.createTime) : orderLine.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + productId;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

}
