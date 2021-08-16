package com.tou.utils.jwt.getter;

import java.util.Map;

public interface IStreamJwtVerifyData {

    /**
     * @return 返回该 Token 是否 有效
     */
    boolean isValid();


    /**
     * @return 返回以String为 key， Object 为 value 的 map claims
     */
    Map<String, String> getClaims();

}
