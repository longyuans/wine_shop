package com.wine_shop.wineService.spring;

import com.wine_shop.dao.Hibernate.BaseDaoImpl;
import com.wine_shop.dao.IChateauDao;
import com.wine_shop.bean.Chateau;
import com.wine_shop.wineService.IChateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("chateauService")
public class ChateauServiceImpl extends BaseDaoImpl<Chateau> implements IChateauService {
    @Autowired
    private IChateauDao chateauDao;

    public void setChateauDao(IChateauDao chateauDao) {
        this.chateauDao = chateauDao;
    }

    @Override
    public List<Chateau> queryAllChateaus() {
        return chateauDao.query();
    }

    @Override
    public Chateau queryChateauById(int chateauId) {
        return chateauDao.get(chateauId);
    }
}
