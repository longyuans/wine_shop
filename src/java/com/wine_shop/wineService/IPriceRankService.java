package com.wine_shop.wineService;

import com.wine_shop.bean.PriceRank;

import java.util.List;

public interface IPriceRankService {
    List<PriceRank> queryAllPriceRanks();
}
