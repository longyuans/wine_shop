package com.wine_shop.dao.Hibernate;

import com.wine_shop.dao.IReportProductsDao;
import com.wine_shop.bean.ReportProducts;
import org.springframework.stereotype.Repository;

@Repository("reportProductsDao")
public class ReportProductsDaoImpl extends BaseDaoImpl<ReportProducts> implements IReportProductsDao{
}
