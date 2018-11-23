package org.octopusbaby.basketball.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.dto.UserRegister;
import org.octopusbaby.basketball.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务层测试
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Autowired
    private TeamService teamService;

    @Test
    public void login() {
        Map<String, Object> map = new HashMap<>();
        User user = userService.getUser("custom", "8520");
        System.out.println("\n" + user);
        if (user != null) {
            map.put("status", true);
            map.put("username", user.getUserName());
            map.put("userType", user.getUserType());
        } else {
            map.put("status", false);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", map);
        System.out.println("\njsonObject   " + jsonObject);
        String jsonString = JSON.toJSONString(jsonObject.toString());
        System.out.println("\njsonString   " + jsonString);
    }

    /**
     * 验证用户合法性
     */
    @Test
    public void validateUser() {
        User userCheck = new User();
        userCheck.setUserName("");
        userCheck.setPassword("");
        userCheck.setUserType("");
        User user = userService.checkUser(userCheck);
    }

    @Test
    public void register() {
        String userType = "user";//保证为球队注册
        UserRegister userRegister = new UserRegister();
        userRegister.setUserName("test");
        userRegister.setPassword("lll");
        userRegister.setRepassword("lll");

        Map<String, Object> map = new HashMap<>();
        if (userRegister.getPassword().equals(userRegister.getRepassword())) {
            User userCheck = new User();
            userCheck.setUserName(userRegister.getUserName());
            userCheck.setPassword(userRegister.getPassword());
            userCheck.setUserType(userType);
            User valUser = userService.checkUser(userCheck);//验证注册信息是否已存在
            if (valUser == null) {//未存在则添加
                //插入到账户表
                boolean isSuccess = userService.addUser(userCheck);
                //测试返回的自增主键
                System.out.println(userCheck.getUserId());
                //插入到球队表
                boolean addTeam = teamService.addTeam(userCheck.getUserId(), userCheck.getUserName());

                map.put("status", isSuccess);//返回状态
            } else {
                map.put("status", false);
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", map);
        System.out.println(jsonObject);
    }

    /**
     * 添加一条用户信息
     */
    @Test
    public void addUser() {
        User user = new User();
        boolean b = userService.addUser(user);
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