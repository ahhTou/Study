package com.tou.utils.handler;


import com.tou.utils.getter.IStreamJwtVerifyData;

import java.util.Map;

public interface IJwtVerifySuccessHandler {
    void handle(Map<String, String> payload);
}
