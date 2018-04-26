package com.wine_shop.dao;

import com.wine_shop.bean.Categories;

import java.util.List;

public interface ICategoriesDao extends IBaseDao<Categories>{
    List<Categories> selectAllCategory();// 查询所有的书的大分类

    Categories selectCategoryById(int id);// 根据id查询书的大分类
}
