package com.wine_shop.dao;

import com.wine_shop.bean.CategoryDetail;

import java.util.List;

public interface ICategoryDetailDao extends IBaseDao<CategoryDetail>{
    List<CategoryDetail> selectCate_detailByCateId(int id) throws Exception;// 根据书的大分类的id查询书的详细分类
}
