package com.wine_shop.action;

import com.wine_shop.bean.*;
import com.wine_shop.model.CategoryModel;
import com.wine_shop.model.ProductModel;
import com.wine_shop.wineService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product>{
    @Autowired
    private IProductService productService;

    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    public String showProduct() {
        //产地
        List<Chateau> chateaus = chateauService.queryAllChateaus();
        //价格区间
        List<PriceRank> priceRanks = priceRankService.queryAllPriceRanks();
        session.put("priceRanks",priceRanks);
        session.put("chateaus",chateaus);
        try {
            if (request.getParameter("CateId") != null) {
                String CateName = request.getParameter("CateName");//分类名称
                int CateId = Integer.parseInt(request.getParameter("CateId"));

                List<Product> CateBook = null;
                CateBook = productService.querByCategoryId(CateId);
                session.put("productList", CateBook);
                session.put("ListId", CateId);
                session.put("ListIdFlag", true);
                //获取网址上传递的书的大类名
                CateName = new String(CateName.getBytes("ISO8859-1"), "UTF-8");
                session.put("ListName", CateName);
            } else {
                //根据书的详细分类查询
                int Cate_detailId = Integer.parseInt(request.getParameter("cate_detailId"));
                CategoryDetail categoryDetail = categoryDetailService.selectCate_detailById(Cate_detailId);
                Categories categories = categoriesService.queryById(categoryDetail.getCategoryId());
                List<Product> Cate_detailBook = productService.selectProByCate_detail(Cate_detailId);
                session.put("CateDetail", categoryDetail);
                session.put("productList", Cate_detailBook);
                session.put("ListId", Cate_detailId);
                session.put("ListIdFlag", false);
                session.put("ListName", categories.getName());
            }
            return "success";
        } catch (Exception e) {
            this.addActionError("似乎出了一点小问题~");
            e.printStackTrace();
            return "error";
        }
    }

    public String productView() {
        try {
                int productId = Integer.parseInt(request.getParameter("ProId"));
                if (!request.getParameter("ProId").isEmpty()) {
                    Product product = productService.queryProById(productId);
                    CategoryDetail categoryDetail = categoryDetailService.selectCate_detailById(product.getCatDetailId());
                    Categories categories = categoriesService.queryById(categoryDetail.getCategoryId());
                    Chateau chateau = chateauService.queryChateauById(product.getChateauId());
                    ProductModel productModel = new ProductModel();
                    productModel.setCategories(categories);
                    productModel.setCategoryDetail(categoryDetail);
                    productModel.setProduct(product);
                    productModel.setChateau(chateau);
                    session.put("viewPro", productModel);
                    session.put("ProductId", productId);
                }
                    return "success";
            } catch (Exception e) {
                this.addActionError("似乎出了一点问题");
                e.printStackTrace();
                return "error";
            }
        }
    }
