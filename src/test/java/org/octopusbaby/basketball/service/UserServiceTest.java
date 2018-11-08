package org.octopusbaby.basketball.service;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 业务层测试
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    /**
     * 验证用户合法性
     */
    @Test
    public void validateUser() {
        User userCheck = new User();
        userCheck.setUserName("");
        userCheck.setPassword("");
        userCheck.setUserType("");
        User user = userService.validateUser(userCheck);
    }

    /**
     * 添加一条用户信息
     */
    @Test
    public void addUser() {
        String user = "";
        String password = "";
        String type = "";
        boolean b = userService.addUser(user, password, type);
    }

    /**
     * 获取所有用户信息
     */
    @Test
    public void gainAllUser() {

        List<User> users = userService.gainAllUser();
        for (User user : users) {
            System.out.println("\n" + user);
        }
    }

    /**
     * 通过用户名称获取用户信息
     */
    @Test
    public void gainUserByName() {
        User user = userService.gainUserByName("admin");
        System.out.println("\n" + user);
    }

    /**
     * 通过用户名称删除用户信息
     */
    @Test
    public void deleteByName() {
        String userName = "";
        boolean b = userService.deleteByName(userName);
    }

    /**
     * 通过用户名称修改用户密码
     */
    @Test
    public void modifyPwdByName() {
        String user = "";
        String password = "";
        boolean b = userService.modifyPwdByName(user, password);
    }
}