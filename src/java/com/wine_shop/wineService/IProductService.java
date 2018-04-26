package com.wine_shop.wineService;

import com.wine_shop.bean.Product;

import java.util.List;

public interface IProductService {
    /**
     * 根据分类查询酒
     * @param id
     * @return
     */
    List<Product> querByCategoryId(int id) throws Exception;

    /**
     * 查询热卖酒
     * @return
     */
    List<Product> selectAllBookByFlag(String flag) throws Exception;

    /**
     * 根据小分类查询
     * @param cate_detailId
     * @return
     */
    List<Product> selectProByCate_detail(int cate_detailId) throws Exception;

    /**
     * 根据id查询酒的详细信息
     * @param productId
     * @return
     */
    Product queryProById(int productId) throws Exception;
}
