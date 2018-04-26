package com.wine_shop.wineService;

import com.wine_shop.bean.User;

public interface IUserService extends IBaseService<User>{
    /**
     * 添加用户
     */
    public void insertUser(User user) throws Exception;

    /**
     * 根据姓名查找用户
     * @param user
     * @return
     */
    public User getUserByName(User user) throws Exception;

    /**
     * 修改密码
     * @param user
     */
    public void updatePassword(User user) throws Exception;

    /**
     * 修改用户信息
     * @param user
     */
    public void updateUser(User user) throws Exception;

    /**
     * 根据主键id查找用户
     * @param id
     * @return
     */
    public User getUserById(long id) throws Exception;
}
