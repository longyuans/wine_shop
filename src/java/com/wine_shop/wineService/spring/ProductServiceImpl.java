package com.wine_shop.wineService.spring;

import com.wine_shop.bean.Product;
import com.wine_shop.dao.IProductDao;
import com.wine_shop.wineService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements IProductService {
    @Autowired
    private IProductDao productDao;

    public void setProductDao(IProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * 根据大分类查询
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> querByCategoryId(int id) throws Exception{
        List<Product> products = productDao.selectBookByCategoryId(id);
        return products;
    }

    /**
     * 根据热度/推荐查询
     * @param flag
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> selectAllBookByFlag(String flag) throws Exception{
        List<Product> products = productDao.selectAllBookByFlag(flag);
        return products;
    }

    /**
     * 根据小分类查询
     * @param cate_detailId
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> selectProByCate_detail(int cate_detailId) throws Exception {
        List<Product> products = productDao.selectProByCate_detail(cate_detailId);
        return null;
    }

    @Override
    public Product queryProById(int productId) throws Exception{
        return productDao.get(productId);
    }
}