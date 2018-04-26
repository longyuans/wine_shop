package com.wine_shop.wineService;

import com.wine_shop.bean.Order;
import com.wine_shop.bean.OrderLine;

public interface IOrderService {
    Order selectOrderById(int i);

    void insertOrder(Order order);
}
