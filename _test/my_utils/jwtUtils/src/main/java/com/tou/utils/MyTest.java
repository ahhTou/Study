package com.tou.utils;

import com.tou.utils.creator.TokenCreator;
import com.tou.utils.verifier.TokenVerifier;

import java.util.Calendar;

public class MyTest {
    public static void main(String[] args) {

        TokenProperty.setSECRET("hello everyone");

        // 1. 通过 函数式接口来处理

        TokenVerifier.setToken("xxx").verify(data -> {
            System.out.println("Token 解析成功");
            System.out.println("data is " + data);
        }, err -> {
            System.out.println("Token 解析失败");
            System.out.println("err is " + err.getMessage());
        });

        System.out.println();

        // 2. 直接 得到Token的验证结果
        Boolean isValid1 = TokenVerifier.setToken("xxx").isValid();
        System.out.println("Token的验证结果 是 " + isValid1);
        Boolean isValid2 = TokenVerifier.setToken("xxx").isValid();
        System.out.println("Token的验证结果 是 " + isValid2);


        System.out.println();

        // 3.
        String token = TokenCreator.create(map -> map.put("hello", "hello"), Calendar.HOUR, 30);

        System.out.println("token is " + token);

        // 4.

        TokenVerifier.setToken(token).verify(
                payload -> System.out.println("payload is " + payload),
                err -> System.out.println("err is " + err.getMessage())
        );

    }
}
