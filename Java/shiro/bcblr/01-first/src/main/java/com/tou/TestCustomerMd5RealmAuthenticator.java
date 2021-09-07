package com.tou;

import com.tou.realm.CustomerMd5Realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

public class TestCustomerMd5RealmAuthenticator {
    public static void main(String[] args) {
        DefaultSecurityManager sm = new DefaultSecurityManager();
        CustomerMd5Realm realm = new CustomerMd5Realm();

        // 设置凭证器
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        // 使用的什么算法
        matcher.setHashAlgorithmName("md5");
        // 散列次数
        matcher.setHashIterations(1024);
        realm.setCredentialsMatcher(matcher);
        sm.setRealm(realm);

        SecurityUtils.setSecurityManager(sm);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("tou", "123");

        try {
            subject.login(token);
            System.out.println("登陆成功");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        }


        // 认证用户 进行授权
        if (subject.isAuthenticated()) {
            // 1. 基于角色的权限控制
            System.out.println("admin - " + subject.hasRole("admin"));
            System.out.println("users - " + subject.hasRole("users"));
            System.out.println("super - " + subject.hasRole("super"));

            // 2. 基于多角色的权限控制
            System.out.println("super & users -" + subject.hasAllRoles(Arrays.asList("admin", "super")));

            // 3. 是否含有其中一个角色
            boolean[] booleans = subject.hasRoles(Arrays.asList("admin", "super"));
            for (boolean aBoolean : booleans) {
                System.out.println(aBoolean);
            }

            // 4. 基于权限字符串的访问控制 资源标识符:操作:资源类型
            System.out.println("资源访问权限 - " + subject.isPermitted("user:*:01"));

            // 5. 分别具有那些权限
            boolean[] permitted = subject.isPermitted("user:update:01", "order:*:01");
            for (boolean b : permitted) {
                System.out.println(b);
            }

            // 6. 同时具有那些权限
            boolean permittedAll = subject.isPermittedAll("user:update:01", "order:*:01");
            System.out.println(permittedAll);
        }


    }
}
