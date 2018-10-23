package org.octopusbaby.basketball.service.impl;

import org.octopusbaby.basketball.dao.UserDao;
import org.octopusbaby.basketball.entity.User;
import org.octopusbaby.basketball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User validateUser(User user) {
        return userDao.checkUser(user);
    }

    @Override
    public boolean addUser(String userName, String password, String userType) {
        return userDao.insertUser(userName, password, userType);
    }

    @Override
    public List<User> gainAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User gainUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    public boolean deleteByName(String userName) {
        return userDao.delByName(userName);
    }

    @Override
    public boolean modifyPassword(String userName, String password) {
        return userDao.modifyPwd(userName, password);
    }
}
