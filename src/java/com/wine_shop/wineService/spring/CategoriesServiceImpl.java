package com.wine_shop.wineService.spring;

import com.wine_shop.dao.ICategoriesDao;
import com.wine_shop.bean.Categories;
import com.wine_shop.dao.ICategoryDetailDao;
import com.wine_shop.model.CategoryModel;
import com.wine_shop.wineService.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoriesService")
public class CategoriesServiceImpl implements ICategoriesService {
    @Autowired
    private ICategoriesDao categoriesDao;

    public void setCategoriesDao(ICategoriesDao categoriesDao) {
        this.categoriesDao = categoriesDao;
    }

    @Override
    public List<Categories> queryByHot(boolean b) {
        return null;
    }


    @Override
    public List<Categories> selectAllCategory() {
        List<Categories> categories = categoriesDao.selectAllCategory();
        return categories;
    }

    @Override
    public Categories queryById(int cateId) {
        return categoriesDao.get(cateId);
    }
}
