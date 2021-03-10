package com.tou;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class App {
    public static void main(String[] args) {

        // 1. 创建安全管理器对象
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        // 2. 给安全管理器设置realms
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));

        // 3. SecurityUtils 全局安全的工具类, 并给其设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);

        // 4. 关键对象 Subject 主题
        Subject subject = SecurityUtils.getSubject();

        // 5. 创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("tou", "1123");

        // 6. 通过令牌登录认证
        try {
            System.out.println("认证状态 -> " + subject.isAuthenticated());
            subject.login(token);
            System.out.println("认证状态 -> " + subject.isAuthenticated());
        } catch (UnknownAccountException e) {
            System.out.println("认证失败 -> 用户名不存在");
            e.printStackTrace();
        } catch (IncorrectCredentialsException e) {
            System.out.println("认证失败 -> 密码错误");
            e.printStackTrace();
        }


    }
}
