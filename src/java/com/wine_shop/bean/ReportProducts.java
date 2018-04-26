package com.wine_shop.bean;

import javax.persistence.*;

@Entity
@Table(name = "report_products", schema = "wine_shop", catalog = "")
public class ReportProducts {
    private int id;
    private int reportId;
    private int productId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "report_id", nullable = false)
    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    @Basic
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportProducts that = (ReportProducts) o;

        if (id != that.id) return false;
        if (reportId != that.reportId) return false;
        if (productId != that.productId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + reportId;
        result = 31 * result + productId;
        return result;
    }
}
