package com.wine_shop.wineService.spring;

import com.wine_shop.dao.Hibernate.BaseDaoImpl;
import com.wine_shop.dao.IUserDao;
import com.wine_shop.bean.User;
import com.wine_shop.wineService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
@Transactional
public class UserServiceImpl extends BaseDaoImpl<User> implements IUserService {
    @Autowired
    private IUserDao userDao;

    public void insertUser(User user) throws Exception {
        String name = user.getName();
        User u = userDao.getUserByName(user);
        if (u==null){
            userDao.insertUser(user);
        }else{
            throw new Exception("用户已存在");
        }
    }

    public User getUserByName(User user) throws Exception{
        User u = userDao.getUserByName(user);
        return u;
    }

    public void updatePassword(User user) throws Exception{
        userDao.updatePassword(user);
    }

    public void updateUser(User user) throws Exception{
        userDao.updateUser(user);
    }

    public User getUserById(long id) throws Exception{
        User user = userDao.getUserById(id);
        return user;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}


