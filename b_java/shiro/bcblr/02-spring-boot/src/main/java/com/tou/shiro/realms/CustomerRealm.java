package com.tou.shiro.realms;

import com.tou.bean.Perms;
import com.tou.bean.User;
import com.tou.service.UserService;
import com.tou.shiro.salt.MyByteSource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/*
 * 自定义Realm
 * */
@Component("touRealm")
public class CustomerRealm extends AuthorizingRealm {

    @Resource
    protected UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("================ 授权 ================");
        String principal = (String) principalCollection.getPrimaryPrincipal();
        System.out.println("为" + principal + "授权");
        // 根据主身份信息后去 角色 和 权限信息
        User user = userService.findRolesByUsername(principal);
        if (!CollectionUtils.isEmpty(user.getRoles())) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            user.getRoles().forEach(role -> {
                System.out.println("添加的角色 -> " + role.getName());
                info.addRole(role.getName());

                // 权限信息
                List<Perms> perms = userService.findRolesByRoleId(role.getId());
                if (!CollectionUtils.isEmpty(perms) && perms.get(0) != null) {
                    perms.forEach(perm -> {
                        System.out.println("添加的权限 -> " + perm.getName());
                        info.addStringPermission(perm.getName());
                    });
                }

            });
            return info;
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("================ 认证 ================");
        String principal = (String) authenticationToken.getPrincipal();

        User user = userService.findByUsername(principal);

        if (!ObjectUtils.isEmpty(user)) {
            return new SimpleAuthenticationInfo(
                    user.getUsername(), // 用户名
                    user.getPassword(), //
                    new MyByteSource(user.getSalt()),
                    this.getName());
        }

        return null;
    }
}
