package org.octopusbaby.basketball.service;

import org.apache.ibatis.annotations.Param;
import org.octopusbaby.basketball.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 用户注册
     * @param userName
     * @param password
     * @param userType
     * @return
     */
    boolean addUser(@Param("userName") String userName,
                    @Param("password") String password,
                    @Param("userType") String userType);

    /**
     * 获取所有用户
     * @return
     */
    List<User> gainAllUser();

    /**
     * 通过用户名称获取用户
     *
     * @param userName
     * @return User
     */
    User gainUserByName(@Param("userName") String userName);

    /**
     * 根据用户名删除用户
     *
     * @param userName
     * @return
     */
    boolean deleteByName(@Param("userName") String userName);

    /**
     * 根据用户名更改用户密码
     *
     * @param userName
     * @param password
     * @return
     */
    boolean modifyPassword(@Param("userName") String userName,
                           @Param("password") String password);
}
