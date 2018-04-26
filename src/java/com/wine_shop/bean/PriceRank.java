package com.wine_shop.bean;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "price_rank", schema = "wine_shop", catalog = "")
public class PriceRank {
    private int id;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "min_price", nullable = true, precision = 2)
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    @Basic
    @Column(name = "max_price", nullable = true, precision = 2)
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceRank priceRank = (PriceRank) o;

        if (id != priceRank.id) return false;
        if (minPrice != null ? !minPrice.equals(priceRank.minPrice) : priceRank.minPrice != null) return false;
        if (maxPrice != null ? !maxPrice.equals(priceRank.maxPrice) : priceRank.maxPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (minPrice != null ? minPrice.hashCode() : 0);
        result = 31 * result + (maxPrice != null ? maxPrice.hashCode() : 0);
        return result;
    }
}
