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
    public void registerUser(String userName, String password, String userType) {
        userDao.insertUser(userName, password, userType);
    }

    @Override
    public List<User> gainAllUser() {
        return userDao.getAllUser();
    }
}
