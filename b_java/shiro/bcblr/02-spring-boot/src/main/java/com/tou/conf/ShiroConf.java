package com.tou.conf;

import com.tou.shiro.cache.RedisCacheManager;
import com.tou.shiro.realms.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/*
 * 用来整合
 * */
@Configuration
public class ShiroConf {

    // 1. 创建shiroFilter
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager sm) {

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        // 给filter 设置安全管理器
        bean.setSecurityManager(sm);

        // 配置系统的受限资源
        // 配置系统公共资源
        Map<String, String> map = new HashMap<>();
        /*
         * authc 需要认证
         * anon 不需要认证
         * */
        map.put("/hello", "authc"); // 请求这个资源需要认证和授权
        map.put("/auth/*", "authc");
        map.put("/user/login", "anon"); // 不需要认证
        map.put("/user/register", "anon"); // 不需要认证

        // 设置默认认证界面路径 如果没有通过授权将跳转到该界面
        bean.setLoginUrl("/login");

        // 将map设置给bean
        bean.setFilterChainDefinitionMap(map);

        return bean;
    }

    // 2. 创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("realm") Realm realm) {
        DefaultWebSecurityManager sm = new DefaultWebSecurityManager();

        // 给安全管理器设置Realm
        sm.setRealm(realm);

        return sm;
    }

    // 3. 创建自定义realm
    @Bean("realm")
    public Realm getRealm(@Qualifier("touRealm") CustomerRealm customerRealm, @Qualifier("shiroRedisCacheManager") RedisCacheManager redisCacheManager) {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(1024);
        // 修改凭证校验匹配器
        customerRealm.setCredentialsMatcher(matcher);

        // 开启缓存管理
        customerRealm.setCacheManager(redisCacheManager);
        customerRealm.setCachingEnabled(true);
        customerRealm.setAuthorizationCacheName("authorizationCache");
        customerRealm.setAuthenticationCacheName("authenticationCache");
        customerRealm.setAuthenticationCachingEnabled(true); // 授权缓存
        customerRealm.setAuthorizationCachingEnabled(true); // 认证缓存

        return customerRealm;
    }
}
