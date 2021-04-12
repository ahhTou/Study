package com.tou;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;

// @SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        HashMap<String, Object> map = new HashMap<>();

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 50); // 20s 后过

        String token = JWT.create()
                .withHeader(map) // header
                .withClaim("id", "000001")
                .withClaim("username", "tou") // payLoad
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256("I am secret"));

        System.out.println(token);

    }

    @Test
    public void verify() {
        // 创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("I am secret")).build();

        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjAwMDAwMSIsImV4cCI6MTYxNjIyNTc4MywidXNlcm5hbWUiOiJ0b3UifQ._yZtxGfaZLqtv3FaZdAfZ_qoEkLsMziE88Qz3eVJp5c");

        System.out.println(verify.getClaim("id").asString());
        System.out.println(verify.getClaim("username").asString());


    }

}
