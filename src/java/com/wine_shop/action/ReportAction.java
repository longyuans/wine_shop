package com.wine_shop.action;

import com.wine_shop.bean.Report;
import com.wine_shop.wineService.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("reportAction")
@Scope("prototype")
public class ReportAction extends BaseAction<Report>{
    @Autowired
    private IReportService reportService;

    public void setReportService(IReportService reportService) {
        this.reportService = reportService;
    }
}
