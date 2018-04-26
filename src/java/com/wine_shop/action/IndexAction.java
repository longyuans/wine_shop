package com.wine_shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wine_shop.bean.*;
import com.wine_shop.model.CategoryModel;
import com.wine_shop.wineService.spring.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import javax.servlet.ServletContext;
import java.util.*;

/**
 * 首页
 */
@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport {

    private CategoriesServiceImpl categoriesService;
    private CategoryDetailServiceImpl categoryDetailService;
    private ProductServiceImpl productService;
    private ReportServiceImpl reportService;
    private Map<String,Object> session= ActionContext.getContext().getSession();
    private Map<String,Object> application = ActionContext.getContext().getApplication();

    public void setCategoriesService(CategoriesServiceImpl categoriesService) {
        this.categoriesService = categoriesService;
    }

    public void setCategoryDetailService(CategoryDetailServiceImpl categoryDetailService) {
        this.categoryDetailService = categoryDetailService;
    }

    public void setProductService(ProductServiceImpl productService) {
        this.productService = productService;
    }

    public void setReportService(ReportServiceImpl reportService) {
        this.reportService = reportService;
    }

    public String index_show(){
        try {
            // 查询书的类别名
            List<Categories> list1=categoriesService.selectAllCategory();
            List<CategoryDetail> allCdList=new ArrayList<CategoryDetail>();
            List<CategoryModel> categoryModelList = new ArrayList<>();
            if (CollectionUtils.isEmpty(list1)){

            }
            for(Categories category:list1){
                CategoryModel categoryModel = new CategoryModel();
                categoryModel.setId(category.getId());
                categoryModel.setName(category.getName());
                allCdList=categoryDetailService.selectCate_detailByCateId(category.getId());
                categoryModel.setCategoryDetailList(allCdList);
                //category.setCate_detail(allCdList);
                categoryModelList.add(categoryModel);
            }
            session.put("list", categoryModelList);
            // 简报
            List<Report> Reports = reportService.selectAllReportByName();

            // 底部书的推荐，flag=1，热卖
            List<Product> Products = productService.selectAllBookByFlag("1");

            // 畅销书籍的推荐，flag=3，特推
            List<Product> BestPro = productService.selectAllBookByFlag("3");

            /*//根据书的类别名查询书的详细类别名
            List<CategoryDetail> Literature = mapper.selectCategoryByname("文学类");
            List<CategoryDetail> Education = mapper.selectCategoryByname("教育类");
            List<CategoryDetail> Computer = mapper.selectCategoryByname("计算机");
            List<CategoryDetail> Children = mapper.selectCategoryByname("儿童类");
            List<CategoryDetail> Comics = mapper.selectCategoryByname("漫画类");
            List<CategoryDetail> Tool = mapper.selectCategoryByname("工具类");
            List<CategoryDetail> Periodical = mapper.selectCategoryByname("期刊");*/
            /*session.setAttribute("Literature", Literature);
            session.setAttribute("Education", Education);
            session.setAttribute("Computer", Computer);
            session.setAttribute("Children", Children);
            session.setAttribute("Comics", Comics);
            session.setAttribute("Tool", Tool);
            session.setAttribute("Periodical", Periodical);*/

            session.put("report", Reports);
            session.put("product", Products);
            session.put("bestPro", BestPro);

            User user= (User) application.get("user");
            if(user==null){
                return "index";
            }else{
                return "success";
            }

        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError("似乎加载出了点小问题~");
    }
        return "index";
    }
}
