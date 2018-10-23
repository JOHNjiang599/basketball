package org.octopusbaby.basketball.controller;

import org.octopusbaby.basketball.dto.UserDTO;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("user")
public class basController {

    private final UserService userService;

    @Autowired
    public basController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户注册
     *
     * @return
     */
    @RequestMapping("addUser")
    public String addUser(User user, HttpServletRequest request) {
        /*String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String userType = request.getParameter("userType");*/

        System.out.println("\n\n用户名：" + user.getUserName()
                + " 密码：" + user.getPassword()
                + " 用户类型：" + user.getUserType() + "\n");

        User resultUser = userService.validateUser(user);
        if (resultUser != null) {
            System.out.println(resultUser.toString());
            request.setAttribute("user", user);
            request.setAttribute("errorMsg", "请认真核对账号、密码！");
            return "regError";
        }
        return "index";
       /*
        String uri = null;
        if(repassword.equals(password)){
            for (User u : users) {
                System.out.println("\n"+u);
                if ("team" == userType){
                    System.out.println("\n只能球队注册");
                    return "index";
                }
                if (Objects.equals(u.getUserName(), userName)){
                    System.out.println("\n用户名已存在");
                    return "index";
                }
            }
            boolean b = userService.addUser(userName, password, userType);
            if (b) {
                uri = "index";
                System.out.println("\n注册成功");
            }
        }else {
            System.out.println("\n输入密码错误");
            return "index";
        }
        return uri;*/
    }

    /**
     * 验证登录
     * @param userName
     * @param password
     * @param userType
     * @return
     */
    @RequestMapping(value = "validateUser")
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
        return "redirect:index";//验证失败，回到登录页面
    }
}
