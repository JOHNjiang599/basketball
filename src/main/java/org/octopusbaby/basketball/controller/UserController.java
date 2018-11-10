package org.octopusbaby.basketball.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.octopusbaby.basketball.dto.UserLogin;
import org.octopusbaby.basketball.dto.UserRegister;
import org.octopusbaby.basketball.entity.User;
import org.octopusbaby.basketball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理用户登录注册
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 验证登录
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserLogin userLogin) {

        System.out.println("\n用户名：" + userLogin.getUserName() +
                " 密码：" + userLogin.getPassword() + " 用户类型："
                + userLogin.getUserType() + "\n");
        //获取所有用户
        List<User> users = userService.gainAllUser();
        Map<String, Object> map = new HashMap<>();
        for (User user : users) {
            //判断是否是管理员
            if (userLogin.getUserType().equals("referee")) {
                System.out.println("\n是管理员");
                //判断用户名和密码是否相等
                boolean isSuccess = (user.getUserName()).equals(userLogin.getUserName()) &&
                        (user.getPassword()).equals(userLogin.getPassword());
                if (isSuccess) {
                    System.out.println("\n用户名,密码存在");
                    map.put("username", user.getUserName());
                    System.out.println("\nreferee  成功添加到map");
                    break;
                }
            }
            if (userLogin.getUserType().equals("user")) {
                System.out.println("\n是球队");
                boolean isSuccess = (user.getUserName()).equals(userLogin.getUserName()) &&
                        (user.getPassword()).equals(userLogin.getPassword());
                if (isSuccess) {
                    System.out.println("\n用户名,密码存在");
                    map.put("username", user.getUserName());
                    System.out.println("\nuser 成功添加到map");
                    break;
                }
            }
        }
        System.out.println("\n返回map");
        System.out.println("\nmap   " + map);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", map);
        System.out.println("\njsonObject   " + jsonObject);

        String jsonString = JSON.toJSONString(jsonObject.toString());
        System.out.println("\njsonString   " + jsonString);

        return jsonString;
    }

    /**
     * 用户注册
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(UserRegister userRegister) {

        String userType = "user";//保证为球队可注册

        System.out.println("\n用户名：" + userRegister.getUserName()
                + " 密码：" + userRegister.getPassword()
                + "重复密码：" + userRegister.getRepassword()
                + " 用户类型：" + userType + "\n");

        Map<String, Object> map = new HashMap<>();

        if (userRegister.getPassword().equals(userRegister.getRepassword())) {

            User userCheck = new User();
            userCheck.setUserName(userRegister.getUserName());
            userCheck.setPassword(userRegister.getPassword());
            userCheck.setUserType(userType);

            User valUser = userService.validateUser(userCheck);//验证注册信息是否已存在
            if (valUser == null) {//未存在则添加
                boolean isSuccess = userService.addUser(userRegister.getUserName(),
                        userRegister.getPassword(), userType);
                map.put("status", isSuccess);//返回状态
            } else {
                map.put("status", false);
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", map);
        return JSON.toJSONString(jsonObject.toString());
    }
}