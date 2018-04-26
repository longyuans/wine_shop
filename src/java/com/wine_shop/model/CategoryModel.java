package com.wine_shop.model;

import com.wine_shop.bean.CategoryDetail;

import java.util.List;

/**
 * 为catecategories的映射,以及添加业务相关的字段
 */
public class CategoryModel {
    private Integer id;

    private String name;

    private List<CategoryDetail> categoryDetailList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryDetail> getCategoryDetailList() {
        return categoryDetailList;
    }

    public void setCategoryDetailList(List<CategoryDetail> categoryDetailList) {
        this.categoryDetailList = categoryDetailList;
    }
}
