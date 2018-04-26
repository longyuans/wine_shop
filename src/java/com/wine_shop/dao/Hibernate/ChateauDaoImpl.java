package com.wine_shop.dao.Hibernate;

import com.wine_shop.dao.IChateauDao;
import com.wine_shop.bean.Chateau;
import org.springframework.stereotype.Repository;

@Repository("chateauDao")
public class ChateauDaoImpl extends BaseDaoImpl<Chateau> implements IChateauDao {

}
