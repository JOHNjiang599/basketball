package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminDaoTest extends BaseTest {

    @Autowired
    private AdminDao adminDao;

    @Test
    public void testInsertAdmin() {
        String user = "admin";
        String password = "123456";
        int type = 1;
        boolean b = adminDao.insertAdmin(user, password, type);
        if (b) {
            System.out.println("\n\n 成功添加" + user + " " + password + "\n");
        }
    }

    @Test
    public void testGetAllAdmin() {
        Admin allAdmin = adminDao.getAllAdmin();
        System.out.println("\n\n" + allAdmin + "\n");
    }

    @Test
    public void testGetAdminByName() {
        Admin admin = adminDao.getAdminByName("admin");
        System.out.println("\n\n" + admin + "\n");
    }

}
