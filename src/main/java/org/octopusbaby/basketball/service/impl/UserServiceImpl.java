package org.octopusbaby.basketball.service.impl;

import org.octopusbaby.basketball.dao.UserDao;
import org.octopusbaby.basketball.entity.User;
import org.octopusbaby.basketball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 函数说明请看接口
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(String userName, String password) {
        return userDao.getUser(userName, password);
    }

    @Override
    public User checkUser(User user) {
        return userDao.checkUser(user);
    }

    @Override
    public boolean addUser(User user) {
        if (user.getUserName() != null && !"".equals(user.getUserName())) {
            if (user.getPassword() != null && !"".equals(user.getPassword())) {
                try {
                    int addCount = userDao.insertUser(user);
                    if (addCount > 0) {
                        return true;//添加成功
                    } else {
                        throw new RuntimeException("添加用户失败");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("添加用户失败" + e.getMessage());
                }
            } else {
                throw new RuntimeException("密码不能为空");
            }
        } else {
            throw new RuntimeException("用户名不能为空");
        }
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
        if (userName != null && !"".equals(userName)) {
            try {
                int delCount = userDao.delByName(userName);
                if (delCount > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除用户失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除用户失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("用户名不能为空");
        }
    }

    @Override
    public boolean modifyPwdByName(String userName, String password) {
        if (userName != null && !"".equals(userName)) {
            if (password != null && !"".equals(password)) {
                try {
                    int modCount = userDao.modifyPwdByName(userName, password);
                    if (modCount > 0) {
                        return true;
                    } else {
                        throw new RuntimeException("修改用户信息失败");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("修改用户信息失败" + e.getMessage());
                }
            } else {
                throw new RuntimeException("密码不能为空");
            }
        } else {
            throw new RuntimeException("用户名不能为空");
        }
    }
}
