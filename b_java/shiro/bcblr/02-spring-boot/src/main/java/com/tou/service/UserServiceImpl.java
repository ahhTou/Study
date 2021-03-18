package com.tou.service;

import com.tou.bean.Perms;
import com.tou.bean.Role;
import com.tou.bean.User;
import com.tou.dao.UserDao;
import com.tou.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public void register(User user) {
        // 处理业务调用dao

        // 1. 生成随机盐
        String salt = SaltUtils.getSalt(8);

        // 2. 将随机盐保存到数据
        user.setSalt(salt);

        // 3. 明文密码进行md5 + salt + hash 散列
        Md5Hash md5Hash =
                new Md5Hash(user.getPassword(), salt, 1024);

        user.setPassword(md5Hash.toHex());

        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findRolesByUsername(String username) {
        return userDao.findRolesByUsername(username);
    }

    @Override
    public List<Perms> findRolesByRoleId(String id) {
        return userDao.findRolesByRoleId(id);
    }
}
