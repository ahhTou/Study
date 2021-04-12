package com.tou.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JwtUtils {

    public static final String SECRET = "我是密钥";

    /**
     * @param payLoad   需要添加的信息
     * @param expireMin 过期时间（天）
     * @return 返回 token
     */
    public static String getToken(Map<String, String> payLoad, int expireMin) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, expireMin); // 过期时间

        JWTCreator.Builder builder = JWT.create();

        payLoad.forEach(builder::withClaim); // 设置 payload

        return builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * @param username  添加用户名信息
     * @param expireMin 过期时间（天）
     * @return 返回 token
     */
    public static String getToken(String username, int expireMin) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, expireMin); // 过期时间


        return JWT.create()
                .withClaim("username", username)
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SECRET));
    }


    /**
     * @param token 令牌
     * @return 返回验证结果
     */
    public static boolean verify(String token) {
        try {
            JWT.require(Algorithm.HMAC256("I am secret")).build().verify(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * @param token token
     * @return 解码信息
     */
    public static DecodedJWT getTokenInfo(String token) {
        try {
            return JWT.require(Algorithm.HMAC256("I am secret")).build().verify(token);
        } catch (Exception e) {
            return null;
        }
    }
}
