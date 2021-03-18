package com.tou;

import com.tou.bean.User;
import com.tou.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ShiroApplicationTests {

    @Resource
    UserService userService;

    @Test
    void contextLoads() {
        User username = userService.findRolesByUsername("tou2");
    }

}
