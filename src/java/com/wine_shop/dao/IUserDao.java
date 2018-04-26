package com.wine_shop.dao;

import com.wine_shop.bean.User;

public interface IUserDao extends IBaseDao<User>{
    /**
     * 添加用户
     */
    public void insertUser(User user);

    /**
     * 根据姓名查找用户
     * @param user
     * @return
     */
    public User getUserByName(User user);

    /**
     * 修改密码
     * @param user
     */
    public void updatePassword(User user);

    /**
     * 修改用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据主键id查找用户
     * @param id
     * @return
     */
    public User getUserById(long id);
}
