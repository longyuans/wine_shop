package com.wine_shop.wineService.spring;

import com.wine_shop.dao.IPriceRankDao;
import com.wine_shop.bean.PriceRank;
import com.wine_shop.wineService.IPriceRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("priceRankService")
@Transactional
public class PriceRankServiceImpl extends BaseServiceImpl<PriceRank> implements IPriceRankService {
    @Autowired
    private IPriceRankDao priceRankDao;

    public void setPriceRankDao(IPriceRankDao priceRankDao) {
        this.priceRankDao = priceRankDao;
    }

    @Override
    public List<PriceRank> queryAllPriceRanks() {
        return priceRankDao.query();
    }
}
