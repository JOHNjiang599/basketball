package org.octopusbaby.basketball.controller;

import com.alibaba.fastjson.JSONObject;
import org.octopusbaby.basketball.entity.User;
import org.octopusbaby.basketball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    /**
     * 验证登录
     */
    @RequestMapping(value = "validateUser", method = RequestMethod.POST)
    public ModelAndView validateUser(String userName, String password, String userType,
                                     HttpSession session) {
        System.out.println("\n用户名：" + userName +
                " 密码：" + password + " 用户类型：" + userType + "\n");
        List<User> users = userService.gainAllUser();
        ModelAndView mv = new ModelAndView();
        JSONObject jsonObject = new JSONObject();
        for (User user : users) {
            if ((user.getUserType()).equals(userType) && "admin".equals(userType)) {
                if ((user.getUserName()).equals(userName) && (user.getPassword()).equals(password)) {
                    jsonObject.put("admin-login-success", user);
                    System.out.println(jsonObject);
                    mv.addObject("admin", jsonObject);
                    session.setAttribute("admin", jsonObject);
                    mv.setViewName("admin");
                    return mv;
                }
            }
            if ((user.getUserType()).equals(userType) && "team".equals(userType)) {
                if ((user.getUserName()).equals(userName) && (user.getPassword()).equals(password)) {
                    jsonObject.put("user-login-success", user);
                    System.out.println(jsonObject);
                    mv.addObject("user", jsonObject);
                    session.setAttribute("user", jsonObject);
                    mv.setViewName("user");
                    return mv;
                }
            }
        }
        mv.setViewName("index");
        return mv;//验证失败，回到登录页面
    }

    /**
     * 用户注册
     */
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public ModelAndView addUser(String userName, String password,
                                String repassword, HttpSession session) {
        String userType = "team";
        System.out.println("\n\n用户名：" + userName + " 密码：" + password
                + "重复密码" + repassword + " 用户类型：" + userType + "\n");
        ModelAndView mv = new ModelAndView();
        if (Objects.equals(repassword, password)) {
            JSONObject jsonObject = new JSONObject();
            User userCheck = new User();
            userCheck.setUserName(userName);
            userCheck.setPassword(password);
            userCheck.setUserType(userType);
            User valUser = userService.validateUser(userCheck);
            if (valUser == null) {
                if (userService.addUser(userName, password, userType)) {
                    System.out.println("\n注册成功");
                    jsonObject.put("reg-user-info", userCheck);
                    mv.addObject("user", jsonObject);
                    session.setAttribute("user", jsonObject);
                    //mv.setViewName("index");
                }
            } else {
                System.out.println("\n用户名已存在");
                jsonObject.put("errorMsg", "用户名已存在!");
                mv.addObject("errorMsg", jsonObject);
                //mv.setViewName("regError");
                return mv;
            }
        }
        return mv;
    }
}