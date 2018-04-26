package com.wine_shop.wineService.spring;

import com.wine_shop.dao.IReceiverDao;
import com.wine_shop.bean.Receiver;
import com.wine_shop.wineService.IReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("receiverService")
@Transactional
public class ReceiverServiceImpl extends BaseServiceImpl<Receiver> implements IReceiverService {
    @Autowired
    private IReceiverDao receiverDao;

    public void setReceiverDao(IReceiverDao receiverDao) {
        this.receiverDao = receiverDao;
    }

    //查询全部收货信息
    @Override
    public List<Receiver> selectAllReceiverByUserId(int id) {
       List<Receiver> receivers = receiverDao.queryAllReceiverByUserId(id);
        return receivers;
    }
    //新增收货信息
    @Override
    public void insertReceiver(Receiver receiver) {
        receiverDao.insertReceiver(receiver);
    }
}
