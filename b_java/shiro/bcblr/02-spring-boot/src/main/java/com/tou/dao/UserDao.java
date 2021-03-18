package com.tou.dao;

import com.tou.bean.Perms;
import com.tou.bean.User;

import java.util.LinkedHashSet;
import java.util.List;

public interface UserDao {

    void save(User user);

    User findByUsername(String username);

    User findRolesByUsername(String username);

    // 根据角色id查询权限集合
    List<Perms> findRolesByRoleId(String id);

}
