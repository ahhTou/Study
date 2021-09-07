package com.tou.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/auth/isAdmin")
    @RequiresRoles("admin")
    public String isAdmin() {
        return "You Are Admin";
    }


    @GetMapping("/auth/userLook")
    @RequiresPermissions(value = {"user:*:*"})
    public String userLook() {
        return "You Are Admin";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
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
