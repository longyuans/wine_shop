package com.wine_shop.wineService;

import com.wine_shop.bean.Report;

import java.util.List;

public interface IReportService {
    /**
     * 查询全部
     * @return
     */
    List<Report> selectAllReportByName();
}
