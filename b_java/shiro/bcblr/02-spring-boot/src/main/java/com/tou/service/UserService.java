package com.tou.service;

import com.tou.bean.Perms;
import com.tou.bean.User;

import java.util.List;

public interface UserService {

    void register(User user);

    // 根据用户名查询业务的方法
    User findByUsername(String username);

    User findRolesByUsername(String username);

    // 根据角色id查询权限集合
    List<Perms> findRolesByRoleId(String id);


}
