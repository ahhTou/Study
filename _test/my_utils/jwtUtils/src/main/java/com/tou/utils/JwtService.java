package com.tou.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;


public class JwtService {

    /**
     * @param token 令牌
     * @return 返回验证结果
     */
    public static DecodedJWT verify(String token, String SECRET) {
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
    }


    /**
     * @param payLoad    payload
     * @param expireDate expireDate
     * @param SECRET     SECRET
     * @return a token
     */
    public static String getToken(Map<String, String> payLoad, Date expireDate, String SECRET) {

        JWTCreator.Builder builder = JWT.create();

        if (payLoad != null) payLoad.forEach(builder::withClaim); // 设置 payload

        return builder.withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(SECRET));
    }

}
