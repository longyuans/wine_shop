package com.wine_shop.action;

import com.wine_shop.bean.Chateau;
import com.wine_shop.wineService.spring.ChateauServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("chateauAction")
@Scope("prototype")
public class ChateauAction extends BaseAction<Chateau>{
    @Autowired
    private ChateauServiceImpl chateauService;

    public void setChateauService(ChateauServiceImpl chateauService) {
        this.chateauService = chateauService;
    }

    public ChateauServiceImpl getChateauService() {
        return chateauService;
    }
}
