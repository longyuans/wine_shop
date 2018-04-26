package com.wine_shop.wineService.spring;

import com.wine_shop.dao.IReportDao;
import com.wine_shop.bean.Report;
import com.wine_shop.wineService.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("reportService")
public class ReportServiceImpl extends BaseServiceImpl<Report> implements IReportService {
    @Autowired
    private IReportDao reportDao;

    public void setReportDao(IReportDao reportDao) {
        this.reportDao = reportDao;
    }

    @Override
    public List<Report> selectAllReportByName() {
       List<Report> reports =  reportDao.query();
        return reports;
    }
}
