package com.tou;

import com.tou.realm.CustomerRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/*
 * 使用自定义realm
 * */
public class TestCustomerRealmAuthenticator {

    public static void main(String[] args) {
        // 创建securityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        // 设定自定义realm
        defaultSecurityManager.setRealm(new CustomerRealm());

        // 将安全工具设置为安全工具类
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        // 通过安全工具类获取subject
        Subject subject = SecurityUtils.getSubject();

        // 创建Token
        UsernamePasswordToken token = new UsernamePasswordToken("tou", "123345");

        try {
            subject.login(token);
            System.out.println(subject.isAuthenticated());
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("密码错误");
        }


    }


}
