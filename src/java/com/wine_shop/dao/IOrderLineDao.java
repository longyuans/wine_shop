package com.wine_shop.dao;

import com.wine_shop.bean.OrderLine;

import java.util.List;

public interface IOrderLineDao extends IBaseDao<OrderLine> {
    void insertOrderLine(OrderLine orderLine);
    /**
     * 查询当前用户购物车商品信息
     * @param id
     * @return
     */
    List<OrderLine> queryAllOrderLineByUserId(int id);
}
