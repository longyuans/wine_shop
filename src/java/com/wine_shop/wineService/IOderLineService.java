package com.wine_shop.wineService;

import com.wine_shop.bean.OrderLine;

import java.util.List;
import java.util.Set;

public interface IOderLineService extends IBaseService<OrderLine> {
    /**
     * 添加购物车
     * @param orderLine
     */
    void insertOrderLine(OrderLine orderLine);

    /**
     * 查看当前用户的购物车中的所有商品信息
     * @param id
     * @return
     */
    List<OrderLine> selectAllOrdLineByUserId(int id);

    OrderLine selectOrdLineById(int i);

    void updateOrdLine(OrderLine orderLine);
}
