package com.wine_shop.dao.Hibernate;

import com.wine_shop.bean.Product;
import com.wine_shop.dao.IProductDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements IProductDao {
    @Override
    public List<Product> selectAllBookByFlag(String flag) {
        String hql = "from Product p where p.flag ='"+flag+"'";
        return (List<Product>) this.getHibernateTemplate().find(hql);
        //return (List<Product>) getSession().createQuery(hql).();
    }

    @Override
    public List<Product> selectBookByCate_detail(int id) {
        String hql ="from Product p where p.catDetailId ="+id+"";
        return (List<Product>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public List<Product> selectBookByCategoryId(int id) {
        String hql ="from Product p where p.cateId ="+id+"";
        return (List<Product>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public List<Product> selectProductByName(String name) {
        String hql ="from Product p where p.name like '%"+name+"'%";
        return (List<Product>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public List<Product> selectProByCate_detail(int cate_detailId) {
        String hql = "from Product p where p.catDetailId ="+cate_detailId+"";
        return (List<Product>) this.getHibernateTemplate().find(hql);
    }
}
