package com.wine_shop.wineService.spring;

import com.wine_shop.bean.Order;
import com.wine_shop.bean.OrderLine;
import com.wine_shop.dao.Hibernate.OrderDaoImpl;
import com.wine_shop.dao.IOrderDao;
import com.wine_shop.wineService.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;

    public void setOrderDao(IOrderDao orderDao) {
        this.orderDao = orderDao;
    }


    @Override
    public Order selectOrderById(int id) {
        Order order = orderDao.get(id);
        return order;
    }

    @Override
    public void insertOrder(Order order) {
        orderDao.insertOrder(order);
    }
}
