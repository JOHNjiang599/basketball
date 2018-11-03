package org.octopusbaby.basketball.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.octopusbaby.basketball.entity.User;
import org.octopusbaby.basketball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * 处理用户登录注册
 */
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
    @RequestMapping(value = "login")
    public ModelAndView login(String userName, String password, String userType,
                                     HttpSession session) {
        System.out.println("\n用户名：" + userName +
                " 密码：" + password + " 用户类型：" + userType + "\n");
        //获取所有用户
        List<User> users = userService.gainAllUser();
        ModelAndView mv = new ModelAndView();
        JSONObject jsonObj = new JSONObject();
        for (User user : users) {
            //判断是否是管理员
            if ((user.getUserType()).equals(userType) && "admin".equals(userType)) {
                //判断用户名和我密码是否相等
                if ((user.getUserName()).equals(userName) && (user.getPassword()).equals(password)) {
                   /* jsonObj.put("admin",user);//将管理员信息封装成JSON对象
                    session.setAttribute("admin", JSON.toJSONString(jsonObj.toString()));//将管理员信息返回到session中*/
                    mv.addObject("admin", "admin-login-success");//设置状态信息

                    mv.setViewName("admin");
                    return mv;
                }
            }
            if ((user.getUserType()).equals(userType) && "team".equals(userType)) {
                if ((user.getUserName()).equals(userName) && (user.getPassword()).equals(password)) {
                    /*jsonObj.put("user",user);//将用户信息封装成JSON对象
                    session.setAttribute("user", JSON.toJSONString(jsonObj.toString()));//将用户信息返回到session中*/
                    mv.addObject("user", "user-login-success");//设置状态信息
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
    @RequestMapping(value = "register")
    public ModelAndView register(String userName, String password,
                                String repassword, HttpSession session) {
        String userType = "team";//保证为球队可注册
        System.out.println("\n\n用户名：" + userName + " 密码：" + password
                + "重复密码" + repassword + " 用户类型：" + userType + "\n");
        ModelAndView mv = new ModelAndView();
        if (Objects.equals(repassword, password)) {
            JSONObject jsonObj = new JSONObject();
            User userCheck = new User();
            userCheck.setUserName(userName);
            userCheck.setPassword(password);
            userCheck.setUserType(userType);
            User valUser = userService.validateUser(userCheck);//验证注册信息是否已存在
            if (valUser == null) {//未存在则添加
                if (userService.addUser(userName, password, userType)) {//添加用户并判断返回状态
                    System.out.println("\n注册成功");
                    jsonObj.put("regUserInfo", userCheck);
                    session.setAttribute("user", JSON.toJSONString(jsonObj.toString()));
                    mv.addObject("user", "register-success");
                    //返回登录页面可由前端处理
                    //mv.setViewName("index");
                }
            } else {
                System.out.println("\n用户名已存在");
                //若存在则将错误信息发送到前端
                mv.addObject("errorMsg", "The username is exist!");
                //mv.setViewName("regError");
                return mv;
            }
        }
        return mv;
    }
}