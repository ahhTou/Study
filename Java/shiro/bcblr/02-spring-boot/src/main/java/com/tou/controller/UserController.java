package com.tou.controller;

import com.tou.bean.User;
import com.tou.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public String register(User user) {
        try {
            userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "注册出现错误";
        }
        return "注册成功";
    }

    @PostMapping("/login")
    public String login(String username, String password) {

        // 获取主题对象 (安全管理器已经被注入)
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
        } catch (UnsupportedOperationException e) {
            System.out.println("用户名错误");
            return "用户名错误";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            return "密码错误";
        }


        return "登陆成功";
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "退出成功";
    }
}
