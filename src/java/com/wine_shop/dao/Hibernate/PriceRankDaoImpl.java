package com.wine_shop.dao.Hibernate;

import com.wine_shop.dao.IPriceRankDao;
import com.wine_shop.bean.PriceRank;
import org.springframework.stereotype.Repository;

@Repository("priceRankDao")
public class PriceRankDaoImpl extends BaseDaoImpl<PriceRank> implements IPriceRankDao {
}
