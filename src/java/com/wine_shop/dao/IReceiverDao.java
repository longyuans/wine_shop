package com.wine_shop.dao;

import com.wine_shop.bean.Receiver;

import java.util.List;

public interface IReceiverDao extends IBaseDao<Receiver>{
    List<Receiver> queryAllReceiverByUserId(int id);

    void insertReceiver(Receiver receiver);
}
