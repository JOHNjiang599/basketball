package org.octopusbaby.basketball.service;

import org.octopusbaby.basketball.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 验证
     */
    User getUser(String userName, String password);

    /**
     * 验证用户
     *
     * @param user
     * @return
     */
    User checkUser(User user);

    /**
     * 用户注册
     * @return
     */
    boolean addUser(User user);

    /**
     * 获取所有用户
     * @return
     */
    List<User> gainAllUser();

    /**
     * 通过用户名称获取用户
     *
     * @param userName
     * @return UserLogin
     */
    User gainUserByName(String userName);

    /**
     * 根据用户名删除用户
     *
     * @param userName
     * @return
     */
    boolean deleteByName(String userName);

    /**
     * 根据用户名更改用户密码
     *
     * @param userName
     * @param password
     * @return
     */
    boolean modifyPwdByName(String userName, String password);
}
