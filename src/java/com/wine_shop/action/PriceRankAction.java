package com.wine_shop.action;

import com.wine_shop.bean.PriceRank;
import com.wine_shop.wineService.IPriceRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("priceRankAction")
@Scope("prototype")
public class PriceRankAction extends BaseAction<PriceRank> {
    @Autowired
    private IPriceRankService priceRankService;
    public void setPriceRankService(IPriceRankService priceRankService) {
        this.priceRankService = priceRankService;
    }
}
