package com.wine_shop.dao.Hibernate;

import com.wine_shop.dao.ICategoriesDao;
import com.wine_shop.bean.Categories;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("categoriesDao")
public class CategoriesDaoImpl extends BaseDaoImpl<Categories> implements ICategoriesDao {

    @Override
    public List<Categories> selectAllCategory() {
        String hql = "from Categories ";
        return (List<Categories>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public Categories selectCategoryById(int id) {
        String hql = "from Categories c where c.id=:id";
        return (Categories) getSession().createQuery(hql).setInteger("id",id).list();
    }
}
