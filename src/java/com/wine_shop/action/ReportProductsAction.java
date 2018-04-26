package com.wine_shop.action;

import com.wine_shop.bean.ReportProducts;
import com.wine_shop.wineService.IReportProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("reportProductsAction")
@Scope("prototype")
public class ReportProductsAction extends BaseAction<ReportProducts>{
    @Autowired
    private IReportProductService reportProductService;

    public void setReportProductService(IReportProductService reportProductService) {
        this.reportProductService = reportProductService;
    }
}
