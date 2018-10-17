package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminDaoTest extends BaseTest {

    @Autowired
    private AdminDao adminDao;

    @Test
    public void testAddAdmin() {
        String user = "admin";
        String password = "123456";
        boolean b = adminDao.addAdmin(user, password);
        if (b) {
            System.out.println("\n\n 成功添加" + user + " " + password);
        }
    }
}
