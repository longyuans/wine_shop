package com.wine_shop.dao.Hibernate;

import com.wine_shop.dao.IReceiverDao;
import com.wine_shop.bean.Receiver;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("receiverDao")
public class ReceiverDaoImpl extends BaseDaoImpl<Receiver> implements IReceiverDao {
    @Override
    public List<Receiver> queryAllReceiverByUserId(int id) {
        String hql = " from Receiver r where r.userId="+id+"";
        return (List<Receiver>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public void insertReceiver(Receiver receiver) {
        this.getHibernateTemplate().save(receiver);
    }
}
