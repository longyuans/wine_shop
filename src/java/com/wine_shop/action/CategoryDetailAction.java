package com.wine_shop.action;

import com.wine_shop.bean.CategoryDetail;
import com.wine_shop.wineService.spring.CategoryDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("categoryDetailAction")
@Scope("prototype")
public class CategoryDetailAction extends BaseAction<CategoryDetail>{
    @Autowired
    private CategoryDetailServiceImpl categoryDetailService;

    public void setCategoryDetailService(CategoryDetailServiceImpl categoryDetailService) {
        this.categoryDetailService = categoryDetailService;
    }

    public CategoryDetailServiceImpl getCategoryDetailService() {
        return categoryDetailService;
    }
}
