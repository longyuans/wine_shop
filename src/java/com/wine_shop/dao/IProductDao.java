package com.wine_shop.dao;

import com.wine_shop.bean.Product;

import java.util.List;

public interface IProductDao extends IBaseDao<Product>{
    /**
     * 根据热卖/热推标志查询
     * @param flag
     * @return
     */
   public List<Product> selectAllBookByFlag(String flag);

    List<Product> selectBookByCate_detail(int id);// 根据书的详细分类id查询书

    List<Product> selectBookByCategoryId(int id);// 根据书的大分类ID查询书

    // 根据输入框信息模糊查询
    List<Product> selectProductByName(String name);

    //根据小分类查询
    List<Product> selectProByCate_detail(int cate_detailId);
}
