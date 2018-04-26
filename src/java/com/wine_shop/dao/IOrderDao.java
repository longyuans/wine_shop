package com.wine_shop.dao;

import com.wine_shop.bean.Order;

public interface IOrderDao extends IBaseDao<Order>{
    void insertOrder(Order order);
}
