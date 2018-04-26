package com.wine_shop.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {
    private int id;
    private String name;
    private BigDecimal price;
    private String serviceFg;
    private String serviceMyf;
    private String serviceZt;
    private String serviceTh;
    private Integer year;
    private String level;
    private int stock;
    private String description;
    private int chateauId;
    private String alcoholContent;
    private String identifier;
    private String images;
    private String chateauDescription;
    private int catDetailId;
    private Integer saleNum;
    private String flag;
    private String attributes;
    private Integer cateId;
    private String evaluates;
    private String featureImages;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "service_fg")
    public String getServiceFg() {
        return serviceFg;
    }

    public void setServiceFg(String serviceFg) {
        this.serviceFg = serviceFg;
    }

    @Basic
    @Column(name = "service_myf")
    public String getServiceMyf() {
        return serviceMyf;
    }

    public void setServiceMyf(String serviceMyf) {
        this.serviceMyf = serviceMyf;
    }

    @Basic
    @Column(name = "service_zt")
    public String getServiceZt() {
        return serviceZt;
    }

    public void setServiceZt(String serviceZt) {
        this.serviceZt = serviceZt;
    }

    @Basic
    @Column(name = "service_th")
    public String getServiceTh() {
        return serviceTh;
    }

    public void setServiceTh(String serviceTh) {
        this.serviceTh = serviceTh;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "stock")
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "chateau_id")
    public int getChateauId() {
        return chateauId;
    }

    public void setChateauId(int chateauId) {
        this.chateauId = chateauId;
    }

    @Basic
    @Column(name = "alcohol_content")
    public String getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(String alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    @Basic
    @Column(name = "identifier")
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Basic
    @Column(name = "images")
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Basic
    @Column(name = "chateau_description")
    public String getChateauDescription() {
        return chateauDescription;
    }

    public void setChateauDescription(String chateauDescription) {
        this.chateauDescription = chateauDescription;
    }

    @Basic
    @Column(name = "cat_detail_id")
    public int getCatDetailId() {
        return catDetailId;
    }

    public void setCatDetailId(int catDetailId) {
        this.catDetailId = catDetailId;
    }

    @Basic
    @Column(name = "sale_num")
    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    @Basic
    @Column(name = "flag")
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "attributes")
    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Basic
    @Column(name = "cate_id")
    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    @Basic
    @Column(name = "evaluates")
    public String getEvaluates() {
        return evaluates;
    }

    public void setEvaluates(String evaluates) {
        this.evaluates = evaluates;
    }

    @Basic
    @Column(name = "feature_images")
    public String getFeatureImages() {
        return featureImages;
    }

    public void setFeatureImages(String featureImages) {
        this.featureImages = featureImages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (stock != product.stock) return false;
        if (chateauId != product.chateauId) return false;
        if (catDetailId != product.catDetailId) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (serviceFg != null ? !serviceFg.equals(product.serviceFg) : product.serviceFg != null) return false;
        if (serviceMyf != null ? !serviceMyf.equals(product.serviceMyf) : product.serviceMyf != null) return false;
        if (serviceZt != null ? !serviceZt.equals(product.serviceZt) : product.serviceZt != null) return false;
        if (serviceTh != null ? !serviceTh.equals(product.serviceTh) : product.serviceTh != null) return false;
        if (year != null ? !year.equals(product.year) : product.year != null) return false;
        if (level != null ? !level.equals(product.level) : product.level != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (alcoholContent != null ? !alcoholContent.equals(product.alcoholContent) : product.alcoholContent != null)
            return false;
        if (identifier != null ? !identifier.equals(product.identifier) : product.identifier != null) return false;
        if (images != null ? !images.equals(product.images) : product.images != null) return false;
        if (chateauDescription != null ? !chateauDescription.equals(product.chateauDescription) : product.chateauDescription != null)
            return false;
        if (saleNum != null ? !saleNum.equals(product.saleNum) : product.saleNum != null) return false;
        if (flag != null ? !flag.equals(product.flag) : product.flag != null) return false;
        if (attributes != null ? !attributes.equals(product.attributes) : product.attributes != null) return false;
        if (cateId != null ? !cateId.equals(product.cateId) : product.cateId != null) return false;
        if (evaluates != null ? !evaluates.equals(product.evaluates) : product.evaluates != null) return false;
        if (featureImages != null ? !featureImages.equals(product.featureImages) : product.featureImages != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (serviceFg != null ? serviceFg.hashCode() : 0);
        result = 31 * result + (serviceMyf != null ? serviceMyf.hashCode() : 0);
        result = 31 * result + (serviceZt != null ? serviceZt.hashCode() : 0);
        result = 31 * result + (serviceTh != null ? serviceTh.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + stock;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + chateauId;
        result = 31 * result + (alcoholContent != null ? alcoholContent.hashCode() : 0);
        result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        result = 31 * result + (chateauDescription != null ? chateauDescription.hashCode() : 0);
        result = 31 * result + catDetailId;
        result = 31 * result + (saleNum != null ? saleNum.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        result = 31 * result + (cateId != null ? cateId.hashCode() : 0);
        result = 31 * result + (evaluates != null ? evaluates.hashCode() : 0);
        result = 31 * result + (featureImages != null ? featureImages.hashCode() : 0);
        return result;
    }
}
