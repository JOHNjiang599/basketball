package org.octopusbaby.basketball.service;

import org.octopusbaby.basketball.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 用户注册
     *
     * @param userName
     * @param password
     * @param userType
     * @return
     */
    void registerUser(String userName, String password, String userType);

    /**
     * 获取所有用户
     *
     * @return
     */
    List<User> gainAllUser();
}
