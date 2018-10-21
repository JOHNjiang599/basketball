package org.octopusbaby.basketball.dao;

import org.apache.ibatis.annotations.Param;
import org.octopusbaby.basketball.entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 添加用户
     * @param userName
     * @param password
     * @return boolean
     */
    boolean insertUser(@Param("userName") String userName,
                       @Param("password") String password,
                       @Param("userType") String userType);

    /**
     * 获取所有用户信息
     *
     * @return User
     */
    List<User> getAllUser();

    /**
     * 通过用户名称获取用户
     *
     * @param userName
     * @return User
     */
    User getUserByName(@Param("userName") String userName);
}
