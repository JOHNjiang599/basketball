package org.octopusbaby.basketball.controller;

import org.octopusbaby.basketball.entity.User;
import org.octopusbaby.basketball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping(value = "basketball")
public class basController {

    private final UserService userService;

    @Autowired
    public basController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "showRegUser")
    public String showRegUser() {
        return "regUser";
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam("userName") String userName,
                          @RequestParam("password") String password,
                          @RequestParam("userType") String userType) {
        System.out.println("\n\n用户名：" + userName + " 密码" + password + " 用户类型：" + userType + "\n");
        userService.registerUser(userName, password, userType);
        return "showLogin";
    }


    @RequestMapping(value = "showLogin")
    public String showLogin() {
        return "showLogin";
    }

    @RequestMapping(value = "validateUser", method = RequestMethod.POST)
    public String validateUser(@RequestParam("userName") String userName,
                               @RequestParam("password") String password,
                               @RequestParam("userType") String userType) {
        System.out.println("\n\n用户名：" + userName + " 密码" + password + " 用户类型：" + userType + "\n");
        List<User> users = userService.gainAllUser();
        for (User u : users) {
            System.out.println(u);
        }
        ModelAndView mv = new ModelAndView();
        for (User user : users) {
            if ((user.getUserType()).equals(userType) && "admin".equals(userType)) {
                if ((user.getUserName()).equals(userName)
                        && (user.getPassword()).equals(password)) {
                    mv.addObject("user", user);
                    return "welcome";
                }
            }
            if ((user.getUserType()).equals(userType) && "team".equals(userType)) {
                if ((user.getUserName()).equals(userName)
                        && (user.getPassword()).equals(password)) {
                    mv.addObject("team", user);
                    return "addMatchMember";
                }
            }
        }
        return "showLogin";//验证失败，回到登录页面
    }
}