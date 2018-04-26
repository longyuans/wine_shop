package com.wine_shop.wineService.spring;

import com.wine_shop.dao.IReportProductsDao;
import com.wine_shop.bean.ReportProducts;
import com.wine_shop.wineService.IReportProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("reportProductService")
@Transactional
public class ReportProductServiceImpl extends BaseServiceImpl<ReportProducts> implements IReportProductService {
    @Autowired
    private IReportProductsDao reportProductsDao;

    public void setReportProductsDao(IReportProductsDao reportProductsDao) {
        this.reportProductsDao = reportProductsDao;
    }
}
