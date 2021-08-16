package com.tou.utils.jwt.handler;


import java.util.Map;

public interface IJwtVerifySuccessHandler {
    void handle(Map<String, String> payload);
}
