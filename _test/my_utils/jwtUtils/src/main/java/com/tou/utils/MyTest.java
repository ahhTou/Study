package com.tou.utils;

public class MyTest {
    public static void main(String[] args) {

        JwtUtils.setProperty(new JwtProperty("hello ahhTou!"));

        JwtUtils.setToken("xxx").verify()
                .doHandler(data -> {
                            System.out.println(data);
                        }, err -> {
                            err.printStackTrace();
                        }
                );
    }
}
