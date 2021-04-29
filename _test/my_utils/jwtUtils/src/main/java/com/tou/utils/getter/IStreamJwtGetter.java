package com.tou.utils.getter;

public interface IStreamJwtGetter {

    /**
     * @param token token
     * @return 返回本体类
     */
    IStreamJwtGetter setToken(String token);

    /**
     * @return 返回 布尔值
     */
    Boolean isValid();

    /**
     * @return 返回结果
     */
    StreamJwtVerifyData verify();




}
