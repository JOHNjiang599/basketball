package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testCheckUser() {
        User userCheck = new User();
        userCheck.setUserName("");
        userCheck.setPassword("");
        userCheck.setUserType("");
        User user = userDao.checkUser(userCheck);
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        String user = "";
        String password = "";
        String type = "";
        boolean b = userDao.insertUser(user, password, type);
        if (b) {
            System.out.println("\n成功添加:" + user + " " + password);
        }
    }

    @Test
    public void testGetAllUser() {
        List<User> allUser = userDao.getAllUser();
        for (User user : allUser) {
            System.out.println("\n" + user);
        }
    }

    @Test
    public void testGetUserByName() {
        User user = userDao.getUserByName("admin");
        System.out.println("\n" + user);
    }

    @Test
    public void testDelByName() {
        String userName = "";
        boolean b = userDao.delByName(userName);
    }

    @Test
    public void testModifyPwdByName() {
        String user = "";
        String password = "";
        boolean b = userDao.modifyPwdByName(user, password);
    }
}
