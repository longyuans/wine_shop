package com.wine_shop.wineService;

import com.wine_shop.bean.Categories;
import com.wine_shop.model.CategoryModel;

import java.util.List;

public interface ICategoriesService {
    List<Categories> queryByHot(boolean b);

    List<Categories> selectAllCategory();

    Categories queryById(int cateId);
}
