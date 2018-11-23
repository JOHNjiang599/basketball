package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 数据访问层测试
 */
public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    /**
     * 验证用户信息
     */
    @Test
    public void checkUser() {
        User userCheck = new User();
        userCheck.setUserName("");
        userCheck.setPassword("");
        userCheck.setUserType("");
        User user = userDao.checkUser(userCheck);
    }

    /**
     * 插入一条用户信息
     */
    @Test
    public void insertUser() {
        User user = new User();
        user.setUserName("tut");
        user.setPassword("tut");
        user.setUserType("tut");
        int insertUser = userDao.insertUser(user);
        System.out.println("插入后主键为：" + user.getUserId());
    }

    /**
     * 获取所有用户信息
     */
    @Test
    public void getAllUser() {
        List<User> users = userDao.getAllUser();
        for (User user : users) {
            System.out.println("\n" + user);
        }
    }

    /**
     * 通过用户名称获取用户信息
     */
    @Test
    public void getUserByName() {
        User user = userDao.getUserByName("admin");
    }

    /**
     * 通过用户名称删除用户信息
     */
    @Test
    public void delByName() {
        String userName = "";
        int i = userDao.delByName(userName);
    }


    /**
     * 通过用户名称修改用户密码
     */
    @Test
    public void modifyPwdByName() {
        String user = "";
        String password = "";
        int i = userDao.modifyPwdByName(user, password);
    }
}