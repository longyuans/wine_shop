package com.wine_shop.wineService;

import com.wine_shop.bean.Chateau;
import com.wine_shop.model.CategoryModel;

import java.util.List;

public interface IChateauService {

    List<Chateau> queryAllChateaus();

    Chateau queryChateauById(int chateauId);
}
