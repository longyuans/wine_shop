package com.wine_shop.wineService;

import com.wine_shop.bean.Receiver;

import java.util.List;

public interface IReceiverService {
    List<Receiver> selectAllReceiverByUserId(int id);

    void insertReceiver(Receiver receiver);
}
