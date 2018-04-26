package com.wine_shop.dao.Hibernate;

import com.wine_shop.dao.ICategoryDetailDao;
import com.wine_shop.bean.CategoryDetail;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryDetailDao")
public class CategoryDetailDaoImpl extends BaseDaoImpl<CategoryDetail> implements ICategoryDetailDao {
    @Override
    public List<CategoryDetail> selectCate_detailByCateId(int cateId) throws Exception {
        String hql ="from CategoryDetail c where c.categoryId ="+cateId+"";
        return (List<CategoryDetail>) this.getHibernateTemplate().find(hql);
    }
}
