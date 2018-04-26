package com.wine_shop.action;

import com.wine_shop.bean.Categories;
import com.wine_shop.wineService.ICategoriesService;
import com.wine_shop.wineService.spring.CategoriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("categoriesAction")
@Scope("prototype")
public class CategoriesAction extends BaseAction<Categories>{
    @Autowired
    private ICategoriesService categoriesService;

    public void setCategoriesService(ICategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

}
