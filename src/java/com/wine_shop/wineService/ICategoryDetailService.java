package com.wine_shop.wineService;

import com.wine_shop.bean.CategoryDetail;

import java.util.List;

public interface ICategoryDetailService extends IBaseService<CategoryDetail>{
    List<CategoryDetail> selectCate_detailByCateId(int cateId) throws  Exception;// 根据书的大分类的id查询书的详细分类

    CategoryDetail selectCate_detailById(int cate_detailId);
}
