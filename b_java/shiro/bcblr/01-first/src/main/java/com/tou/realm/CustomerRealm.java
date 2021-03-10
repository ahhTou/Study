package com.tou.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomerRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /*
     * 认证
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 在token中获取用户名
        String principal = (String) token.getPrincipal();
        System.out.println(principal);
        if ("tou".equals(principal)) {
            // 参数1 返回数据库中确定用户名，2 返回数据库中的正确密码 3 当前realm的名字；
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("tou", "123", this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
