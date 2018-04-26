package com.wine_shop.model;

import com.wine_shop.bean.Categories;
import com.wine_shop.bean.CategoryDetail;
import com.wine_shop.bean.Chateau;
import com.wine_shop.bean.Product;

import java.math.BigDecimal;

public class ProductModel {
    private Product product;
    private Categories categories;//分类
    private Chateau chateau;//产地
    private CategoryDetail categoryDetail;//详细分类

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Chateau getChateau() {
        return chateau;
    }

    public void setChateau(Chateau chateau) {
        this.chateau = chateau;
    }

    public CategoryDetail getCategoryDetail() {
        return categoryDetail;
    }

    public void setCategoryDetail(CategoryDetail categoryDetail) {
        this.categoryDetail = categoryDetail;
    }
}
