package com.wine_shop.dao.Hibernate;

import com.wine_shop.dao.IOrderDao;
import com.wine_shop.bean.Order;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements IOrderDao {
    @Override
    public void insertOrder(Order order) {
        this.getHibernateTemplate().save(order);
    }
}
