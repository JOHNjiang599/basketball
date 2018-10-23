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
    public void testInsertUser() {
        String user = "admin";
        String password = "123";
        String type = "球队";
        boolean b = userDao.insertUser(user, password, type);
        if (b) {
            System.out.println("\n\n 成功添加:" + user + " " + password);
        }
    }

    @Test
    public void testGetAllUser() {
        List<User> allUser = userDao.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
    }

    @Test
    public void testGetUserByName() {
        User user = userDao.getUserByName("user");
        System.out.println("\n\n" + user);
    }

}
