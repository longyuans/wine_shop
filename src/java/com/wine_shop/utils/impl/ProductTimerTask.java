package com.wine_shop.utils.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import com.wine_shop.bean.Categories;
import com.wine_shop.bean.Product;
import com.wine_shop.wineService.ICategoriesService;
import com.wine_shop.wineService.IProductService;
import org.springframework.stereotype.Component;
/**
 * @Description: TODO(设置任务：run方法中用来加载首页商品信息)
 * @author Ni Shengwu
 *
 */
@Component
public class ProductTimerTask extends TimerTask {

	@Resource
	private IProductService productService = null;
	@Resource
	private ICategoriesService categoryService = null;

	private ServletContext application = null;

	public void setApplication(ServletContext application) {
		this.application = application;
	}

	@Override
	//和监听器在项目启动的时候数据初始化的逻辑一样
	public void run() {
		System.out.println("----run----");
		List<List<Product>> bigList = new ArrayList<List<Product>>(); //bigList中存放一个装有Category类的list
		// 1. 查询出热点类别
		for(Categories category : categoryService.queryByHot(true)) {
			//根据热点类别id获取推荐商品信息
			List<Product> lst = null;
			try {
				lst = productService.querByCategoryId(category.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
			bigList.add(lst); //将装有category的list放到bigList中
		}
		// 2. 把查询的bigList交给application内置对象
		application.setAttribute("bigList", bigList);
	}
}
