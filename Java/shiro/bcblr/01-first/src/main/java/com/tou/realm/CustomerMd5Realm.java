package com.tou.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomerMd5Realm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("======== 授权 ========");
        String primaryPrincipal = (String) principal.getPrimaryPrincipal();
        System.out.println("身份信息：" + primaryPrincipal);

        // 根据身份信息 用户名 获取当前用户的角色信息， 以及权限信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 将数据库中查询的角色信息赋值给权限对象
        info.addRole("admin");
        info.addRole("users");

        // 将数据库中查询的权限信息赋值给权限对象
        info.addStringPermission("user:*:01");

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        if ("tou".equals(principal)) {
            String password = "8dda8e350b9167ff463701743bd2c5c5";
            String salt = "X0**at";

            // 1. 数据库用户名 2 数据库md5 + salt 之后的密码 3： 注册的盐 4. 类名
            return new SimpleAuthenticationInfo(principal, password,
                    ByteSource.Util.bytes(salt),
                    this.getName());
        }
        return null;
    }
}
