package com.tou.utils.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Map;

public class JwtService {

    /**
     * @param token 令牌
     * @return 返回验证结果
     */
    public static DecodedJWT verify(String token, String secret) {
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
    }

}
