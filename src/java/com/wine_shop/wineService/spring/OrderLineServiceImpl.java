package com.wine_shop.wineService.spring;

import com.wine_shop.bean.OrderLine;
import com.wine_shop.dao.IOrderLineDao;
import com.wine_shop.wineService.IOderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderLineService")
@Transactional
public class OrderLineServiceImpl extends BaseServiceImpl<OrderLine> implements IOderLineService {
    @Autowired
    private IOrderLineDao orderLineDao;

    public void setOrderLineDao(IOrderLineDao orderLineDao) {
        this.orderLineDao = orderLineDao;
    }

    @Override
    public void insertOrderLine(OrderLine orderLine) {
        orderLineDao.insertOrderLine(orderLine);
    }

    @Override
    public List<OrderLine> selectAllOrdLineByUserId(int id) {
        List<OrderLine> orderLines = orderLineDao.queryAllOrderLineByUserId(id);
        return orderLines;
    }

    @Override
    public OrderLine selectOrdLineById(int id) {
        OrderLine orderLine = orderLineDao.get(id);
        return orderLine;
    }

    @Override
    public void updateOrdLine(OrderLine orderLine) {
        orderLineDao.update(orderLine);
    }
}
