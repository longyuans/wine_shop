package com.wine_shop.dao.Hibernate;

import com.wine_shop.dao.IReportDao;
import com.wine_shop.bean.Report;
import org.springframework.stereotype.Repository;

@Repository("reportDao")
public class ReportDaoImpl extends BaseDaoImpl<Report> implements IReportDao {

}
