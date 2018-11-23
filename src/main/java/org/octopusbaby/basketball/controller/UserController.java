package org.octopusbaby.basketball.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.octopusbaby.basketball.dto.UserLogin;
import org.octopusbaby.basketball.dto.UserRegister;
import org.octopusbaby.basketball.entity.User;
import org.octopusbaby.basketball.service.TeamService;
import org.octopusbaby.basketball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {

    private final TeamService teamService;

    private final UserService userService;

    @Autowired
    public UserController(UserService userService, TeamService teamService) {
        this.userService = userService;
        this.teamService = teamService;
    }

    /**
     * 登录
     *
     * @param userLogin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public String login(UserLogin userLogin) {

        System.out.println("\n用户名：" + userLogin.getUserName() +
                " 密码：" + userLogin.getPassword() + " 用户类型："
                + userLogin.getUserType() + "\n");
        Map<String, Object> map = new HashMap<>();
        User user = userService.getUser(userLogin.getUserName(), userLogin.getPassword());
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
        return jsonString;
    }

    /**
     * 注册
     * @param userRegister
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String register(UserRegister userRegister) {
        //保证为球队注册
        String userType = "user";
        System.out.println("\n用户名：" + userRegister.getUserName() + " 密码：" + userRegister.getPassword()
                + "重复密码：" + userRegister.getRepassword() + " 用户类型：" + userType + "\n");

        Map<String, Object> map = new HashMap<>();
        if (userRegister.getPassword().equals(userRegister.getRepassword())) {
            User userCheck = new User();
            userCheck.setUserName(userRegister.getUserName());
            userCheck.setPassword(userRegister.getPassword());
            userCheck.setUserType(userType);
            //验证注册信息是否已存在
            User valUser = userService.checkUser(userCheck);
            //未存在则添加
            if (valUser == null) {
                //插入到用户表
                boolean isSuccess = userService.addUser(userCheck);
                //返回的自增主键
                System.out.println(userCheck.getUserId());
                //插入到球队表
                boolean addTeam = teamService.addTeam(userCheck.getUserId(), userCheck.getUserName());
                //返回状态
                map.put("status", isSuccess && addTeam);
            } else {
                map.put("status", false);
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", map);
        return JSON.toJSONString(jsonObject.toString());
    }
}