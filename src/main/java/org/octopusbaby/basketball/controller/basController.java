package org.octopusbaby.basketball.controller;

import org.octopusbaby.basketball.entity.User;
import org.octopusbaby.basketball.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping(value = "user")
public class basController {

    private final UserService userService;

    @Autowired
    public basController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户注册
     *
     * @param userName
     * @param password
     * @param userType
     * @return
     */
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam("userName") String userName,
                          @RequestParam("password") String password,
                          @RequestParam("userType") String userType) {
        System.out.println("\n\n用户名：" + userName + " 密码" + password + " 用户类型：" + userType + "\n");
        List<User> users = userService.gainAllUser();
        String uri = null;
        for (User u : users) {
            if ("team".equals(userType)) {//只能球队注册
                if ((u.getUserName()).equals(userName)) {//用户名已存在
                    return "regError";
                }
            } else {
                boolean b = userService.addUser(userName, password, userType);
                if (b) {
                    System.out.println("\n\n注册成功\n");
                }
                uri = "index";
            }
        }
        return uri;
    }

    /**
     * 验证登录
     * @param userName
     * @param password
     * @param userType
     * @return
     */
    @RequestMapping(value = "validateUser", method = RequestMethod.POST)
    public String validateUser(@RequestParam("userName") String userName,
                               @RequestParam("password") String password,
                               @RequestParam("userType") String userType) {
        System.out.println("\n用户名：" + userName + " 密码：" + password + " 用户类型：" + userType +"\n");
        List<User> users = userService.gainAllUser();
        ModelAndView mv = new ModelAndView();
        for (User user : users) {
            if ((user.getUserType()).equals(userType) && "admin".equals(userType)) {
                if ((user.getUserName()).equals(userName) && (user.getPassword()).equals(password)) {

                    mv.addObject("admin", user);
                    mv.setViewName("admin");

                    return "admin";
                }
            }
            if ((user.getUserType()).equals(userType) && "team".equals(userType)) {
                if ((user.getUserName()).equals(userName) && (user.getPassword()).equals(password)) {

                    mv.addObject("user", user);
                    mv.setViewName("user");

                    return "user";
                }
            }
        }
        return "index";//验证失败，回到登录页面
    }
}
