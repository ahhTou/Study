package com.tou.utils.getter;

import com.tou.utils.handler.IJwtVerifyErrHandler;
import com.tou.utils.handler.IJwtVerifySuccessHandler;

public interface IStreamJwtGetter {

    /**
     * @return 返回 布尔值
     */
    Boolean isValid();

    /**
     * @return 返回结果
     */
    StreamJwtVerifyData verify();


    /**
     * @param success 成功执行函数
     * @param err     失败执行函数
     */
    void verify(IJwtVerifySuccessHandler success, IJwtVerifyErrHandler err);


}
