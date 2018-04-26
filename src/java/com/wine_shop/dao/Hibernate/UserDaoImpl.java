package com.wine_shop.dao.Hibernate;

import com.wine_shop.dao.IUserDao;
import com.wine_shop.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

    /**
     * 添加用户
     * @param user
     */
    public void insertUser(User user) {
        this.getHibernateTemplate().save(user);
    }

    /**
     * 通过登录名查找用户
     * @param user
     * @return
     */
   public User getUserByName(User user) {
       String hql = "from User where name = ?";
       List<User> list  = (List<User>) this.getHibernateTemplate().find(hql,user.getName());
       if(list!=null&&list.size()>0){
           return list.get(0);
       }
       return null;
    }

    /**
     * 更新密码
     * @param user
     */
    public void updatePassword(User user) {
        this.getHibernateTemplate().update(user);
    }

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(User user) {
        this.getHibernateTemplate().update(user);
    }

    /**
     * 通过id查找
     * @param id
     * @return
     */
    public User getUserById(long id) {
        return this.getHibernateTemplate().get(User.class,id);
    }

}
