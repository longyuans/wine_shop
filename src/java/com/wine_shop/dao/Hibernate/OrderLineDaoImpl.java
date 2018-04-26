package com.wine_shop.dao.Hibernate;

import com.wine_shop.bean.OrderLine;
import com.wine_shop.dao.IOrderLineDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderLineDao")
public class OrderLineDaoImpl extends BaseDaoImpl<OrderLine> implements IOrderLineDao {
    @Override
    public void insertOrderLine(OrderLine orderLine) {
        this.getHibernateTemplate().save(orderLine);
    }

    @Override
    public List<OrderLine> queryAllOrderLineByUserId(int id) {
        String hql = "from OrderLine o where o.userId="+id+"";
        return (List<OrderLine>) this.getHibernateTemplate().find(hql);
    }
}
