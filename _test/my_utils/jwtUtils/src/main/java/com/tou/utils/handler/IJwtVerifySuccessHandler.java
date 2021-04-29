package com.tou.utils.handler;


import com.tou.utils.getter.IStreamJwtVerifyData;

public interface IJwtVerifySuccessHandler {
    void handle(IStreamJwtVerifyData data);
}
