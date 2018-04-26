package com.wine_shop.wineService.spring;

import com.wine_shop.dao.Hibernate.BaseDaoImpl;
import com.wine_shop.dao.ICategoryDetailDao;
import com.wine_shop.bean.CategoryDetail;
import com.wine_shop.wineService.ICategoryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryDetailService")
public class CategoryDetailServiceImpl extends BaseDaoImpl<CategoryDetail> implements ICategoryDetailService {
    //注解声明需要添加
    @Autowired
    private ICategoryDetailDao categoryDetailDao;


    public void setCategoryDetailDao(ICategoryDetailDao categoryDetailDao) {
        this.categoryDetailDao = categoryDetailDao;
    }

    public List<CategoryDetail> selectCate_detailByCateId(int cateId) throws Exception {
        List<CategoryDetail> categoryDetails = categoryDetailDao.selectCate_detailByCateId(cateId);
        return categoryDetails;
    }

    @Override
    public CategoryDetail selectCate_detailById(int cate_detailId) {
        CategoryDetail categoryDetail = categoryDetailDao.get(cate_detailId);
        return categoryDetail;
    }
}
